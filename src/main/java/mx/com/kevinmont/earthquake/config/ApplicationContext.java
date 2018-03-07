package mx.com.kevinmont.earthquake.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAspectJAutoProxy
@ImportResource(locations = "classpath:/mx/com/kevin/mont/earthquake/applicationContext.xml")
public class ApplicationContext {
	Logger logger = Logger.getLogger(ApplicationContext.class);
	
	@Bean
	public AdvicesPerson getAdvicesPerson() {
		return new AdvicesPerson();
	}
}
