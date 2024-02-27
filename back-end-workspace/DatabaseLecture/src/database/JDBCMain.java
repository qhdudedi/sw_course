package database;

import java.io.*;
import java.util.ArrayList;

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
            //Student student = new Student(88000,"addx",17,29,16,49,43,154,"C","A","C");

            boolean flag = dao.insert(this.makeData());
            if(flag)
            {
                System.out.println("insert success");
            } else{
                System.out.println("insert fail");
            }
        } catch (Exception e) {     // makeData는 SQLException을 발생시키지 않는다.
            e.printStackTrace();
        }
    }
    private ArrayList<Student> makeData(){
        ArrayList<Student> list = null;

        // 파일에 접속하여 생성
        File file = new File("Abc1115.csv");
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            list = new ArrayList<Student>();
            while((line=br.readLine()) != null){
                String[] temp = line.split(",");
                int stdNo = Integer.parseInt(temp[0]);
                String email = temp[1];
                int kor = Integer.parseInt(temp[2].trim());
                int eng = Integer.parseInt(temp[3].trim());
                int math = Integer.parseInt(temp[4].trim());
                int sci = Integer.parseInt(temp[5].trim());
                int hist = Integer.parseInt(temp[6].trim());
                int total = Integer.parseInt(temp[7].trim());
                String mgrCode = temp[8];
                String accCode = temp[9];
                String locCode = temp[10];
                Student student = new Student(stdNo, email, kor, eng, math, sci, hist, total, mgrCode, accCode, locCode);

                list.add(student);
            }
            br.close();
            fr.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return list;
    }
}
