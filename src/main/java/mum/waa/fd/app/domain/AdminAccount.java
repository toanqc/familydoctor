package mum.waa.fd.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity
@Table(name = "AdminAccount")
public class AdminAccount extends Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int adminId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "STAFF_NUMBER")
	private String staffNumber;

	public AdminAccount(String firstName, String lastName, String phone, User user, Address address,
			String staffNumber) {
		super(firstName, lastName, phone, user, address);
		this.staffNumber = staffNumber;
	}

	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId
	 *            the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the staffNumber
	 */
	public String getStaffNumber() {
		return staffNumber;
	}

	/**
	 * @param staffNumber
	 *            the staffNumber to set
	 */
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
}
