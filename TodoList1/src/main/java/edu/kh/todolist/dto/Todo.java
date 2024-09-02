package edu.kh.todolist.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo  {
	

	private String todoTitle;
	private String todoDetail;
	private Boolean todoComplete;
	private String todoTimes;

	} 
	
	

