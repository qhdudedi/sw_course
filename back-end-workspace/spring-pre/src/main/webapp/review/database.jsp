<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Database</title>
</head>
<body>
<%
    //DATABASE에 연결하여 Connection이 만들어지는 지 확인하는 코드 작성
    String id = "root";
    String pwd = "1q2w3e4r";
    String driver ="com.mysql.cj.jdbc.Driver";
    String jdbcURL ="jdbc:mysql://localhost:3306/sku";

    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

    Connection con;
    try {
        con = DriverManager.getConnection(jdbcURL,id,pwd);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    if(con != null){
        out.print("connect");
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }else{
        out.print("fail");
    }

%>
</body>
</html>