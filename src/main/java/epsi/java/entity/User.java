package epsi.java.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.firebase.database.annotations.NotNull;



@Entity
@Table(name="User")
public class User {
	
	@NotNull
	private Long userId;
	/**
	 * Prénom
	 */
	
	private String firstname;
	/**
	 * Nom de famille
	 */
	private String lastname;
	
	private Date dateNaissance;
	private String adresse;
	
	/**
	 * @return the userid
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the function
	 */
	public Function getFunction() {
		return function;
	}
	/**
	 * @param function the function to set
	 */
	public void setFunction(Function function) {
		this.function = function;
	}
	private Function function;
}
