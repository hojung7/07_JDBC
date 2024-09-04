package edu.kh.todolist.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.dto.Todo;

public interface TodoListDao {

	
/**
 * 전체 조회
 * @param conn
 * @return
 * @throws Exception
 */
	List<Todo> todoListFullView(Connection conn)throws Exception;

	/**
	 * 완료된 할 일 개수 조회
	 * @param conn
	 * @return
	 * @throws Exception
	 */
int getCompleteCount(Connection conn) throws Exception;

	/**
	 * 할일 추가
	 * @param conn
	 * @param title
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	int todoAdd(Connection conn, String title, String detail) throws Exception;
	
}
