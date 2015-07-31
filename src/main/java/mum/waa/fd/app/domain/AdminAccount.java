package mum.waa.fd.app.domain;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

public class AdminAccount extends Account {

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	private String staffNumber;

	public AdminAccount(String firstName, String lastName, String phone, String email, String password, Address address,
			String staffNumber) {
		super(firstName, lastName, phone, email, password, address);
		this.staffNumber = staffNumber;
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
