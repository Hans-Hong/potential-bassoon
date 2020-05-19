package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	private static String url;
	private static String user;
	private static String password;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.db.dbInfo");
		
		try {
			Class.forName(bundle.getString("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);		
		}
		// 전혀 수정할 필요가 없는 코드와 수정 발생 가능 코드가 섞여있다면, 분리해야함.
		url = bundle.getString("url").trim();
		user = bundle.getString("user").trim();
		password = bundle.getString("password").trim();
	}
	public static Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, user, password);	//3
		return conn;
	}
}
