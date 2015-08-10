package mum.waa.fd.app.domain;

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
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int userId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Email(message = FamilyDoctorConstants.EMAIL_VALIDATION)
	@Column(name = "EMAIL")
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

	public User() {
		this.enabled = Boolean.TRUE;
		this.authorities = new ArrayList<Authority>();
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
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
