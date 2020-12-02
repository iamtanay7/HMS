package login;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import connectivity.ConnectionClass;
import java.time.LocalDate;

public class Login extends Application {
	Connection connection;
	ConnectionClass obj;
	Stage window;
	TableView<Patient>PatientTable;
	ComboBox<String>doctorsComboBox,patientComboBox = new ComboBox<String>();
    public static void main(String[] args) {
    	launch(args);       
    }
    public ObservableList<Patient> getPatient(){ 
    	ObservableList<Patient> patients = FXCollections.observableArrayList();
    	try {
			PreparedStatement pS = connection.prepareStatement("select * from patient");
			ResultSet rs = pS.executeQuery();
			while(rs.next()) {
				Patient p = new Patient();
				p.setId(rs.getInt(1));
				p.setPatient_name(rs.getString(2));
				p.setPatient_email(rs.getString(3));			
				p.setPatient_phone(rs.getString(4));
				p.setE_name(rs.getString(5));
				p.setE_phone(rs.getString(6));
				p.setReason(rs.getString(7));
				p.setC_address(rs.getString(8));
				p.setP_address(rs.getString(9));
				System.out.println(rs.getString("patient_name"));
				
				
				patients.add(p);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return patients; 
    }
    @Override
    public void start(Stage primaryStage) throws SQLException {
    	try {
		obj = new ConnectionClass();
		connection = obj.getConnection();
		
		    	//Welcome page
    	window = primaryStage;
        primaryStage.setTitle("Hospital Management System");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
        

        Scene scene = new Scene(grid, 600, 550);
        

        //Dashboard page
        
        GridPane dashboard = new GridPane();
        dashboard.setAlignment(Pos.CENTER);
        dashboard.setHgap(10);
        dashboard.setVgap(10);
        dashboard.setPadding(new Insets(25, 25, 25, 25));
        Button back = new Button("Logout");
        Button newPatient = new Button("New Patient registration");
        Button viewPatient = new Button("View patient records");
        //Button modifyStaff = new Button("View staff details");
        Button scheduleApp = new Button("Schedule an appointment");
        dashboard.add(back, 0, 5);
        dashboard.add(newPatient, 0, 1);
        dashboard.add(viewPatient, 0, 2);
        //dashboard.add(modifyStaff, 0, 3);
        dashboard.add(scheduleApp, 0, 3);
        Text dash = new Text("Dashboard");
        dash.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        dashboard.add(dash, 0, 0, 2, 1);
        
        
        back.setOnAction(e->window.setScene(scene));
        Scene dashboardScene = new Scene(dashboard,600,550);
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		
        		if(userTextField.getText().equals("tanay") && pwBox.getText().equals("tanay")) {
        			actiontarget.setFill(Color.GREEN);
        			window.setScene(dashboardScene);
        		}
        		else {
        			actiontarget.setFill(Color.RED);
        			actiontarget.setText("Incorrect username or password");
        		}
        	};
        });
        
        window.setScene(scene);
        window.show();
        
       
        
        
        
        //New patient registration
        GridPane newPatientGrid = new GridPane();
        newPatientGrid.setAlignment(Pos.CENTER);
        newPatientGrid.setHgap(10);
        newPatientGrid.setVgap(10);
        newPatientGrid.setPadding(new Insets(25, 25, 25, 25));
        Text newPatientText = new Text("New Patient Registration");
        newPatientText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        newPatientGrid.add(newPatientText, 0, 0, 2, 1);
        
        
        Label name = new Label("Patient Name: ");
        Label email = new Label("Patient email address: ");
        Label phone = new Label("Patient phone number: ");
        Label egName = new Label("Emergency contact name: ");
        Label egPhone = new Label("Emergency contact phone: ");
        Label reason = new Label("Reason for admission: ");
        Label currAddress = new Label("Current Address: ");
        Label permanentAddress = new Label("Permanent Address: ");
        
        TextField nameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField phoneTextField = new TextField();
        TextField egNameTextField = new TextField();
        TextField egPhoneTextField = new TextField();
        TextField reasonTextField = new TextField();
        TextField currAddressTextField = new TextField();
        TextField permanentAddressTextField = new TextField();
        

        
        
        Button submit = new Button("Submit");
        Button back2 = new Button("Back");
        back2.setOnAction(e->window.setScene(dashboardScene));
        newPatientGrid.add(name, 0, 1);
        newPatientGrid.add(email, 0, 2);
        newPatientGrid.add(phone, 0, 3);
        newPatientGrid.add(egName, 0, 4);
        newPatientGrid.add(egPhone, 0, 5);
        newPatientGrid.add(reason, 0, 6);
        newPatientGrid.add(currAddress, 0, 7);
        newPatientGrid.add(permanentAddress, 0, 8);
        newPatientGrid.add(submit,0,9);
        newPatientGrid.add(back2, 1, 9);

        
        newPatientGrid.add(nameTextField, 1, 1);
        newPatientGrid.add(emailTextField, 1, 2);
        newPatientGrid.add(phoneTextField, 1, 3);
        newPatientGrid.add(egNameTextField, 1, 4);
        newPatientGrid.add(egPhoneTextField, 1, 5);
        newPatientGrid.add(reasonTextField, 1, 6);
        newPatientGrid.add(currAddressTextField, 1, 7);
        newPatientGrid.add(permanentAddressTextField, 1, 8);
        
        Scene patientRegistration = new Scene(newPatientGrid,600,550);
        newPatient.setOnAction(e->window.setScene(patientRegistration));
        
        
        //Registration successful
        GridPane regSuccessGridPane = new GridPane();
        regSuccessGridPane.setAlignment(Pos.CENTER);
        regSuccessGridPane.setHgap(10);
        regSuccessGridPane.setVgap(10);
        regSuccessGridPane.setPadding(new Insets(25, 25, 25, 25));
        Text regSuccessText = new Text("Registration successful!");
        regSuccessText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        regSuccessGridPane.add(regSuccessText, 0, 0, 2, 1);
        Button backtodashButton = new Button("Back to dashboard");
        backtodashButton.setOnAction(e->window.setScene(dashboardScene));
        regSuccessGridPane.add(backtodashButton, 1, 1);
        
        Scene regSuccessScene = new Scene(regSuccessGridPane,600,550);
        submit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				String query = "insert into patient(patient_name,patient_email,patient_phone,e_name,e_phone,reason,c_address,p_address) values (?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pStatement = connection.prepareStatement(query);
					pStatement.setString(1, nameTextField.getText());
					pStatement.setString(2, emailTextField.getText());
					pStatement.setString(3, phoneTextField.getText());
					pStatement.setString(4, egNameTextField.getText());
					pStatement.setString(5, egPhoneTextField.getText());
					pStatement.setString(6, reasonTextField.getText());
					pStatement.setString(7, currAddressTextField.getText());
					pStatement.setString(8, permanentAddressTextField.getText());
					int i = pStatement.executeUpdate();
					System.out.println(i+" records inserted");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.setScene(regSuccessScene);
				
			}
		});

        
        //Schedule appointment
        GridPane scheduleGridPane = new GridPane();
        scheduleGridPane.setAlignment(Pos.CENTER);
        scheduleGridPane.setHgap(10);
        scheduleGridPane.setVgap(10);
        scheduleGridPane.setPadding(new Insets(25, 25, 25, 25));
        Text scheduleText = new Text("Schedule an appointment");
        scheduleText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scheduleGridPane.add(scheduleText, 0, 0, 2, 1);
        
        DatePicker myDatePicker = new DatePicker();
        Label selectDateLabel = new Label("Select Date");
        Label enterTimeLabel = new Label("Enter time");
        TextField timeField = new TextField();
        Label doctorLabel = new Label("Select doctor");
        Label patientLabel = new Label("Select patient");
        ArrayList<String>patient_list = new ArrayList<String>();
        ArrayList<String>doctor_list = new ArrayList<String>();
        
        
        Button scheduleButton = new Button("Schedule");
        Button backtodashButton2 = new Button("Back");
        backtodashButton2.setOnAction(e->window.setScene(dashboardScene));
        
        scheduleGridPane.add(selectDateLabel, 0, 1);
        scheduleGridPane.add(myDatePicker, 1, 1);
        scheduleGridPane.add(enterTimeLabel, 0, 2);
        scheduleGridPane.add(timeField, 1, 2);
        scheduleGridPane.add(doctorLabel, 0, 3);
      
        scheduleGridPane.add(patientLabel, 0, 4);
        
        scheduleGridPane.add(scheduleButton, 0, 5);
        scheduleGridPane.add(backtodashButton2, 1, 5);
        
        Scene scheduleScene = new Scene(scheduleGridPane,600,550);
        
        scheduleApp.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		try {
					PreparedStatement ps = connection.prepareStatement("select patient_name from patient");
					ResultSet rs = ps.executeQuery();
					patient_list.clear();
					doctor_list.clear();
					while(rs.next()) {
						patient_list.add(rs.getString(1));
					}
					ps = connection.prepareStatement("select doctor_name from doctor");
					 rs = ps.executeQuery();
						
						while(rs.next()) {
							doctor_list.add(rs.getString(1));
						}
					
					doctorsComboBox = new ComboBox<String>(FXCollections.observableArrayList(doctor_list));
			        
			        patientComboBox = new ComboBox<String>(
			        		FXCollections.observableArrayList(patient_list)
			        		);
			        scheduleGridPane.add(doctorsComboBox, 1, 3);
			        scheduleGridPane.add(patientComboBox, 1, 4);
					window.setScene(scheduleScene);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		
        	};
        });
        
        //Appointment scheduled
        GridPane scheduleSuccessGridPane = new GridPane();
        scheduleSuccessGridPane.setAlignment(Pos.CENTER);
        scheduleSuccessGridPane.setHgap(10);
        scheduleSuccessGridPane.setVgap(10);
        scheduleSuccessGridPane.setPadding(new Insets(25, 25, 25, 25));
        Text scheduleSuccessText = new Text("Appointment scheduled!");
        scheduleSuccessText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scheduleSuccessGridPane.add(scheduleSuccessText, 0, 0, 2, 1);
        Button backtodashButton3 = new Button("Back to dashboard");
        backtodashButton3.setOnAction(e->window.setScene(dashboardScene));
        scheduleSuccessGridPane.add(backtodashButton3, 1, 1);
        
        Scene scheduleSuccessScene = new Scene(scheduleSuccessGridPane,600,550);
        scheduleButton.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent arg0) {
        		// TODO Auto-generated method stub
        		
        		try {
        			
					PreparedStatement ps = connection.prepareStatement("insert into appointment(date,time,patient_name,doctor_name) values (?,?,?,?)");
					ps.setDate(1, Date.valueOf(myDatePicker.getValue()));
					ps.setInt(2, Integer.parseInt(timeField.getText()));
					ps.setString(4, doctorsComboBox.getValue() );
					ps.setString(3, patientComboBox.getValue());
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		window.setScene(scheduleSuccessScene);
        	}
		});
        
        // Patient details table
        TableColumn<Patient, Integer> idCol = new TableColumn<>("Patient ID");
        idCol.setMinWidth(200);
        idCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("id"));
        
        TableColumn<Patient, String> nameCol = new TableColumn<>("Patient Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_name"));
        
        TableColumn<Patient, String> emailCol = new TableColumn<>("Patient Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_email"));
        
        TableColumn<Patient, String> phoneCol = new TableColumn<>("Patient Phone");
        phoneCol.setMinWidth(200);
        phoneCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_phone"));
        
        TableColumn<Patient, String> eNameCol = new TableColumn<>("Emergency Contact Name");
        eNameCol.setMinWidth(200);
        eNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("e_name"));
        
        TableColumn<Patient, String> ePhoneCol = new TableColumn<>("Emergency Contact Phone");
        ePhoneCol.setMinWidth(200);
        ePhoneCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("e_phone"));
        
        TableColumn<Patient, String> reasonCol = new TableColumn<>("Reason");
        reasonCol.setMinWidth(200);
        reasonCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("reason"));
        
       
        
        TableColumn<Patient, String> cAddressCol = new TableColumn<>("Current Address");
        cAddressCol.setMinWidth(200);
        cAddressCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("c_address"));
        
        TableColumn<Patient, String> pAddressCol = new TableColumn<>("Permanent Address");
        pAddressCol.setMinWidth(200);
        pAddressCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("p_address"));
        
        PatientTable = new TableView<Patient>();
        PatientTable.setItems(getPatient());
        PatientTable.getColumns().addAll(idCol, nameCol, emailCol, phoneCol, eNameCol, ePhoneCol, reasonCol,
        		cAddressCol, pAddressCol);
        
        VBox patientBox = new VBox();
        patientBox.getChildren().addAll(PatientTable);
        Button back3 = new Button("Back");
        back3.setOnAction(e->window.setScene(dashboardScene));
        patientBox.getChildren().add(back3);
        Scene patientDetails = new Scene(patientBox, 800,400);
        
        viewPatient.setOnAction(e->window.setScene(patientDetails));
        
        
        
    	}
    	
    	
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    	finally {
    		//connection.close();
    		System.out.println("Finished");
		}

        
        
        
        
      
        
        
    }
    
}
