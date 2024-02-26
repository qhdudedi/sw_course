package sku.lesson.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCenter {

	public static void main(String[] args) {
		// connectDatabase 호출
		DatabaseCenter dc = new DatabaseCenter();
		try {
			dc.connectDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}
	// throws SQLEexception은 예외처리를 미루는 것이고, try-catch 이용하면 지금 예외처리를 하겠다는 의미
	public void connectDatabase() throws SQLException, ClassNotFoundException {
		String id = "root";
		String pwd = "1q2w3e4r";
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/gisa";
		
		Class.forName(driver);
		
		// Connection con = DriverManager.getConnection(jdbcURL, id, pwd); 에러 해결 -> throws sqlexception
		Connection con = DriverManager.getConnection(jdbcURL, id, pwd);
		if (con != null) {
			System.out.println("connecting database");
			con.close();
		}else {
			System.out.println("connection fail");
		}
	}

}
