package epsi.java.firebase;

import java.util.Date;

public class User {
	public final static String entityName = "users";

    private Long               id;
    private String             name;
    private String             label;
    private Date               cdate;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public static String getEntityname() {
		return entityName;
	}

	public User() {
    }

    public User( Long id, String name, String label, Date cdate ) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.cdate = cdate;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel( String label ) {
        this.label = label;
    }
}	
