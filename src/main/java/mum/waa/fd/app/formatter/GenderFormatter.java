package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.Gender;

/**
 * {@link Gender} formatter for web application, this allow us to use Gender
 * enumeration as a property in our model.
 * 
 * @see {@link Gender}
 * 
 * @author Toan Quach
 */
public class GenderFormatter implements Formatter<Gender> {

	@Override
	public String print(Gender gender, Locale locale) {
		return gender.name();
	}

	@Override
	public Gender parse(String text, Locale locale) throws ParseException {
		return Gender.valueOf(text);
	}
}
