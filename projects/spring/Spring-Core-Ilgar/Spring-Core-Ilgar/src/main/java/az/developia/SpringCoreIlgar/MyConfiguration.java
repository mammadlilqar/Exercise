package az.developia.SpringCoreIlgar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

	@Bean
	public Ram myRam() {
		Ram r = new Ram();
		r.setBrands("Fujitsu");
		r.setSize(8);
		return r;
	}
}
