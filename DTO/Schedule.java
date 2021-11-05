package DTO;

public class Schedule {
	private String sName = null;
	private String sDescription = null;
	private String mName = "미정";
	private String date = "미정";

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public void prt() {
		System.out.println("===========================");
		System.out.println("스케줄 : " + this.getsName());
		System.out.println("내용 : " + this.getsDescription());
		System.out.println("관리자 : " + this.getmName());
		System.out.println("날짜 : " + this.getDate());
		System.out.println("===========================");
	}
}
