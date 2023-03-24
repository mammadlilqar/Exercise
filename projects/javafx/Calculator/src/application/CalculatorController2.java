package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController2 {
	@FXML
    private TextField result;
	
	String op="";
	long number1;
	long number2;
	
	public void number(ActionEvent ae) {
		String no=((Button)ae.getSource()).getText();
	    result.setText(result.getText()+no);
	}
	public void operation(ActionEvent ae) {
		String operation=((Button)ae.getSource()).getText();
		if(!operation.equals("=")) {
			if(!op.equals("")) {
				return;
			}
			op=operation;
			number1=Long.parseLong(result.getText());
			result.setText("");
		}else {
			if(op.equals("")) {
				return;
			}
			number2=Long.parseLong(result.getText());
			calculate(number2, number1, op);
			op="";
					
		}
		
	}
	public void calculate(long n1,long n2,String op) {
		switch(op) {
		case "+":
			result.setText(n1+n2+"");
			break;
		case "-":
			result.setText(n1-n2+"");
			break;
		case "*":
			result.setText(n1*n2+"");
			break;
		case "/":
			if(n2==0) {
				result.setText("0");
				break;
			}
			result.setText(n1/n2+"");
			break;
		}
		}
}
