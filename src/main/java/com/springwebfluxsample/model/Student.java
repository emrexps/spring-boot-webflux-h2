package com.springwebfluxsample.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
	
	@Id
	private Long id;
	private String fname;
	private String surname;
	
	
	
	
	
	
	
}
