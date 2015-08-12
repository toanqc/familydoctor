package mum.waa.fd.app.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import mum.waa.fd.app.util.FamilyDoctorConstants;
import mum.waa.fd.app.util.FamilyDoctorUtil;

@Entity
@Table(name = "Invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int invoiceId;

	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	@Column(name = "DATE_CREATED")
	private Date dateCreated;

	@Digits(integer = 6, fraction = 2, message = FamilyDoctorConstants.AMOUNT_VALIDATION)
	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@NotNull
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private InvoiceStatus status = InvoiceStatus.NEW;

	@Column(name = "CCARD_4DIGITS")
	private String ccardLast4Digits;

	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	@Column(name = "DATE_PAID")
	private Date datePaid;

	@PrePersist
	private void setDate() {
		this.dateCreated = FamilyDoctorUtil.getCurrentDate();
	}

	/**
	 * @return the invoiceId
	 */
	public int getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @param invoiceId
	 *            the invoiceId to set
	 */
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the status
	 */
	public InvoiceStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	/**
	 * @return the ccardLast4Digits
	 */
	public String getCcardLast4Digits() {
		return ccardLast4Digits;
	}

	/**
	 * @param ccardLast4Digits
	 *            the ccardLast4Digits to set
	 */
	public void setCcardLast4Digits(String ccardLast4Digits) {
		this.ccardLast4Digits = ccardLast4Digits;
	}

	/**
	 * @return the datePaid
	 */
	public Date getDatePaid() {
		return datePaid;
	}

	/**
	 * @param datePaid
	 *            the datePaid to set
	 */
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}
}
