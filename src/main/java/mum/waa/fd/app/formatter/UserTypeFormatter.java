package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.UserType;

/**
 * {@link UserType} for web application, this allow us to use {@link UserType}
 * enumeration as a property in our model.
 * 
 * @see {@link UserType}
 * 
 * @author Toan Quach
 */
public class UserTypeFormatter implements Formatter<UserType> {

	@Override
	public String print(UserType userType, Locale locale) {
		return userType.name();
	}

	@Override
	public UserType parse(String text, Locale locale) throws ParseException {
		return UserType.valueOf(text);
	}
}
