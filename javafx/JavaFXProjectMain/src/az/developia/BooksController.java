package az.developia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BooksController {
	
	@FXML
	private TextField bookName,bookAuthor;
	
 
	
	// bookPageCount
	
	public void saveBook() {
		String name=bookName.getText();
		String author=bookAuthor.getText();
		 
		// burada bu kitab melumatini bzaya yazmaq kodlarini yaz
		try {
			Connection conn=DriverManager
					.getConnection
					("jdbc:mysql://localhost:3306/java9","root","1234");
			
			Statement st=conn.createStatement();
			st.executeUpdate("insert into books (name,author) values ('"+
			name+"','"+author+"');");
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
