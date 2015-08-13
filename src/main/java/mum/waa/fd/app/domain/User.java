package mum.waa.fd.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity
/**
 * <p>User class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = -622855600192016623L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int userId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Email(message = FamilyDoctorConstants.EMAIL_VALIDATION)
	@Column(name = "EMAIL", unique = true)
	private String email;

	@Size(min = 5, max = 100, message = FamilyDoctorConstants.RANGE_LETTERS_VALIDATION)
	@Column(name = "PASSWORD")
	private String password;

	@Size(min = 5, max = 100, message = FamilyDoctorConstants.RANGE_LETTERS_VALIDATION)
	@Transient
	private String confirmPassword;

	@NotNull
	@Column(name = "ENABLED")
	private Boolean enabled;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")
	private List<Authority> authorities;

	/**
	 * <p>Constructor for User.</p>
	 */
	public User() {
		this.enabled = Boolean.TRUE;
		this.authorities = new ArrayList<Authority>();
	}

	/**
	 * <p>Getter for the field <code>userId</code>.</p>
	 *
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * <p>Setter for the field <code>userId</code>.</p>
	 *
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * <p>Getter for the field <code>email</code>.</p>
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <p>Setter for the field <code>email</code>.</p>
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * <p>Getter for the field <code>password</code>.</p>
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <p>Getter for the field <code>confirmPassword</code>.</p>
	 *
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * <p>Setter for the field <code>confirmPassword</code>.</p>
	 *
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * <p>Setter for the field <code>password</code>.</p>
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * <p>Getter for the field <code>enabled</code>.</p>
	 *
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * <p>Setter for the field <code>enabled</code>.</p>
	 *
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * <p>Getter for the field <code>authorities</code>.</p>
	 *
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * <p>Setter for the field <code>authorities</code>.</p>
	 *
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	// /**
	// * @return the userType
	// */
	// public UserType getUserType() {
	// return userType;
	// }
	//
	// /**
	// * @param userType
	// * the userType to set
	// */
	// public void setUserType(UserType userType) {
	// this.userType = userType;
	// }
}
