package kr.co.mySpring.BoardVO;

public class BoardVO {
	
	private int bno;
	private String title;
	private String contents;
	private String regdate;
	private String writter;
	
	

	public String getWritter() {
		return writter;
	}



	public void setWritter(String writter) {
		this.writter = writter;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", contents=" + contents + ", regdate=" + regdate
				+ ", writter=" + writter + ", getWritter()=" + getWritter() + ", getBno()=" + getBno() + ", getTitle()="
				+ getTitle() + ", getContents()=" + getContents() + ", getRegdate()=" + getRegdate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}




	
	
	
}
