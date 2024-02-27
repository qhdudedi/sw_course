package database;


import java.sql.SQLException;

public class JDBCMain {

    public static void main(String[] args){
        JDBCMain main = new JDBCMain();
        main.testCRUD();
    }
    public void testCRUD(){
        String sql = "insert into gisa values (77000,'addx',17,29,16,49,43,154,'C','A','C');";
        GisaDAO dao = new GisaDAO();

        try {
            //boolean flag = dao.insert(sql);
            //sql = "delete from gisa where studentId = 88000;";
            //boolean flag = dao.delete(sql);
            Student student = new Student(88000,"addx",17,29,16,49,43,154,"C","A","C");
            boolean flag = dao.insert(student);
            if(flag)
            {
                System.out.println("insert success");
            } else{
                System.out.println("insert fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
           //throw new RuntimeException(e);
        }
    }
}
