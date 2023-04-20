package az.developia;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private DatePicker studentBirthday;
	@FXML
	private TextField studentName;
	@FXML
	private TextField studentSurname;
	public void saveMessage(){
		String name=studentName.getText();
		String surnname=studentSurname.getText();
	LocalDate bithday=studentBirthday.getValue();
	
	System.out.println(name);
	System.out.println(surnname);
	System.out.println(bithday);
	}
}
