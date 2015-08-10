package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.InvoiceStatus;

/**
 * {@link InvoiceStatus} formatter for web application, this allow us to use
 * {@link InvoiceStatus} enumeration as a property in our model.
 * 
 * @see {@link InvoiceStatus}
 * 
 * @author Toan Quach
 */
public class InvoiceStatusFormatter implements Formatter<InvoiceStatus> {

	@Override
	public String print(InvoiceStatus invoiceStatus, Locale locale) {
		return invoiceStatus.name();
	}

	@Override
	public InvoiceStatus parse(String text, Locale locale) throws ParseException {
		return InvoiceStatus.valueOf(text);
	}
}
