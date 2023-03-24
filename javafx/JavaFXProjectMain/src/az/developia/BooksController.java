package az.developia;

import az.developia.service.BookService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class BooksController {
	BookService service=new  BookService();
	@FXML
	public TextField text;
    public void add() {
    	String value=text.getText();
    	Book b=new Book();
    	b.setData(value);
    	service.add(b);
    }
    public void remove() {
    	
    }
}