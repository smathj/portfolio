package kr.co.mySpring.mail.MailVO;

public class MailVO {

	private String from	= "smathj92@gmail.com";    	 
	private String to		= "next-no1@hanmail.net";	
	private String subject = "안녕하세요 테스트 메일입니다";
	private String contents = "테스트 메일과 첨부파일입니다";
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
	
}
