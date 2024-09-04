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

	//목록 반환 서비스
	
	@Override
	public Map<String, Object> todoListFullView() throws Exception {
		
		Connection conn = getConnection();
		
		// 할 일 목록 얻어오기
		List<Todo> todoList = dao.todoListFullView(conn);
		
		// 완료된 할 일 개수 카운트
//		int completeCount = dao.getCompleteCount(conn);
		
		// 메서드에서 반환은 하나의 값 또는 객체 밖에 할 수 없기 때문에
		// Map이라는 컬렉션을 이용해 여러 값을 한 번에 담아서 반환
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("todoList", todoList);
//		map.put("completeCount", completeCount);
		
		
		return map;
	}

	
	@Override
	public int todoAdd(String title, String detail) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.todoAdd(conn, title, detail);
		
		if(result > 0) commit(conn);
		else				rollback(conn);
		
		
		return result;
	}
	
	
 


	
 
	}
	
	
	
