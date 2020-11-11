package login;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import javafx.application.Application;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import connectivity.ConnectionClass;
public class Login extends Application {
	Connection connection;
	ConnectionClass obj;
	Stage window;
	
    public static void main(String[] args) {
    	launch(args);       
    }
  
    @Override
    public void start(Stage primaryStage) {
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
        Button modifyPatient = new Button("View/modify patient records");
        Button modifyStaff = new Button("View/modify staff details");
        Button scheduleApp = new Button("Schedule an appointment");
        dashboard.add(back, 0, 5);
        dashboard.add(newPatient, 0, 1);
        dashboard.add(modifyPatient, 0, 2);
        dashboard.add(modifyStaff, 0, 3);
        dashboard.add(scheduleApp, 0, 4);
        Text dash = new Text("Dashboard");
        dash.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        dashboard.add(dash, 0, 0, 2, 1);
        
        
        back.setOnAction(e->window.setScene(scene));
        Scene dashboardScene = new Scene(dashboard,600,550);
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		
        		if(userTextField.getText().equals("tanay") && pwBox.getText().equals("tanay")) {
        			actiontarget.setFill(Color.GREEN);
        			actiontarget.setText("Login successful");
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
        submit.setOnAction(e->window.setScene(regSuccessScene));

        
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
        String doctor_list[] = {
        		"Dr. ABC", "Dr. XYZ", "Dr. PQR"
        		
        };
        ComboBox doctorsComboBox = new ComboBox(FXCollections.observableArrayList(doctor_list));
        String patient_list[] = {
        		"Patient A", "Patient B", "Patient C"
        };
        ComboBox<String>patientComboBox = new ComboBox<String>(
        		FXCollections.observableArrayList(patient_list)
        		);
        
        Button scheduleButton = new Button("Schedule");
        Button backtodashButton2 = new Button("Back");
        backtodashButton2.setOnAction(e->window.setScene(dashboardScene));
        
        scheduleGridPane.add(selectDateLabel, 0, 1);
        scheduleGridPane.add(myDatePicker, 1, 1);
        scheduleGridPane.add(enterTimeLabel, 0, 2);
        scheduleGridPane.add(timeField, 1, 2);
        scheduleGridPane.add(doctorLabel, 0, 3);
        scheduleGridPane.add(doctorsComboBox, 1, 3);
        scheduleGridPane.add(patientLabel, 0, 4);
        scheduleGridPane.add(patientComboBox, 1, 4);
        scheduleGridPane.add(scheduleButton, 0, 5);
        scheduleGridPane.add(backtodashButton2, 1, 5);
        
        Scene scheduleScene = new Scene(scheduleGridPane,600,550);
        scheduleApp.setOnAction(e->window.setScene(scheduleScene));
        
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
        scheduleButton.setOnAction(e->window.setScene(scheduleSuccessScene));
        
        
        
        
        connection.close();
        
    	}
    	
    	
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}

        
        
        
        
      
        
        
    }
    
}
