package database;

import java.sql.*;
import java.util.ArrayList;

public class GisaDAO {

    //Batch 실습
    public boolean insert(ArrayList<Student> list) throws SQLException {
        boolean flag = false;

        Connection con = ConnectionManager.getConnection();
        String sql = "insert into gisa values (?,?,?,?,?,?,?,?,?,?,?)";
        int affectedCount = 0;
        PreparedStatement pstmt = null;

        try {
            int count = 0;
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            for (Student student : list) {
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

                pstmt.addBatch();                                // 모아서 보내기
                count++;
                if (count % 100 == 0) {                          // 보내는 기준 = 100
                    int[] temp = pstmt.executeBatch();           // 모은 개수 전송
                    affectedCount += temp.length;
                    System.out.println("batch execute");
                }

            }
            if (affectedCount > 0) {
                System.out.println(affectedCount);
                flag = true;
            }
            con.commit();
        } catch (SQLException se) {
            con.rollback();
        } finally {
            con.setAutoCommit(true);
        }
        ConnectionManager.closeConnection(null, pstmt, con);
        return flag;
    }


    // SQL에서 받아오기
    public ArrayList<Student> select(String sql) {

        ArrayList<Student> list = new ArrayList<Student>();
        Connection con = ConnectionManager.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            Student student = null;
            while (rs.next()) {
                // 하나의 레코드를 student객체 1개에 맵핑하고 리스트에 저장
                int stdNo = rs.getInt(1);
                String email = rs.getString(2);
                int kor = rs.getInt(3);
                int eng = rs.getInt(4);
                int math = rs.getInt(5);
                int sci = rs.getInt(6);
                int hist = rs.getInt(7);
                int total = rs.getInt(8);
                String mgrCode = rs.getString(9);
                String accCode = rs.getString(10);
                String LocCode = rs.getString(11);
                student = new Student(stdNo, email, kor, eng, math, sci, hist, sci, mgrCode, accCode, LocCode);

                list.add(student);
            }
            ConnectionManager.closeConnection(rs, pstmt, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //1000개의 data insert
    public boolean insertOld(ArrayList<Student> list) throws SQLException {
        boolean flag = false;
        Connection con = ConnectionManager.getConnection();

        String sql = "insert into gisa values (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = con.prepareStatement(sql);
        int affectedCount = 0;

        for (Student student : list) {
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
            affectedCount += pstmt.executeUpdate();
        }
        if (affectedCount > 0) {
            System.out.println(affectedCount);
            flag = true;
        }
        ConnectionManager.closeConnection(null, pstmt, con);
        return flag;
    }

    // Student 객체 insert
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
        if (affectedCount > 0) {
            flag = true;
        }
        ConnectionManager.closeConnection(null, pstmt, con);
        return flag;
    }

    //insert 구현
    public boolean insert(String sql) throws SQLException {
        boolean flag = false;

        Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        int affectedCount = stmt.executeUpdate(sql);

        ConnectionManager.closeConnection(null, stmt, con);

        if (affectedCount > 0) {
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

        ConnectionManager.closeConnection(null, stmt, con);

        if (affectedCount > 0) {
            flag = true;
        }
        return flag;
    }

}
