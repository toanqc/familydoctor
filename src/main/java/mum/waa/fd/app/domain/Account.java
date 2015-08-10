package mum.waa.fd.app.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@MappedSuperclass
public class Account {

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "LAST_NAME")
	private String lastName;

	@NotNull(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@NotNull
	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Pattern(regexp = FamilyDoctorConstants.PHONE_REGEX, message = FamilyDoctorConstants.PHONE_VALIDATION)
	@Column(name = "PHONE")
	private String phone;

	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	public Account() {
		// default constructor
	}

	public Account(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.user = user;
		this.address = address;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
