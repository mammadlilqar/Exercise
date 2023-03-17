package az.developia.springcoreilqar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfiguration {
	@Value("${dbURL}")
	private String dbUrl;
	
public String getDbUrl() {
		return dbUrl;
	}


@Bean
public Person myPerson() {
	Person p=new Person();
	p.setName("Ilqar");
	p.setSurname("Mammadli");
	return p;
}

@Bean
public Computer myComputer() {
	Computer c=new Computer();
	c.setModel("Asus");
	c.setPrice(1900);
	return c;
}
}
