package mum.waa.fd.app.util;

/**
 * 
 * This enumeration will be hold all the pages that available in the web
 * application
 * 
 * @author Toan Quach
 *
 */
public enum Pages {

	HOME("home"),
	PATIENT_REGISTRATION("patient-registration"),
	PATIENT_REGISTRATION_SUCCESSFUL("patient-registration-successful"),
	LOGIN("login"),
	PATIENT_HOME("patient-home");

	private String pageName;

	private Pages(String pageName) {
		this.pageName = pageName;
	}

	public String getValue() {
		return this.pageName;
	}
}
