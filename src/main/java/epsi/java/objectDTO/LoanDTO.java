package epsi.java.objectDTO;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoanDTO implements Serializable{

	private static final long serialVersionUID = 4786842629184870169L;
	@XmlElement
	private Long userId;
	@XmlElement
	private Long materielId;
	@XmlElement
	private int quantite;
	@XmlElement
	private Date dateLoan;
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	/**
	 * @return the dateLoan
	 */
	public Date getDateLoan() {
		return dateLoan;
	}
	/**
	 * @param dateLoan the dateLoan to set
	 */
	public void setDateLoan(Date dateLoan) {
		this.dateLoan = dateLoan;
	}
	
}
