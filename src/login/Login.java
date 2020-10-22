package login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class Login extends Application {
	Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	window = primaryStage;
        primaryStage.setTitle("JavaFX Welcome");
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
        Scene scene = new Scene(grid, 300, 275);
        

        
        
        GridPane dashboard = new GridPane();
        dashboard.setAlignment(Pos.CENTER);
        dashboard.setHgap(10);
        dashboard.setVgap(10);
        dashboard.setPadding(new Insets(25, 25, 25, 25));
        Button back = new Button("Go Back");
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
        Scene scene2 = new Scene(dashboard,300,275);
        btn.setOnAction(e->window.setScene(scene2));
        
        window.setScene(scene);
        window.show();
        
       
        
        
        
        
        GridPane newP = new GridPane();
        newP.setAlignment(Pos.CENTER);
        newP.setHgap(10);
        newP.setVgap(10);
        newP.setPadding(new Insets(25, 25, 25, 25));
        Label name = new Label("Patient Name: ");
        Label email = new Label("Patient email address: ");
        Label phone = new Label("Patient phone number: ");
        Label egName = new Label("Emergency contact name: ");
        Label egPhone = new Label("Emergency contact phone: ");
        Label reason = new Label("Reason for admission: ");
        Label currAddress = new Label("Current Address: ");
        Label permanentAddress = new Label("Permanent Address: ");
        

        
        
        Button submit = new Button("Submit");
        Button back2 = new Button("Back");
        back2.setOnAction(e->window.setScene(scene2));
        newP.add(back2, 0, 0);
        newP.add(name, 0, 1);
        newP.add(email, 0, 2);
        newP.add(phone, 0, 3);
        newP.add(egName, 0, 4);
        newP.add(egPhone, 0, 5);
        newP.add(reason, 0, 6);
        newP.add(currAddress, 0, 7);
        newP.add(permanentAddress, 0, 8);
        newP.add(submit,0,9);
        
        Scene patientRegistration = new Scene(newP);
        newPatient.setOnAction(e->window.setScene(patientRegistration));
        
        
    }
}
