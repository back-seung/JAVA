package DTO;

public class Schedule {
	private String sName = null;
	private String sDescription = null;

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsDescription() {
		return sDescription;
	}

	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}

	public void prt() {
		System.out.println("===========================");
		System.out.println("스케줄 : " + this.getsName());
		System.out.println("내용 : " + this.getsDescription());
		System.out.println("===========================");
	}
}
