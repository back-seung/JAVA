package human;

import java.util.ArrayList;

public class SubjectList {
	ArrayList<String> subjectList = new ArrayList<>();
	ArrayList<String> PF = new ArrayList<String>();
	ArrayList<String> classes = new ArrayList<String>();

	public void menu() {
		System.out.println("1. 교과목 추가 ");
		System.out.println("2. 교과목 보기 ");
	}

	public ArrayList<String> getSubject() {
		return subjectList;
	}
}
