package edu.kh.todolist.service;

import static edu.kh.todolist.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.dao.TodoListDao;
import edu.kh.todolist.dao.TodoListDaoImpl;
import edu.kh.todolist.dto.Todo;


public class TodoListServiceImpl implements TodoListService{

	// 필드
	private TodoListDao dao = new TodoListDaoImpl();
	
	
 

 
 
@Override
public Map<String, Object> todoListFullView() throws Exception {
	
	Connection conn = getConnection();
	
	List<Todo> todoList = dao.todoListFullview(conn);
	
	Map<String, Object> map  = HashMap<String, Object>();
	
	map.put("todoList", todoList);

	
	
	close(conn);

	return map;
}
	
	
 
	}
	
	
	
