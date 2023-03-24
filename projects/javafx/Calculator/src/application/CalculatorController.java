package application;

import javax.management.Notification;

import org.controlsfx.control.Notifications;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class CalculatorController {
	@FXML
	private TextField result;
	String numValue;
	String opValue;
	long number1;
	long number2;

	@FXML
	void number(ActionEvent event) {
		numValue = ((Button) event.getSource()).getText();
		result.setText(result.getText() + numValue);
	}

	@FXML
	void operation(ActionEvent event) {
		opValue = ((Button) event.getSource()).getText();
		if (opValue!="=") {
			
			if (opValue=="") {
				return;
			}
			number1 = Long.parseLong(result.getText());
			System.out.println(number1);
		} else if(opValue=="="){
			System.out.println("2");
			
			
		}
	}

}
