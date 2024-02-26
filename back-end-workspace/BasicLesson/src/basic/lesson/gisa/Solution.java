package basic.lesson.gisa;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public String solveQuestion1(ArrayList<Student> data) {
		String answer = null;
		
		ArrayList<Student> quiz4 = new ArrayList<Student>();
		for(Student st : data) {
			if(st.getLocCode().equals("B")) {
				quiz4.add(st);
			}
		}
		Collections.sort(quiz4,new GisaComparator()); // 정렬대상, 정렬알고리즘을 가진 클래스
		//this.printQuiz(quiz4,0,5);
		int stdNo = quiz4.get(4).getStdNo();
		
		answer = String.valueOf(stdNo);
		return answer;
	}
	
	public void printQuiz(ArrayList<Student> quiz, int start, int end) {
		for(int i=start; i<end; i++) {
			System.out.println(quiz.get(i));
		}
	}
	
	//문제 2번을 풀기 위해 parameter로 data를 공급받는다.
	public String solveQuestion2(ArrayList<Student> list) {
		
		String answer = null;
		//12. 지역코드가 B인 자료에 대해 국어+영어 점수 중 가장 큰 값 구하기
		//ArrayList 지식
		//max 알고리즘
		//기본 문법(변수, 제어문)
		//객체의 기본 사용법
		int max = 0;
		for(Student st : list) {
			if(st.getLocCode().equals("B")) {
				if(max<(st.getKor()+st.getEng())){
					max = st.getKor()+st.getEng();
				}
			}
		}
		
		System.out.println("문제 풀이");
		answer = String.valueOf(max);
		return answer;
	}
	//강사님 답
	public String solveQuestion31(ArrayList<Student> data) {
		int sum = 0;
		for(Student st : data) {
			int point = 0;
			if(st.getAccCode().equals("A")) {
				point = 5;
			}else if (st.getAccCode().equals("B")) {
				point = 15;
			}else if(st.getAccCode().equals("C")) {
				point = 20;
			}
			if(st.getEng() + st.getMath() >=120) {
				sum = sum + st.getTotal()+point;
			}
		}
		return String.valueOf(sum);
	}
	public String solveQuestion41(ArrayList<Student> data) {
		String answer = null;
		int count = 0;
		for(Student st : data) {
			if(st.getAccCode().equals("A")||st.getAccCode().equals("B") ) {
				int point = 5; //기본값을 5로 -A
				if(st.getLocCode().equals("B")) {
					point = 10;
				}else if(st.getLocCode().equals("C")) {
					point = 15;
				}
				if(st.getKor() + point >= 50) {
					count++;
				}
			}
		}
		answer = String.valueOf(count);
		return answer;
	}
	//나
	public String solveQuestion3(ArrayList<Student> list) {
		String answer = null;
		int total = 0;
		int result =0;
		for(Student st : list) {
			total = st.getEng() + st.getMath();
			if(total >=120) {
				switch(st.getMgrCode()) {
				case "A":
					result = total + 5;
				case "B":
					result = total + 10;
				case "C" : 
					result = total + 20;
				}				
			}
		}
		answer = String.valueOf(result);
		return answer;
	}

	public String solveQuestion4(ArrayList<Student> list) {
		String answer = null;
		int point = 0;
		int result = 0;
		int sum = 0;
		for(Student st : list) {
			point = st.getKor();
			switch(st.getMgrCode()) {
			case "A":
				result = point + 5;
			case "B":
				result = point + 10;
			}
			if(result >= 50) {
				sum ++;
			}
		}
		answer = String.valueOf(sum);
		return answer;
		
	}
	
	
}
