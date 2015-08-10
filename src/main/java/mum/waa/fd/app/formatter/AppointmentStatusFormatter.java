package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.AppointmentStatus;

/**
 * {@link AppointmentStatus} formatter for web application, this allow us to use
 * {@link AppointmentStatus} enumeration as a property in our model.
 * 
 * @see {@link AppointmentStatus}
 * 
 * @author Toan Quach
 */
public class AppointmentStatusFormatter implements Formatter<AppointmentStatus> {

	@Override
	public String print(AppointmentStatus appointmentStatus, Locale locale) {
		return appointmentStatus.name();
	}

	@Override
	public AppointmentStatus parse(String text, Locale locale) throws ParseException {
		return AppointmentStatus.valueOf(text);
	}
}
