package az.developia.SpringCoreProjecct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	@Bean
	public Person m() {
		Person p = new Person();
		p.setName("Namiq");
		p.setSurname("Hesenov");
		return p;
	}
}
