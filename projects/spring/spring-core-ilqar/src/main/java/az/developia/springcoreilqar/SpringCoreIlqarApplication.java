package az.developia.springcoreilqar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreIlqarApplication {

	public static void main(String[] args) {
	ApplicationContext c=SpringApplication.run(SpringCoreIlqarApplication.class, args);
	Person p=c.getBean(Person.class);
	System.out.println(p.getId());
	System.out.println(p.getName());
	System.out.println(p.getSurname());
	System.out.println(p.getSalary());
	System.out.println(p.getAge());
	
	String[] beans=c.getBeanDefinitionNames();
	for (String a : beans) {
		System.out.println(a);
		
	}
	}


}
