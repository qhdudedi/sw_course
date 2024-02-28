package lesson.db;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {

    }
    public void testStart(){
        DAO gisa = new DAO();
        String queryAnswer1 ="";
        String queryAnswer2 ="";
        String queryAnswer3 ="";
        String queryAnswer4 ="";

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
