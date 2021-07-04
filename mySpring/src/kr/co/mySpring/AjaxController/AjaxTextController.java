package kr.co.mySpring.AjaxController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mySpring.AjaxVO.AjaxVO;

@Controller
public class AjaxTextController {
	
	//JSP 리턴용
	@RequestMapping(value="/ajaxPage1.do", method= RequestMethod.GET)
	public String ajaxPage1() {
		System.out.println("Ajax_Test Controller call");
		
		return "Ajax_Test";
	}
	
	
	
	@RequestMapping(value="/check.do")
	@ResponseBody
	public String ajaxPost(HttpServletRequest request) {
		String result="";
		System.out.println("AJAX POST Check call");
		String id = request.getParameter("name"); 
		String password = request.getParameter("pwd");
		System.out.println(id);
		System.out.println(password);
		
		return result;
	}
	
	
	@RequestMapping(value="/ajaxPage2.do", method= RequestMethod.GET)
	public String ajaxPage2() {
		System.out.println("Ajax_Test Controller call");
		
		return "Ajax_Test2";
	}	
	
	
	// 0415 Ajax 테스트
	@RequestMapping(value="/AjaxTest2.do", method= RequestMethod.POST)
	public String A() {
		System.out.println("111111111111111");
		String result;
		result = "A";
		
		return "Ajax_Test2";
	}
	
	
	// 0415 Ajax 테스트	
	@RequestMapping(value="/AjaxTest3.do", method= RequestMethod.GET)
	@ResponseBody
	public String B(HttpServletRequest request,@RequestParam String inputId) {
		String result;
		System.out.println("22222222222");
		result = inputId;
		System.out.println(result);
		return "Ajax_Test2";
	}
	
	
	// 0415 Ajax 테스트
	@RequestMapping(value="/ajaxTest1.do", method= RequestMethod.GET)
	public String ajax1() {
		System.out.println("ajax1.do");
		
		return "ajax";
	}		
	
	// 0415 Ajax 테스트
	@PostMapping("/ajax.do")
	@ResponseBody
	public Map<String, String> ajax() {
		System.out.println("@ResponseBody ajax.do");
	    //필요한 로직 처리
	 //return ajaxVO.getName() + ajaxVO.getAge();
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg","성공");
		map.put("A","A");
		map.put("B","B");
//		
//		List<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
		
		return map;
	}

	
	
	
}
