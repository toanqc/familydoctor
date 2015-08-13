package mum.waa.fd.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity
/**
 * <p>Admin class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
@Table(name = "Admin")
public class Admin extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int adminId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "STAFF_NUMBER")
	private String staffNumber;

	/**
	 * <p>Constructor for Admin.</p>
	 */
	public Admin() {
		// default constructor
	}

	/**
	 * <p>Constructor for Admin.</p>
	 *
	 * @param firstName a {@link java.lang.String} object.
	 * @param lastName a {@link java.lang.String} object.
	 * @param dateOfBirth a {@link java.util.Date} object.
	 * @param gender a {@link mum.waa.fd.app.domain.Gender} object.
	 * @param phone a {@link java.lang.String} object.
	 * @param user a {@link mum.waa.fd.app.domain.User} object.
	 * @param address a {@link mum.waa.fd.app.domain.Address} object.
	 * @param staffNumber a {@link java.lang.String} object.
	 */
	public Admin(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Address address, String staffNumber) {
		super(firstName, lastName, dateOfBirth, gender, phone, user, address);
		this.staffNumber = staffNumber;
	}

	/**
	 * <p>Getter for the field <code>adminId</code>.</p>
	 *
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * <p>Setter for the field <code>adminId</code>.</p>
	 *
	 * @param adminId
	 *            the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * <p>Getter for the field <code>staffNumber</code>.</p>
	 *
	 * @return the staffNumber
	 */
	public String getStaffNumber() {
		return staffNumber;
	}

	/**
	 * <p>Setter for the field <code>staffNumber</code>.</p>
	 *
	 * @param staffNumber
	 *            the staffNumber to set
	 */
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
}
