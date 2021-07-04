package kr.co.mySpring.Board.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mySpring.BoardVO.BoardVO;
import kr.co.mySpring.PageVO.pageVO;
import kr.co.mySpring.UserVO.UserVO;

@Controller
public class BoardController {
		
	@Autowired
	SqlSessionTemplate SqlSessionTemplate;	
	
	@GetMapping("/boardList.do")
	public String BoardList(
			pageVO pageVO,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage,
			BoardVO boardVO,UserVO uservo,HttpSession session,Model model,HttpServletRequest req) {
		
			String type = req.getParameter("searchType");
			String word = req.getParameter("keyword");
			pageVO.setSearchType(type);
			pageVO.setKeyword(word);
			
				
			
			int total = SqlSessionTemplate.selectOne("board.countBoard");
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "10";
			}
				
				
			if(pageVO.getKeyword() == null) {
				
				pageVO = new pageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
				model.addAttribute("paging", pageVO);
				model.addAttribute("viewAll", SqlSessionTemplate.selectList("board.selectBoard",pageVO));
			} else {
				
				pageVO.setSearchType(type);
				pageVO.setKeyword(word);
				model.addAttribute("paging", pageVO);
				model.addAttribute("viewAll", SqlSessionTemplate.selectList("board.searchBoard",pageVO));
			}
			
			return "boardList";
	}
	
	@GetMapping("/boardPage.do")
	public String boardPage(HttpSession session) {
		
			return "boardInsert";
	}		

	@PostMapping("/boardInsert.do")
	public String BoardInsert(BoardVO boardVO, HttpSession session) {
		
		
		String writter = (String) session.getAttribute("account");
		System.out.println("writter =========>" + writter);
		boardVO.setWritter(writter);
		
				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm.ss ");
		Date now = new Date();
		String regdate = sdf.format(now);
		boardVO.setRegdate(regdate);

		// 게시글 업로드
		SqlSessionTemplate.insert("board.insert",boardVO);
		return "redirect:/boardList.do";
	}


//더미용//
/*	
@GetMapping("/boardInsert.do")
public String BoardInsert(boardVO boardVO, HttpSession session) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm ");
			    
				Date now = new Date();
				
				String regdate = sdf.format(now);		
				
				for(int i =101; i<201; i++) {
					
					boardVO.setContents("더미내용"+i);
					boardVO.setTitle("더미" + i);
					boardVO.setRegdate(regdate);
					SqlSessionTemplate.insert("board.insert",boardVO);                  
				}
				return "redirect:/boardList.do";
			 
	}
*/
	@GetMapping("/boardUpdatePage.do")
	public String BoardUpdatePage(BoardVO boardVO, Model model,HttpSession session) {
		
		System.out.println();
		System.out.println("Parameter get bno  ==>" + boardVO.getBno());
		
			
		List<BoardVO> oneList = SqlSessionTemplate.selectList("board.one",boardVO);
		
		model.addAttribute("oneList", oneList);
		return "boardUpdatePage";
	}
	
	@PostMapping("/boardUpdate.do")
	public String BoardUpdate(BoardVO boardVO, Model model,HttpSession session) {
		
		System.out.println("Bno는 " + boardVO.getBno());
		
		System.out.println("업데이트 실행");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Date now = new Date();
		String regdate = sdf.format(now);		
		boardVO.setRegdate(regdate);
			
		SqlSessionTemplate.update("board.update",boardVO);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardDelete.do")
	public String BoardDelete(BoardVO boardVO) {
		
		System.out.println("BoardDelete 컨트롤러 호출");
		
			
		SqlSessionTemplate.delete("board.delete",boardVO);
		return "redirect:/boardList.do";
		
	}
	

	

}
