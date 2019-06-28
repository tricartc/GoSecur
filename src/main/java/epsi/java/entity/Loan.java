package epsi.java.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.firebase.database.annotations.NotNull;

@Entity
@Table(name="Loan")
public class Loan {
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Long materielId;
	private int quantite;
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
