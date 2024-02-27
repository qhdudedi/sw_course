package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GisaDAO {
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

}
