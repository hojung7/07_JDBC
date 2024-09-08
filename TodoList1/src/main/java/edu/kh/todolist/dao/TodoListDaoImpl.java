package edu.kh.todolist.dao;

import static edu.kh.todolist.common.JDBCTemplate.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.catalina.User;

import edu.kh.todolist.common.JDBCTemplate;
import edu.kh.todolist.dto.Todo;
import jakarta.websocket.ClientEndpointConfig.Builder;


public class TodoListDaoImpl implements TodoListDao {

	private List<Todo> todoList = null;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	// 기본 생성자
	public TodoListDaoImpl() {

		// 객체 생성 시
		// 외부에 존재하는 sql.xml 파일을 읽어와
		// prop에 저장

		try {
			String filePath = JDBCTemplate.class.getResource("/edu/kh/todolist/sql/sql.xml").getPath();

			// 지정된 경로의 XML 파일 내용을 읽어와
			// Properties 객체에 K:V 세팅
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Todo> todoListFullView(Connection conn) throws Exception {
		List<Todo> todoList = new ArrayList<Todo>();

		try {
			String sql = prop.getProperty("todoListFullView");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				// Builder 패턴 : 특정 값으로 초기화된 객체를 쉽게 만드는 방법
				// -> Lombok에서 제공하는 @Builder 어노테이션을 DTO에 작성하면 사용 가능

				/*
				 * int todoNo = rs.getInt("TODO_NO"); String todoTitle =
				 * rs.getString("TODO_TITLE"); String todoDetail = rs.getString("TODO_DETAIL");
				 * String todoComplete = rs.getString("TODO_COMPLETE"); String todoRegdate =
				 * rs.getString("REG_DATE");
				 * 
				 * Todo todo = new Todo(); todo.setTodoNo(todoNo); todo.setTitle(todoTitle);
				 * todo.setDetail(todoDetail); todo.setComplete(todoComplete.equals("Y"));
				 * todo.setRegdate(todoRegdate);
				 * 
				 * todoList.add(todo);
				 */
				
				// Builder 패턴 : 특정 값으로 초기화된 객체를 쉽게 만드는 방법
				// -> Lombok에서 제공하는 @Builder 어노테이션을 DTO에 작성하면 사용 가능
				boolean complete = rs.getInt("TODO_COMPLETE") == 1;
				
				Todo todo = Todo.builder()
							.todoNo(rs.getInt("TODO_NO"))
							.title(rs.getString("TODO_TITLE"))
							.complete(complete)
							.regDate(rs.getString("REG_DATE"))
							.build();
				
				todoList.add(todo);
				/*
				 * Todo todo = Todo.builder() .todoNo(rs.getInt("TODO_NO"))
				 * .title(rs.getString("TODO_TITLE")) .complete(complete)
				 * .regDate(rs.getString("REG_DATE")) .build();
				 * 
				 * todoList.add(todo);
				 */
			}
			

			
			
		} finally {
			close(rs);
			close(stmt);
		}

		return todoList;
	}

//	@Override
//	public int getCompleteCount(Connection conn) throws Exception {
//		int completeCount = 0;
//		
//		try {
//			String sql = prop.getProperty("getCompleteCount");
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery(sql);
//			
//			if(rs.next()) {
//					completeCount = rs.getInt(1);
//			}
//		}finally {
//			close(rs);
//			close(stmt);
//		}
//		return completeCount;
//	}

	// 할 일 추가
	@Override
	public int todoAdd(Connection conn, String title, String detail) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("todoAdd");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  title);
			pstmt.setString(2, detail);
			
			result = pstmt.executeUpdate();
			
		}finally {
		
			close(pstmt);
			
		}
		return result;
	}

	// 할 일 상세조회
	@Override
	public Todo todoDetailView(Connection conn, int todoNo) throws Exception {
		Todo todo = null;
		
		try {
			String sql = prop.getProperty("todoListFullView");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
			boolean complete = rs.getInt("TODO_COMPLETE") == 1;
			
			
			todo = Todo.builder()
						.todoNo(rs.getInt("TODO_NO"))
						.title(rs.getString("TODO_TITLE"))
						.detail(rs.getString("TODO_DETAIL"))
						.complete(complete)
						.regDate(rs.getString("REG_DATE"))
						.build();
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return todo;
	}

}
