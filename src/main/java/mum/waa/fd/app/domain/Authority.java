package mum.waa.fd.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>Authority class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
@Entity(name = "Authority")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "AUTHORITY", nullable = false)
	@Enumerated(EnumType.STRING)
	private AuthorityRole authorityRole;

	/**
	 * <p>Constructor for Authority.</p>
	 */
	public Authority() {
		// default constructor
	}

	/**
	 * <p>Getter for the field <code>id</code>.</p>
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * <p>Setter for the field <code>id</code>.</p>
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * <p>Getter for the field <code>authorityRole</code>.</p>
	 *
	 * @return the authorityRole
	 */
	public AuthorityRole getAuthorityRole() {
		return authorityRole;
	}

	/**
	 * <p>Setter for the field <code>authorityRole</code>.</p>
	 *
	 * @param authorityRole
	 *            the authorityRole to set
	 */
	public void setAuthorityRole(AuthorityRole authorityRole) {
		this.authorityRole = authorityRole;
	}
}
