package database;

import java.sql.*;

public class ConnectionManager {
    public static Connection getConnection(){
        Connection con = null;
        String id = "root";
        String pwd = "1q2w3e4r";
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbcURL = "jdbc:mysql://localhost:3306/gisa";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(jdbcURL, id, pwd);
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        } catch (SQLException se){
            se.printStackTrace();
        }
        return con;
    }
    public static void closeConnection(ResultSet rs, Statement stmt, Connection con){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
