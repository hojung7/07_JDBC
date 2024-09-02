package edu.kh.todolist.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import edu.kh.todolist.dto.Todo;

public interface TodoListService{
	
	/**
	 * 조회
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> todoListFullView()throws Exception;
	



}
