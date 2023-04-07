package az.developia.springmvcilqar.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import az.developia.springmvcilqar.model.Student;

@Repository
public class StudentRepository {
	@Autowired
	private DataSource dataSource;

	public List<Student> findAll(String query) {
		ArrayList<Student>  students=new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();

			Statement st = conn.createStatement();
	 ResultSet rs=	st.executeQuery("select *from students where name like '%"+query+"%' or birthday like '%"+query+"%'");
		 	while(rs.next()) {
		 		Student s=new Student();
		 		Integer id=rs.getInt("id");
		 		s.setId(id);
		 		
		 		String name=rs.getString("name");
		 		s.setName(name);
		 		
		 		 String surname=rs.getString("surname");
		 		s.setSurname(surname);
		 		
		 		String phone=rs.getString("phone");
		 		s.setPhone(phone);
		 		
		 		String address=rs.getString("address");
		 		s.setAddress(address);
		 		
		 		String email=rs.getString("email");
		 		s.setEmail(email);
		 		
		 		Date  birthday=rs.getDate("birthday");
		 		s.setBirthday(birthday);
		 		
		 		String sector=rs.getString("sector");
		 		s.setSector(sector);
		 		
		 		students.add(s);
		 	}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return  students ;
	}


	public void save(Student s) {
		try {
			Connection conn = dataSource.getConnection();

			Statement st = conn.createStatement();
			st.executeUpdate("insert into students (name,surname,phone,address,email,birthday) values ('"
					+s.getName()+"','"+s.getSurname()+"','"+s.getPhone()+"','"+s.getAddress()+"','"+s.getEmail()+"','"+s.getBirthday()+"');");
					
		 	
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
