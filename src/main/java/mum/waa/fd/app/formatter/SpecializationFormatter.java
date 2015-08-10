package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.Specialization;

/**
 * {@link Specialization} formatter for web application, this allow us to use
 * {@link Specialization} enumeration as a property in our model.
 * 
 * @see {@link Specialization}
 * 
 * @author Toan Quach
 */
public class SpecializationFormatter implements Formatter<Specialization> {

	@Override
	public String print(Specialization specialization, Locale locale) {
		return specialization.name();
	}

	@Override
	public Specialization parse(String text, Locale locale) throws ParseException {
		return Specialization.valueOf(text);
	}
}
