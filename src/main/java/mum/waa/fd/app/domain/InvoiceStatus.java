package mum.waa.fd.app.domain;

/**
 * This class hold all the value that is possible for an invoice.
 * Currently we have:
 * <ul>
 * <li>New : indicate that this invoice is just created.</li>
 * <li>Pending : indicate that this invoice is in progress and waiting for
 * customer to pay.</li>
 * <li>Paid : indicate that this invoice is already paid by customer.</li>
 * </ul>
 *
 * @author Toan Quach
 * @version $Id: $Id
 */
public enum InvoiceStatus {

	NEW, PENDING, PAID;
}
