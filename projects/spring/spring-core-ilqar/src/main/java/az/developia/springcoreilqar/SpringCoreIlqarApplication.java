package az.developia.springcoreilqar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreIlqarApplication {

	public static void main(String[] args) {
		ApplicationContext a = SpringApplication.run(SpringCoreIlqarApplication.class, args);
		Developer d = a.getBean("developer", Developer.class);
		System.out.println(d.getName());
		System.out.println(d.getSalary());
		System.out.println(d.getDepartment());
		System.out.println(d.getComputer().getModel());
		
		MyConfiguration m = a.getBean("myConfiguration", MyConfiguration.class);
         System.out.println(m.getDbUrl());
	}
}