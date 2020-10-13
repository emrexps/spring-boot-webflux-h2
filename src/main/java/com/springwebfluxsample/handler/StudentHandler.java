package com.springwebfluxsample.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.springwebfluxsample.model.Student;
import com.springwebfluxsample.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StudentHandler {

	private final StudentRepository studentRepository;

	public StudentHandler(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}

	
	public Mono<ServerResponse> getStudentById(@PathVariable("id") ServerRequest request) {
	Mono<Student> student=	 studentRepository.getStudent(Long.valueOf(request.pathVariable("id")));
		return ServerResponse.ok().body(BodyInserters.fromPublisher(student, Student.class));
	}

	
	

	public Mono<ServerResponse>  getAllStudents(){
		
		Flux<Student> student = studentRepository.findAll();
		return ServerResponse.ok().body(BodyInserters.fromPublisher(student, Student.class));
		
	}
	
	
}
