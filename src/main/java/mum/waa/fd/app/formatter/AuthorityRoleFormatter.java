package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.AuthorityRole;

/**
 * {@link mum.waa.fd.app.domain.AuthorityRole} for web application, this allow us to use
 * {@link mum.waa.fd.app.domain.AuthorityRole} enumeration as a property in our model.
 *
 * @see mum.waa.fd.app.domain.AuthorityRole
 * @author Toan Quach
 * @version $Id: $Id
 */
public class AuthorityRoleFormatter implements Formatter<AuthorityRole> {

	/** {@inheritDoc} */
	@Override
	public String print(AuthorityRole authorityRole, Locale locale) {
		return authorityRole.name();
	}

	/** {@inheritDoc} */
	@Override
	public AuthorityRole parse(String text, Locale locale) throws ParseException {
		return AuthorityRole.valueOf(text);
	}
}
