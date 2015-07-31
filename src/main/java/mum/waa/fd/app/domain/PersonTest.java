package mum.waa.fd.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

/**
 * This class is for testing purpose
 * @author Toan Quach
 */

@Entity
@Table(name = "Person")
public class PersonTest {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "firstName")
	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	String firstName;

	@Column(name = "lastName")
	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
