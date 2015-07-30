package mum.waa.fd.app.domain;

public class PatientAccount extends Account{

	private String ssn;
	
	/**
	 * @return the ssn
	 */
	public String getSSN() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
}
