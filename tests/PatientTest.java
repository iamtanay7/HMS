import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import hospital.Patient;

public class PatientTest {
	private Patient patient;
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		patient = new Patient();

	}
	
	@Test
	public void setNameValid() {
		patient.setPatient_name("Myname");
		assertEquals("Myname", patient.getPatient_name());
		
	}
	
	@Test
	public void setEmailValid() {
		patient.setPatient_email("tanay@gmail.com");
		assertEquals("tanay@gmail.com", patient.getPatient_email());
		
	}
	
	
	@Test
	public void setEmailInvalid() {
		try {
			patient.setPatient_email("samplestring");
			fail("Email address not formatted correctly");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid arg: "+e.getMessage());
		}
		
		
	}
	
	@Test
	public void setPhoneInvalid() {
		try {
			patient.setPatient_phone("888888");
			fail("Phone number not formatted correctly");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid arg: "+e.getMessage());
		}
		
		
	}
	@Test
	public void setPhoneValid() {
		patient.setPatient_phone("9078956734");
		assertEquals("9078956734", patient.getPatient_phone());
		
	}
	
	

}
