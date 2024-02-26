package basic.lesson.gisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LessonMain {

	public static void main(String[] args) {

		// 2.startLesson 호출
		LessonMain lm = new LessonMain();
		// lm.startLesson();
		lm.testStart();
	}

	// 1.startLesson 메소드 이름 기본 메소드 생성(void, p-none)
	// static 주의 !
	public void startLesson() {
		System.out.println("start Lesson");
		this.testStart(); // 시험 개시
	}

	// 3.data class(Student) 와 4.logic class(Solution)
	public void testStart() {
		// 5.데이터 파일 생성
		ArrayList<Student> list = this.makeData();
		// 6.로직클래스에게 데이터 전달
		Solution solution = new Solution();
		String answer  = solution.solveQuestion2(list);
		//7.정답받아서 답안지 작성
		this.writeAnswer(2,answer);
		
		/** 3번 **/
		answer = solution.solveQuestion31(this.makeData());
		this.writeAnswer(3,answer);
		
		/** 4번 **/
		answer = solution.solveQuestion41(this.makeData());
		this.writeAnswer(4,answer);
		
		/** 1번 **/
		answer = solution.solveQuestion1(this.makeData());
		this.writeAnswer(1,answer);
		

	}

	public ArrayList<Student> makeData() {
		ArrayList<Student> list = null;
		System.out.println("데이터를 생성해서 전달");
		
		// 10.파일연결 - 파일 안의 1000개의 라인에 각각 접근하여 --> Stream 처리(IO)
		File file = new File("Abc1115.csv");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			//line = br.readLine(); // 하나의 라인만 처리한다는 의미 - 반복을 통해 모든 라인 읽기
			list = new ArrayList<Student>();
			while((line = br.readLine())!=null) {
				// 10-1.각 라인을 11개의 데이터로 분리 --String 분리
				// 방법 1 .String temp = line.substring(0,6);
				String[] temp = line.split(","); // ,로 구분되어 있음(split - 배열로 나옴)
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
				String LocCode = temp[10];
				Student student = new Student(stdNo,email,kor,eng,math,sci,hist,total,mgrCode,accCode,LocCode);
				list.add(student);
				// 10-2.Student 객체로 생성한 다음 List에 저장 --> ArrayList
			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return list;
	}

	public void writeAnswer(int number, String answer) {
		System.out.println("정답을 받아서 답안지 작성");
		
		// 11.파일 생성
		File file = new File("Ans" + number + ".txt");
		
		// 11-1.파일 접근
		try {
			FileWriter fw = new FileWriter(file);
			
			// 11-2.파일 쓰기 --> 11번 모두 스트림 지식 필요
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(answer);
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
