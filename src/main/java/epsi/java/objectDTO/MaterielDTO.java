package epsi.java.objectDTO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Materiel")
public class MaterielDTO implements Serializable{

	private static final long serialVersionUID = -247481948390740088L;

	@XmlElement(name="materielId")
	private Long materielId;
	
	@XmlElement(name="libelle")
	private String libelle;
	
	@XmlElement(name="quantite")
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
