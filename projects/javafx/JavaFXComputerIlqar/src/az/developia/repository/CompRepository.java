package az.developia.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import az.developia.Computers;

import static az.developia.utill.Constants.*;
public class CompRepository {

	public void add(Computers c) {
		try {
			Connection conn=DriverManager.getConnection(DB_URL, DB_USR, DB_Password);
			Statement st=conn.createStatement();
			st.executeUpdate("insert into computers (Marka,Model,Price,Memory_Size,Ram,Color,Processor,Screen_Size)"
					+ "values('"+c.getMarka()+"','"+c.getModel()+"',"+c.getPrice()+" "
							+ " ,'"+c.getMemorySize()+"',"+c.getRam()+",'"+c.getColor()+"','"+c.getProcessor()+"','"+c.getScreenSize()+"'  );");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
	}

	public static ArrayList<Computers> findAll() {
		ArrayList<Computers> comps=new ArrayList<>();
		try {
			Connection conn=DriverManager.getConnection(DB_URL, DB_USR, DB_Password);
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from computers");

			while(rs.next()) {
				Computers comp=new Computers();
				Integer id=rs.getInt("id");
				comp.setId(id);
				
				String marka=rs.getString("Marka");
				comp.setMarka(marka);
				
				String model=rs.getString("Model");
				comp.setModel(model);
				
				Integer price=rs.getInt("Price");
				comp.setPrice(price);
				
				String Memory=rs.getString("Memory_Size");
				comp.setMemorySize(Memory);
				
				Integer ram=rs.getInt("Ram");
				comp.setRam(ram);
				
				String color=rs.getString("Color");
				comp.setColor(color);
				
				String processor=rs.getString("Processor");
				comp.setProcessor(processor);
				
				String ScreenSize=rs.getString("Screen_Size");
				comp.setScreenSize(ScreenSize);
				
				comps.add(comp);
			}
			
			
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
		return comps;
		
	}

	public void delete(Integer id) {
		try {
			Connection conn=DriverManager.getConnection(DB_URL,DB_USR,DB_Password);
			Statement st=conn.createStatement();
			st.executeUpdate("delete from computers where id="+id );
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void update(Computers c) {
		
		try {
			Connection conn=DriverManager.getConnection(DB_URL,DB_USR,DB_Password);
			Statement st=conn.createStatement();
			st.executeUpdate("update computers set Marka='"+c.getMarka()+"',Model='"+c.getModel()+"',"
					+ "Price='"+c.getPrice()+"',Memory_size='"+c.getMemorySize()+"',Ram='"+c.getRam()+"' "
							+ ",Color='"+c.getColor()+"',Processor='"+c.getProcessor()+"',Screen_size='"+c.getScreenSize()+"' ");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
