package az.devellopia.repository;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import az.devellopia.Book;
import az.devellopia.utill.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static az.devellopia.utill.Constants.*;

public class BookRepository {

	
	public void add(Book b) {
		try {
			Connection conn = DriverManager.getConnection(dbURL, dbUser,dbPass);
			Statement st = conn.createStatement();
			st.executeUpdate("insert into books (name,author,secret_code,publish_date,register_time) "
					+ "values('" + b.getName()  + "','" + b.getAuthor() + "','" + b.getSecretCode()
					+ "','" + b.getPublishDate() + "','" + b.getRegisterTime() + "');");
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public ArrayList<Book> findAll(){
		
		ArrayList<Book> books = new ArrayList<>();
	try {
		Connection conn = DriverManager.getConnection(dbURL, dbUser,dbPass);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from books");
		

		while (rs.next()) {
			Book book = new Book();

			Integer id = rs.getInt("id");
			book.setId(id);

			String name = rs.getString("name");
			book.setName(name);

			String author = rs.getString("author");
			book.setAuthor(author);

			Date publishDate = rs.getDate("publish_date");

			LocalDate publishdate = publishDate.toLocalDate();
			book.setPublishDate(publishdate);
			books.add(book);

		}

		
		conn.close();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return books;
}
	public void delete(Integer bookId) {
		try {
			Connection conn = DriverManager.getConnection(dbURL, dbUser,dbPass);
			Statement st = conn.createStatement();
			st.executeUpdate("delete  from books where id="+bookId);
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


}
