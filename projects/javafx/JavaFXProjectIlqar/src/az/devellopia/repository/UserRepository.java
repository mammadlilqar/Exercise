package az.devellopia.repository;

import java.sql.Connection;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import az.devellopia.Book;
import az.devellopia.User;
import az.devellopia.utill.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static az.devellopia.utill.Constants.*;

public class UserRepository {

	
	public boolean checkUserData(String username,String Password){
		boolean result=false;
	try {
		Connection conn = DriverManager.getConnection(dbURL, dbUser,dbPass);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from users where username='"+username+"' and password='"+Password+"' ");
		if(rs.next()) {
			result=true;
		}


		
		conn.close();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return result;
}

	public void add(User user) {
		
		try {
			Connection conn = DriverManager.getConnection(dbURL, dbUser,dbPass);
			
			Statement st = conn.createStatement();
			st.executeUpdate("insert into users (username,password) values('"+user.username+"','"+user.password+"') ");
			
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	 public boolean checkData(String username,String password) {
	boolean checkingResult=true;
		 try {
				Connection conn = DriverManager.getConnection(dbURL, dbUser,dbPass);
				
				Statement st = conn.createStatement();
 ResultSet rs=st.executeQuery("select * from users where username='"+username+"' and password='"+password+"'");
		if(rs.next()) {
			checkingResult=false;
			
		}
  
  
  
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		 return checkingResult;
	 }
	
	
}
