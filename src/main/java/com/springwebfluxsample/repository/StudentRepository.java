package com.springwebfluxsample.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

import com.springwebfluxsample.model.Student;


public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

	 @Query("SELECT f.id, f.fname, f.surname FROM student f WHERE id = $1 ")
	    Mono<Student> getStudent(Long userId);
	
}
