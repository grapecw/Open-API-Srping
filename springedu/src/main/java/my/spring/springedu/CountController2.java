package my.spring.springedu;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.CountVO;
@Controller
public class CountController2 {	
	@RequestMapping(value="/count2")
	public void handle(int num1, int num2, HttpSession s) {
		if(s.getAttribute("count3") == null )
			s.setAttribute("count3", new CountVO());
		if(s.getAttribute("count4") == null )
			s.setAttribute("count4", new CountVO());
		
		CountVO vo3 = (CountVO)s.getAttribute("count3");
		CountVO vo4 = (CountVO)s.getAttribute("count4");
		
		vo3.setCountNum(num1);
		vo4.setCountNum(num2);
		System.out.println("handle() : "+ 
			      vo3.getCountNum() + " : " + vo4.getCountNum());
		
		System.out.println("=============================");
	}
	@RequestMapping(value="/countdel2")
	public void handle(HttpSession s, String who) {
		if(who != null) {
			s.removeAttribute(who);
			// 세션 객체를 사용하는건 가능하지만 직접 세션 객체를 삭제하는건 안되서 이렇게 일정 부분만 지우는거임.
			System.out.println(who + " deleted!");		
		}		
		System.out.println("=============================");
	}
}



