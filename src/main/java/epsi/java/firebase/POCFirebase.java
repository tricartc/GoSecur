package epsi.java.firebase;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Hello world!
 *
 */
public class POCFirebase {
	
	FirestoreOptions store = null;
	
	private static final Logger log= LogManager.getLogger(POCFirebase.class);
    	       
    private static FileInputStream openJsonFile(String fname) throws FileNotFoundException {
        FileInputStream serviceAccount;
        File file = new File(POCFirebase.class.getClassLoader()
                .getResource(fname).getFile());
        if (!file.exists())
            log.error("READ ERROR ....");

        serviceAccount = new FileInputStream(file);
        return serviceAccount;
    }
    private class Parameter{
		private String parameter;
		private String key;
		private String value;
		
		Parameter(String parameter){
			this.parameter = parameter;
			String[] tab = parameter.split("=");
			key = tab[0];
			value=tab[1];
		}
		
		public String getKey() {
			return key;
		}
		
		public String getValue() {
			return value;
		}
			
	}
	

	
	public static void main(String[] args) {	
		System.out.println("<<<<<<START>>>>>>");
		POCFirebase apps = new POCFirebase();
		FileInputStream serviceAccount = null;
		FirebaseApp  app = null;
		String jsFname = null;
		String jsProject = null;
		
		for(int i=0; i< args.length;i++) {
			log.info("i["+i+"] = "+args[i]);
			POCFirebase.Parameter p = apps.new Parameter(args[i]);
			log.info("k["+i+"] = "+p.getKey());
			log.info("v["+i+"] = "+p.getValue());
			if ( p.getKey().equals("-json.file"))
				jsFname=p.getValue();
			if ( p.getKey().equals("-project.id"))
				jsProject = p.getValue();
		}
		
		try {

			serviceAccount = openJsonFile(jsFname);

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://epsi-java.firebaseio.com/").build();

			app = FirebaseApp.initializeApp(options);
			
			log.info("INITIALIZE COMPLETE ....");

		} catch (FileNotFoundException e) {
			log.error("ERROR While get Google service :" + e);
		} catch (IOException e) {
			log.error("ERROR While get Google service :" + e);
		}


		
		DatabaseReference ref = FirebaseDatabase.getInstance()
			    .getReference("users");

		if ( ref != null )
			log.info(" Reference to Users is OK :"+ref.getDatabase());
		
		ref.orderByChild("name").addChildEventListener(new ChildEventListener() {
			
			@Override
			public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
				log.info("onChildAdded");
				User u = snapshot.getValue(User.class);
				log.info(snapshot.getKey() + " - "+ u);
			}

			@Override
			public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildRemoved(DataSnapshot snapshot) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
				
				
			}

			@Override
			public void onCancelled(DatabaseError error) {
				
				
			}
			
		});
		

		
		FirestoreOptions store = null;
		
		try {
			serviceAccount = openJsonFile(jsFname);
			store = FirestoreOptions.newBuilder()
				.setTimestampsInSnapshotsEnabled(true).setProjectId(jsProject)
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();
		} catch (IOException e1) {
			log.error("ERROR While FirestoreOptions BUILD : "+e1.getLocalizedMessage());
		}
		
		FirebaseAuth mAuth = FirebaseAuth.getInstance();
		
		// Pas nécessaire pour lire une collection
		//
		UserRecord  currentUser = null ;
		Long verId = 0l;
		try {
			currentUser = mAuth.getUserByEmail("tarhack@gmail.com");
			verId = currentUser.getTokensValidAfterTimestamp()/1000;
		} catch (FirebaseAuthException e1) {
			log.error("ERROR While getUserByEmail :"+e1.getLocalizedMessage());
		}
		
		if ( currentUser != null )
			log.info("User :"+currentUser.getUid()+" is connected ..."+verId);
		else
			log.error("User NOT Connected ...");
		
		// END
		
		Firestore db = store.getService();

		CountDownLatch done = new CountDownLatch(1);
		 
		ApiFuture<QuerySnapshot> query = db.collection("users").orderBy("id").get();
		ApiFuture<QuerySnapshot> last = db.collection("users").orderBy("id").get();
		last = db.collection("users").orderBy("id",Direction.DESCENDING).limit(1).get();
		
		QuerySnapshot querySnapshot = null ;
		QuerySnapshot lastQ = null ;
		
		
		try {
			querySnapshot = query.get();
			lastQ = last.get();
			
		} catch (InterruptedException | ExecutionException e) {
			log.error("ERROR While QuerySnapshot Get :"+e.getLocalizedMessage());
		}
		
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		List<QueryDocumentSnapshot> lastdoc = lastQ.getDocuments();

		log.info("Total Max(id) founded :"+lastdoc.size());
		
		Long lastId = lastdoc.get(0).toObject(User.class).getId();
		
		log.info("Last Id founded : "+lastId);
		
		log.info("Total documents founded :"+documents.size());
		
		documents.forEach(d->{
			User u = d.toObject(User.class);
			log.info(u);
		});
		
		User user = new User(lastId+1, "Java","Created from Java API "+LocalTime.now(), Timestamp.valueOf(LocalDateTime.now()));
		
		String clazz = user.getClass().getSimpleName();
		log.info("Classe Name :"+clazz);
		
		
		ApiFuture<WriteResult> future = db.collection("users").document().create(user);
		
		// block on response if required
		try {
			
			log.info("Update time : " + future.get().getUpdateTime());
		} catch (InterruptedException | ExecutionException e) {
			log.error("ERROR While get Future info :"+e.getLocalizedMessage());
		}
	}
}
   
