package kr.co.mySpring.PageVO;

public class pageVO {

	private int nowPage;			// 현재페이지
	private int startPage;		// 시작페이지
	private int endPage;			// 끝페이지
	private int total;				// 전페 게시글의 갯수
	private int cntPerPage;		// 페이지당 게시글 갯수
	private int lastPage;			// 마지막페이지
	
	private int start;				// 쿼리에 사용할 start
	private int end;					// 쿼리에 사용할 end
	private int cntPage = 5;	// 페이지당 5개씩 게시글 보여주기
	
	// 검색용 추가
	private String searchType;
	private String keyword;
	private String title;
	private String contents;
	
	
	
	
	
	
	// 외부에서 이 객체를 생성할때 , 전체 게시글갯수, 현재페이지,  페이지당 게시글의 갯수를 
	// 매개변수로 받는다 
	
	public pageVO() {
		
	}
	
	public pageVO(int total, int nowPage, int cntPerPage) {
		System.out.println(("pageVO 인스턴스 생성!"));
		setNowPage(nowPage);														// 현재페이지 셋팅
		setCntPerPage(cntPerPage);											// 페이지당 보여질 게시글 갯수
		setTotal(total);																// 전체 게시글의 갯수
		
		calcLastPage(getTotal(), getCntPerPage());			// 마지막 페이지 
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	
	
	
	// 제일 마지막 페이지 계산
	// 매개변수로 , 전체게시글, 페이지당 보여질 게시글의 갯수 
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
		/*
		마지막 페이지 계산 = 전페 게시글 갯수 / 페이지당 게시글 갯수
	    									(total) / (cntPerPage)
		 */
	}
	
	
	
	// 시작, 끝 페이지 계산
	// 하단 버튼 갯수 [1] [2] [3] [4] [5]
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		// 마지막 페이지는 ( 현재페이지 / 버튼 갯수 ) *버튼 갯수 
		// 1~5 까지 어떤 버튼을 누럴도 마지막 버튼은 5이다 
		// 6~10까지는 10 
		// 반복 ..
		
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		
		// 시작버튼 구하기 = 마지막 버튼의 값 - 버튼 갯수 + 1
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	
	
	
	
	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);						// end = 현재페이지 * 페이지당 게시글 갯수  10
		setStart(getEnd() - cntPerPage + 1);		// start = end- 페이지당 게시글 갯수 = 6
	}
	
	
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCntPage() {
		return cntPage;
	}
	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	@Override
	public String toString() {
		return "pageVO [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total
				+ ", cntPerPage=" + cntPerPage + ", lastPage=" + lastPage + ", start=" + start + ", end=" + end
				+ ", cntPage=" + cntPage + ", searchType=" + searchType + ", keyword=" + keyword + ", title=" + title
				+ ", contents=" + contents + "]";
	}

	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
