package human;

public class SubjectList {
	String[] subject = { "java", "c", "html" };

	public void menu() {
		System.out.println("1. 교과목 추가 ");
		System.out.println("1. 교과목 보기 ");
	}

	public String[] getSubject() {
		return subject;
	}
}
