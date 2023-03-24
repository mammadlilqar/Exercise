package az.developia.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import az.developia.Book;
import az.developia.utill.Constants;

public class BookRepository {

	public void add(Book b) {
		try {
			Connection conn=DriverManager.getConnection(Constants.DB_URL,Constants.DB_User,Constants.DB_Pass);
			Statement st=conn.createStatement();
			st.executeUpdate("insert into data (Data) values('"+b.getData()+"') ");
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
