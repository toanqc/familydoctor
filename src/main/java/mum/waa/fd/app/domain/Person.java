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
/**
 * <p>Abstract Person class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
public abstract class Person {

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
	private Gender gender = Gender.MALE;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Pattern(regexp = FamilyDoctorConstants.PHONE_REGEX, message = FamilyDoctorConstants.PHONE_VALIDATION)
	@Column(name = "PHONE")
	private String phone;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	/**
	 * <p>Constructor for Person.</p>
	 */
	public Person() {
		// default constructor
	}

	/**
	 * <p>Constructor for Person.</p>
	 *
	 * @param firstName a {@link java.lang.String} object.
	 * @param lastName a {@link java.lang.String} object.
	 * @param dateOfBirth a {@link java.util.Date} object.
	 * @param gender a {@link mum.waa.fd.app.domain.Gender} object.
	 * @param phone a {@link java.lang.String} object.
	 * @param user a {@link mum.waa.fd.app.domain.User} object.
	 * @param address a {@link mum.waa.fd.app.domain.Address} object.
	 */
	public Person(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
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
	 * <p>Setter for the field <code>firstName</code>.</p>
	 *
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * <p>Getter for the field <code>firstName</code>.</p>
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <p>Setter for the field <code>firstName</code>.</p>
	 *
	 * @param firstName
	 *            the firstName to set
	 */
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * <p>Getter for the field <code>lastName</code>.</p>
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * <p>Setter for the field <code>lastName</code>.</p>
	 *
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * <p>Getter for the field <code>dateOfBirth</code>.</p>
	 *
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * <p>Setter for the field <code>dateOfBirth</code>.</p>
	 *
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * <p>Getter for the field <code>gender</code>.</p>
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * <p>Setter for the field <code>gender</code>.</p>
	 *
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * <p>Getter for the field <code>phone</code>.</p>
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * <p>Setter for the field <code>phone</code>.</p>
	 *
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * <p>Getter for the field <code>user</code>.</p>
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * <p>Setter for the field <code>user</code>.</p>
	 *
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * <p>Getter for the field <code>address</code>.</p>
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * <p>Setter for the field <code>address</code>.</p>
	 *
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
