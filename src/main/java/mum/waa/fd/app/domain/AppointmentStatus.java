package mum.waa.fd.app.domain;

/**
 * This enumeration control all the status of an appointment.<br />
 * Currently we have:<br />
 * New --> indicate that this appointment is just created.<br />
 * Accepted --> this appointment already accepted by the doctor<br />
 * Rejected --> was rejected by doctor since he maybe busy on that day.<br />
 * Completed --> it was done.
 * 
 * @author Toan Quach
 *
 */
public enum AppointmentStatus {

	NEW, PENDING, ACCEPTED, REJECTED, COMPLETED;
}
