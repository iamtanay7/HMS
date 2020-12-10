package hospital;

public class Patient {
	private String patient_name, patient_email, patient_phone,
	e_name, e_phone, reason, c_address, p_address;
	private int id;
	
	public Patient() {
		this.patient_name="";
		this.patient_email="";
		this.patient_phone="";
		this.e_name="";
		this.e_phone="";
		this.reason="";
		this.c_address="";
		this.p_address="";
		this.id=0;
	}
	
	public Patient(String patient_name, String patient_email, String patient_phone, String e_name, String e_phone,
			String reason, String c_address, String p_address, int id) {
		super();
		this.patient_name = patient_name;
		this.patient_email = patient_email;
		this.patient_phone = patient_phone;
		this.e_name = e_name;
		this.e_phone = e_phone;
		this.reason = reason;
		this.c_address = c_address;
		this.p_address = p_address;
		this.id = id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_email() {
		return patient_email;
	}

	public void setPatient_email(String patient_email) {
		
		if(patient_email.contains("@"))
		this.patient_email = patient_email;
		else {
			throw new IllegalArgumentException("Email should contain @");
		}
	}

	public String getPatient_phone() {
		return patient_phone;
	}

	public void setPatient_phone(String patient_phone) {
		if(patient_phone.length()!=10) {
			throw new IllegalArgumentException("Phone number should be of length 10");
		}
		this.patient_phone = patient_phone;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_phone() {
		return e_phone;
	}

	public void setE_phone(String e_phone) {
		this.e_phone = e_phone;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public String getP_address() {
		return p_address;
	}

	public void setP_address(String p_address) {
		this.p_address = p_address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
