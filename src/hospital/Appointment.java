package hospital;

import java.sql.Date;

public class Appointment {
	public Date date;
	public int time;
	public String doctor_name, patient_name;
	public Appointment() {
		// TODO Auto-generated constructor stub
		time = 0;
		doctor_name = patient_name="";
		
	}
	public Appointment(Date date, int time, String doctor_name, String patient_name) {
		this.date = date;
		this.time = time;
		this.doctor_name = doctor_name;
		this.patient_name = patient_name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	
}
