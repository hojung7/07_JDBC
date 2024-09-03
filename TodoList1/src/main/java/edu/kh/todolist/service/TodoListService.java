package edu.kh.todolist.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import edu.kh.todolist.dto.Todo;

public interface TodoListService{

	/** 목록 반환 서비스
	 * 
	 * @return todoList + 완료 개수
	 */
	Map<String, Object> todoListFullView() throws Exception;
	



}
