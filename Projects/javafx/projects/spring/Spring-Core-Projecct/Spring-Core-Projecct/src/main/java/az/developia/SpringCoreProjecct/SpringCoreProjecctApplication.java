package az.developia.SpringCoreProjecct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreProjecctApplication {

	public static void main(String[] args) {
		ApplicationContext a=SpringApplication.run(SpringCoreProjecctApplication.class, args);
	    Person p=a.getBean("m",Person.class);
	    System.out.println(p.getName());
	    
	    String[]  beans=a.getBeanDefinitionNames();
	    for (String s : beans) {
			System.out.println(s);
		}
	    
	    
	}

}
