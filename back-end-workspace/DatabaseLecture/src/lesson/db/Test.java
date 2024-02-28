package lesson.db;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.testStart();
    }
    public void testStart(){
        DAO gisa = new DAO();
        String queryAnswer1 ="";
        String queryAnswer2 ="";
        String queryAnswer3 ="";

        StringBuilder sb = new StringBuilder("select count(*)");
        sb.append("from");
        sb.append("(select * from gisa");
        sb.append("where acc_code='A' or acc_code='B') A");
        sb.append("where kor+(case");
        sb.append("when loc_code='A' then 5");
        sb.append("when loc_code='B' then 10");
        sb.append("when loc_code='C' then 15");
        sb.append("end) point");
        sb.append("form gisa");
        sb.append("where (eng+math)>=120");
        String queryAnswer4 =sb.toString();

        System.out.println(queryAnswer4);

        try{
            String answer = gisa.selectQuiz1(queryAnswer1);
            this.printAnswer(1,answer);
            answer = gisa.selectQuiz2(queryAnswer2);
            this.printAnswer(2,answer);
            answer = gisa.selectQuiz3(queryAnswer3);
            this.printAnswer(3,answer);
            answer = gisa.selectQuiz4(queryAnswer4);
            this.printAnswer(4,answer);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void printAnswer(int quizNumber, String answer){

    }
}
