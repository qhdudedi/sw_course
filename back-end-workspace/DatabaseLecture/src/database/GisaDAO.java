package database;

import java.sql.*;

public class GisaDAO {
    public boolean insert(Student student) throws SQLException {
        boolean flag = false;
        Connection con = ConnectionManager.getConnection();

        String sql = "insert into gisa values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, student.getStdNo());
        pstmt.setString(2, student.getEmail());
        pstmt.setInt(3, student.getKor());
        pstmt.setInt(4, student.getEng());
        pstmt.setInt(5, student.getMath());
        pstmt.setInt(6, student.getSci());
        pstmt.setInt(7, student.getHist());
        pstmt.setInt(8, student.getTotal());
        pstmt.setString(9, student.getMgrCode());
        pstmt.setString(10, student.getAccCode());
        pstmt.setString(11, student.getLocCode());

        int affectedCount = pstmt.executeUpdate();
        if(affectedCount > 0){
            flag = true;
        }
        ConnectionManager.closeConnection(null,pstmt,con);
        return flag;
    }

    //insert 구현
    public boolean insert(String sql) throws SQLException {
        boolean flag = false;

        Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        int affectedCount = stmt.executeUpdate(sql);

        ConnectionManager.closeConnection(null,stmt,con);

        if(affectedCount > 0 ){
            flag = true;
        }
        return flag;
    }
    //delete 구현
    public boolean delete(String sql) throws SQLException {
        boolean flag = false;

        Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        int affectedCount = stmt.executeUpdate(sql);

        ConnectionManager.closeConnection(null,stmt,con);

        if(affectedCount > 0 ){
            flag = true;
        }
        return flag;
    }

}
