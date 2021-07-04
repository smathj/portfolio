package kr.co.mySpring.login.controller;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.mySpring.UserVO.UserVO;

@Controller
public class LoginController {
	
	
	@Autowired
	SqlSessionTemplate SqlSessionTemplate;	
	
	// 로그인
	@PostMapping("/login.do")
	public String Login(UserVO userVO, HttpSession session) {
		
			System.out.println("사용자 로그인 입력값"+userVO.toString());
			
			int a =0;
			a = SqlSessionTemplate.selectOne("user.login",userVO);
			session.setAttribute("account", userVO.getAccount());
			
			return "redirect:/boardList.do";
	}
	
	
	//회원가입 페이지
	@GetMapping("/joinPage.do")
	public String joinPage() {
		return "join";
	}
	
	
	// 회원가입
	@PostMapping("/join.do")
	public String Join(UserVO userVO) {
		System.out.println("join.do 而⑦듃濡ㅻ윭 �샇異�");
		try {
			
			SqlSessionTemplate.insert("user.join",userVO);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "redirect:/";
		}
		return "redirect:/";
		
		
	}
	
	@GetMapping("/logout.do")
	public String LogOut(HttpSession session) {
		
		session.getAttribute("account");
		session.removeAttribute("account");
		
		return "redirect:/";
	}
}
