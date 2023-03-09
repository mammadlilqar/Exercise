package az.developia.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import az.developia.LogVar;
import az.developia.constants.Constants;

public class Repository {

	public boolean check(String username,String password) {
		boolean checking=false;
		try {
			Connection conn=DriverManager.getConnection(Constants.dbURL,Constants.dbUser,Constants.dbPass);
			Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from users where username='"+username+"' and password='"+password+"'");
		if(rs.next())	{
			checking=true;
		}
		conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return checking;
	}

	}


