package az.developia.SpringCoreIlgar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreIlgarApplication {

	public static void main(String[] args) {
	ApplicationContext a=SpringApplication.run(SpringCoreIlgarApplication.class, args);
	    Computer comp=a.getBean(Computer.class);
	   System.out.println(comp.getBrand());
	   System.out.println(comp.getColor());
	   System.out.println(comp.getId());
	   System.out.println(comp.getPrice());
	   System.out.println(comp.getRam().getBrands());
       
	   Home home1=a.getBean(Home.class);
	   Home home2=a.getBean(Home.class);

	}

}
