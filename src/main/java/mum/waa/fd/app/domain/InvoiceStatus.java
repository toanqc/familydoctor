package mum.waa.fd.app.domain;

/**
 * This class hold all the value that is possible for an invoice.<br />
 * Currently we have:<br />
 * New --> indicate that this invoice is just created.<br />
 * Pending --> indicate that this invoice is in progress and waiting for
 * customer to pay.<br />
 * Paid --> indicate that this invoice is already paid by customer.
 * 
 * @author Toan Quach
 *
 */
public enum InvoiceStatus {

	NEW, PENDING, PAID;
}
