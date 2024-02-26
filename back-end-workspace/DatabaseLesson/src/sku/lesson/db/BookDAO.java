package sku.lesson.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAO {
	
	public void select(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; // 지역변수 처리  -> 지역변수를 사용하려면 초기화를 해줘야 한다!! 꼭
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 행처리
				String attr1 = rs.getString(1);
				String attr2 = rs.getString(2);
				String attr3 = rs.getString(3);
				//String attr4 = rs.getString(4);
				//int attr4 = rs.getInt(4);
				int attr4 = rs.getInt("price");
				
				System.out.println(attr1+","+attr2+","+attr3+","+attr4);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.closeConnection(rs, stmt, con);
	}
}
