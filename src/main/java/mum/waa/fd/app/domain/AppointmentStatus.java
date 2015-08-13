package mum.waa.fd.app.domain;

/**
 * This enumeration control all the status of an appointment.
 * Currently we have:
 * <ul>
 * <li>New : indicate that this appointment is just created.</li>
 * <li>Accepted : this appointment already accepted by the doctor</li>
 * <li>Rejected : was rejected by doctor since he maybe busy on that day.</li>
 * <li>Completed : it was done.</li>
 * </ul>
 *
 * @author Toan Quach
 * @version $Id: $Id
 */
public enum AppointmentStatus {

	NEW, ACCEPTED, REJECTED, COMPLETED, CANCELED;
}
