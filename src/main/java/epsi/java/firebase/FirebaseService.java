package epsi.java.firebase;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.util.Collections;
	import java.util.List;
	import java.util.concurrent.ExecutionException;

	import javax.annotation.PostConstruct;

	import com.google.api.core.ApiFuture;
	import com.google.auth.oauth2.GoogleCredentials;
	import com.google.cloud.firestore.DocumentReference;
	import com.google.cloud.firestore.DocumentSnapshot;
	import com.google.cloud.firestore.Firestore;
	import com.google.cloud.firestore.WriteResult;
	import com.google.firebase.FirebaseApp;
	import com.google.firebase.FirebaseOptions;
	import com.google.firebase.cloud.FirestoreClient;
	import com.google.firebase.database.DatabaseReference;
	import com.google.firebase.database.FirebaseDatabase;

	public class FirebaseService {
		private FirebaseDatabase database;
		private DatabaseReference ref;
		private Firestore db;



		public List<User> findAll() {

			return Collections.emptyList();
		}

		public User findById(String id) {
			DocumentReference docRef = db.collection("users").document(id);
			// asynchronously retrieve the document
			ApiFuture<DocumentSnapshot> future = docRef.get();
			// ...
			// future.get() blocks on response
			DocumentSnapshot document;
			try {
				document = future.get();
				if (document.exists()) {


					User u = document.toObject(User.class);
					return u;
				} else {
					System.out.println("No such document!");
				}



			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			return null;
		}


		@PostConstruct
		public void before() throws IOException {

			// Use a service account
			InputStream serviceAccount = new FileInputStream(User.class.getResource("/service-account-file.json").getPath());
			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(credentials)
					.build();
			FirebaseApp.initializeApp(options);

			db = FirestoreClient.getFirestore();



			DocumentReference docRef = db.collection("users").document("5L");

			/*	Info user1 = new Info(1L, "Jean", "Lasticot", "0606060606");
			user1.getInventory().giveItems(Item.TASER, Item.GILET_PAR_BALLES);

			List<Info> users = new ArrayList<>();
			users.add(user1);
			users.add(new Info(2L, "Michel", "Lamartine", "0606350606"));
			users.add(new Info(3L, "Jean-Michel", "Lepen", "0606060526"));*/

			/*Map<String, Object> data = new HashMap<>();
			data.put("first", "Alan");
			data.put("middle", "Mathison");
			data.put("last", "Turing");
			data.put("born", 1912);*/

		//	ApiFuture<WriteResult> result = docRef.set(new Info(5L, "Michelle", "Lamartine", "0606350606"));

			/*try {
				System.out.println("Update time : " + result.get().getUpdateTime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/








			/*
			URL sqlScriptUrl = Info.class.getResource("/service-account-file.json");
			FileInputStream serviceAccount = new FileInputStream(sqlScriptUrl.getPath());
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://gosecur-be0f6.firebaseio.com").build();

			FirebaseApp.initializeApp(options);

			database = FirebaseDatabase.getInstance();
			ref = database.getReference("users");
			ref.keepSynced(true);*/

			//		User user1 = new User(1L, "Jean", "Lasticot", "0606060606");
			//		user1.getInventory().giveItems(Item.TASER, Item.GILET_PAR_BALLES);
			//		
			//		List<User> users = new ArrayList<>();
			//		users.add(user1);
			//		users.add(new User(2L, "Michel", "Lamartine", "0606350606"));
			//		users.add(new User(3L, "Jean-Michel", "Lepen", "0606060526"));

			//		ref.setValueAsync(users);

		}
	}

