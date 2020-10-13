package com.springwebfluxsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;

import com.springwebfluxsample.model.Student;
import com.springwebfluxsample.repository.StudentRepository;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
public class SpringBootH2WebFluxApplication  implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;
	
	
	public static void main(String[] args) {
	
		new SpringApplicationBuilder(SpringBootH2WebFluxApplication.class).web(WebApplicationType.REACTIVE).run(args);
	}

	  @Bean
	    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

	        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
	        initializer.setConnectionFactory(connectionFactory);
	        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

	        return initializer;
	    }
	
	
	@Override
	public void run(String... args) throws Exception {
		Student donald=Student.builder()
				.fname("Donald")
				.surname("Trump").build();
		
		Student joe=Student.builder()
				.fname("Joe")
				.surname("Biden").build();
		
		studentRepository.save(donald).subscribe();
		studentRepository.save(joe).subscribe();
		
	}

}
