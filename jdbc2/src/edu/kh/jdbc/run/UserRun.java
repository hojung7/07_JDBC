package edu.kh.jdbc.run;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.view.UserView;

public class UserRun {
	public static void main(String[] args) {
		System.out.println(JDBCTemplate.getConnection());
		
		UserView view = new UserView();
//		view.test();
	view.mainMenu();
	
	}
}
