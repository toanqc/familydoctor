package mum.waa.fd.app.util;

public class FamilyDoctorConstants {

	public static final String DATE_FORMAT = "MM/dd/yyyy";

	/* validation section */
	public static final String PHONE_REGEX = "^(\\d{3})[- ]?(\\d{3})[- ]?(\\d{4})$";
	public static final String ZIPCODE_REGEX = "^\\d{5}(-\\d{4})?$";
	public static final String STATE_REGEX = "^(?:[A-Za-z]{2}|)$";

	public static final String EMPTY_VALIDATION = "{empty.validation}";
	public static final String EMAIL_VALIDATION = "{email.validation}";
	public static final String PHONE_VALIDATION = "{phone.validation}";
	public static final String AMOUNT_VALIDATION = "{amount.validation}";
	public static final String EXACTLY_DIGITS_VALIDATION = "{exactly.digits.validation}";
	public static final String EXACTLY_CHARACTERS_VALIDATION = "{exactly.characters.validation}";
	public static final String ZIPCODE_VALIDATION = "{zipcode.validation}";
	public static final String STATE_VALIDATION = "{state.validation}";
	public static final String PASSWORD_NOTMATCH_VALIDATION = "password.notmatch.validation";
	/* end validation section */
}
