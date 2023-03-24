package az.devellopia;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.management.Notification;
import javax.swing.JOptionPane;

import org.controlsfx.control.Notifications;

import az.devellopia.repository.UserRepository;
import az.devellopia.service.BookService;
import az.devellopia.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable {
	UserService service=new UserService();
	
	@FXML
	private TextField usernameTF,nameTF;
	@FXML
	private PasswordField passwordPF,passPF;
	
	private UserRepository repository=new UserRepository();
	public void login() {
		String un=usernameTF.getText();
		String ps=passwordPF.getText();
		if(repository.checkUserData(un, ps)) {
			passwordPF.setText("");
			usernameTF.setText("");
			Main.LoginUsername=un;
			try {
				Stage primaryStage=new Stage();
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Books.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}else {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Yanlş məlumat daxil etdiniz.").show();
			return;
		}
	}
	
	public void createAccountPage() {
		try {
			Stage primaryStage=new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("NewAccount.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
	
		}
	}
 public void createAccount() {
	 User user=new User();
	 String usr=nameTF.getText();
	 String  pass=passPF.getText();
	 if(usr.length()>5 && usr.length()<13 && pass.length()>5 && pass.length()<13) {
	 if(service.check(usr, pass)) {
		 
	 
	 user.setPassword(pass);
	 user.setUsername(usr);
	 service.add(user);
	 nameTF.setText("");
	 passPF.setText("");
	 Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Hesabınız yarandı").show();
		return;
 }else{
	 Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("İstifadəçi adını və ya parolunuz əvvəl istifadə edilib").show();
		return;

 }
	 }else {
		 Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Simvol sayı düzgün deyil.").show();
			return;
	 }
 }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}