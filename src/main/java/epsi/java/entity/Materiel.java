package epsi.java.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.firebase.database.annotations.NotNull;

@Entity
@Table(name="Materiel")
public class Materiel {
	
	@NotNull
	private Long materielId;
	
	private String libelle;
	
	private int quantite;
	
	/**
	 * @return the materielId
	 */
	public Long getMaterielId() {
		return materielId;
	}
	/**
	 * @param materielId the materielId to set
	 */
	public void setMaterielId(Long materielId) {
		this.materielId = materielId;
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
	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
