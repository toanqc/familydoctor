package mum.waa.fd.app.util;

public enum Pages {

	HOME("home"), PATIENT_REGISTRATION("patient-registration"),
	PATIENT_REGISTRATION_SUCCESSFUL("patient-registration-successful");

	private String pageName;

	private Pages(String pageName) {
		this.pageName = pageName;
	}

	public String getValue() {
		return this.pageName;
	}
}
