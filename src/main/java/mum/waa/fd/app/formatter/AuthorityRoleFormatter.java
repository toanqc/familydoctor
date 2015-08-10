package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.AuthorityRole;

/**
 * {@link AuthorityRole} for web application, this allow us to use
 * {@link AuthorityRole} enumeration as a property in our model.
 * 
 * @see {@link AuthorityRole}
 * 
 * @author Toan Quach
 */
public class AuthorityRoleFormatter implements Formatter<AuthorityRole> {

	@Override
	public String print(AuthorityRole authorityRole, Locale locale) {
		return authorityRole.name();
	}

	@Override
	public AuthorityRole parse(String text, Locale locale) throws ParseException {
		return AuthorityRole.valueOf(text);
	}
}
