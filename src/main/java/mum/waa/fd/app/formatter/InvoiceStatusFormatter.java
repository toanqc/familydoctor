package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.InvoiceStatus;

/**
 * {@link mum.waa.fd.app.domain.InvoiceStatus} formatter for web application, this allow us to use
 * {@link mum.waa.fd.app.domain.InvoiceStatus} enumeration as a property in our model.
 *
 * @see mum.waa.fd.app.domain.InvoiceStatus
 * @author Toan Quach
 * @version $Id: $Id
 */
public class InvoiceStatusFormatter implements Formatter<InvoiceStatus> {

	/** {@inheritDoc} */
	@Override
	public String print(InvoiceStatus invoiceStatus, Locale locale) {
		return invoiceStatus.name();
	}

	/** {@inheritDoc} */
	@Override
	public InvoiceStatus parse(String text, Locale locale) throws ParseException {
		return InvoiceStatus.valueOf(text);
	}
}
