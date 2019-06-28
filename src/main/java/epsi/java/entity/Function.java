package epsi.java.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.firebase.database.annotations.NotNull;

@Entity
@Table(name="Function")
public class Function {
	
	@NotNull
	private Long id;
	private String libelle;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
