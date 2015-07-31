package mum.waa.fd.app.domain;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

public abstract class Account {

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	private String firstName;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	private String lastName;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Pattern(regexp = FamilyDoctorConstants.PHONE_REGEX)
	private String phone;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Email(message = FamilyDoctorConstants.EMAIL_VALIDATION)
	private String email;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	private String password;

	@Valid
	private Address address;

	public Account(String firstName, String lastName, String phone, String email, String password, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
