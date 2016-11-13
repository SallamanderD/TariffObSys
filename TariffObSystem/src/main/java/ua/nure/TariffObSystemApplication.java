package ua.nure;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CharacterEncodingFilter;
import ua.nure.DAO.Emulator;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ua.nure")
public class TariffObSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(TariffObSystemApplication.class, args);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(new MongoClient("127.0.0.1"),"OperatorBase");
	}

}
