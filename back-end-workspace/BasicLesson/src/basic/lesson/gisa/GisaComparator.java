package basic.lesson.gisa;

import java.util.Comparator;

public class GisaComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		int result = 0;
		result = (o2.getEng()+o2.getKor())-(o1.getEng()+o1.getKor());
		
		if(result == 0) {
			result = o1.getStdNo()-o2.getStdNo();
			
		}
		
		return result;
	}

}
