package az.developia.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import az.developia.LogVar;
import az.developia.constants.Constants;

public class SignUpRepository {

	public void add(LogVar data) {
		try {
			Connection conn=DriverManager.getConnection(Constants.dbURL,Constants.dbUser,Constants.dbPass);
			Statement st=conn.createStatement();
		st.executeUpdate("insert into users (username,password,email) values('"+data.getUsername()+"',"
				+ "'"+data.getPassword()+"','"+data.getEmail()+"')");
		
		conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public boolean checkData(String username) {
		boolean checking=true;
		try {
			Connection conn=DriverManager.getConnection(Constants.dbURL,Constants.dbUser,Constants.dbPass);
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from users where username='"+username+"'");
			if(rs.next()) {
				checking=false;
			}
		conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return checking;
	}

}
