package az.developia;

import javax.management.Notification;
import javax.swing.JOptionPane;

import org.controlsfx.control.Notifications;

import az.developia.service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProjectController {
	Service service = new Service();
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	public void signIn(ActionEvent event) {
		
		String usr = username.getText();
		String pass = password.getText();
		
		boolean result=service.check(usr,pass);
		username.setText("");
		password.setText("");
		if(result) {
			try {
				Stage primaryStage=new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root, 1800, 850);
		    primaryStage.setMaximized(true);		
			primaryStage.setScene(scene);
			primaryStage.setTitle("Main Page");
			primaryStage.show();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
				
		}
		else {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("İstifadəçi adı və ya parol yanlışdır!").showWarning();
			return;
		}

		}
	public void signUp(ActionEvent event) {
		try {
			Stage primaryStage=new Stage();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		Scene scene = new Scene(root);
		primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setTitle("Sign Up");
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	

}
