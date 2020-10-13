package com.springwebfluxsample.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.springwebfluxsample.handler.StudentHandler;

@Configuration
public class RoutesConfig {
	
	@Bean
	RouterFunction<ServerResponse> routes(StudentHandler handler) {

		return route(GET("/student/{id}"),
							request -> handler.getStudentById(request))

				.and(route(GET("/student"),
								request -> handler.getAllStudents()));
	}
	

}
