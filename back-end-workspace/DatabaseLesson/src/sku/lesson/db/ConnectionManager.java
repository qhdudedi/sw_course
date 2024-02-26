package sku.lesson.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String id = "root";
		String pwd = "1q2w3e4r";
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/sku";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(jdbcURL, id, pwd);
//		if (con != null) {
//			System.out.println("connecting database");
//			con.close();
//		} else {
//			System.out.println("connection fail");
//		}
		return con;
	}

	public static void closeConnection(ResultSet rs, Statement pstmt, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
