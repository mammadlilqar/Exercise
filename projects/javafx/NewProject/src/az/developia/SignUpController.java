package az.developia;

import org.controlsfx.control.Notifications;

import az.developia.service.Service;
import az.developia.service.SignUpService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignUpController {
	SignUpService service = new SignUpService();
	@FXML
	private TextField username, email;
	@FXML
	private PasswordField password;

	
	public void createAccount() {
		
		String usr = username.getText();
		String mail = email.getText();
		boolean result=mail.matches("[a-zA-Z]+[0-9]{1,3}@gmail\\.com");
		String pass = password.getText();
		LogVar login = new LogVar();
		
		if (usr.length() >= 3 && usr.length() < 13 && pass.length() > 4 && pass.length() < 13 && result) {
			if (service.checkData(usr)) {
				login.setUsername(usr);
				login.setPassword(pass);
				login.setEmail(mail);
				service.add(login);
          username.setText("");
          password.setText("");
          email.setText("");
				Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Hesabınız yarandı").showInformation();
				
			}else {
				Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Bu adda hesab artıq vardır!").showWarning();
				return;
			
			}
		} else {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Simvol sayı və ya email yazılış forması yanlışdır!").showWarning();
			return;
		}
	}
	
	public void SignIn(ActionEvent event) {
		try {
			Stage primaryStage=new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Project.fxml"));
			primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setTitle("login");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
  
	
}
