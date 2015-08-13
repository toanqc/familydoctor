package mum.waa.fd.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity
/**
 * <p>Address class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int addressId;

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Pattern(regexp = FamilyDoctorConstants.STATE_REGEX, message = FamilyDoctorConstants.STATE_VALIDATION)
	@Column(name = "STATE")
	private String state;

	@Pattern(regexp = FamilyDoctorConstants.ZIPCODE_REGEX, message = FamilyDoctorConstants.ZIPCODE_VALIDATION)
	@Column(name = "ZIPCODE")
	private String zipcode;

	/**
	 * <p>Constructor for Address.</p>
	 */
	public Address() {
		// default constructor
	}

	/**
	 * <p>Constructor for Address.</p>
	 *
	 * @param street a {@link java.lang.String} object.
	 * @param city a {@link java.lang.String} object.
	 * @param state a {@link java.lang.String} object.
	 * @param zipcode a {@link java.lang.String} object.
	 */
	public Address(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	/**
	 * <p>Getter for the field <code>addressId</code>.</p>
	 *
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * <p>Setter for the field <code>addressId</code>.</p>
	 *
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * <p>Getter for the field <code>street</code>.</p>
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <p>Setter for the field <code>street</code>.</p>
	 *
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * <p>Getter for the field <code>city</code>.</p>
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <p>Setter for the field <code>city</code>.</p>
	 *
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * <p>Getter for the field <code>state</code>.</p>
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * <p>Setter for the field <code>state</code>.</p>
	 *
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * <p>Getter for the field <code>zipcode</code>.</p>
	 *
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * <p>Setter for the field <code>zipcode</code>.</p>
	 *
	 * @param zipcode
	 *            the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
