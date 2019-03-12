package com.jjy.board.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jjy.board.Dao.MemberDAO;
import com.jjy.board.Vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	
	public ModelAndView join(MemberVO memberVO) {
		System.out.println("보드서비스1");
		mav = new ModelAndView();
		int result = mDAO.join(memberVO);
		if(result == 0) {
			System.out.println("보드서비스2");
			mav.setViewName("home");
		}
		else {
			System.out.println("보드서비스3");
			mav.setViewName("loginForm");
		}
		return mav;
	}

	public ModelAndView memberLogin(MemberVO memberVO, HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		MemberVO loginMember = mDAO.memberLogin(memberVO);
		PrintWriter out = response.getWriter();
		
		if(passEncoder.matches(memberVO.getPw(), loginMember.getPw())) {
			session.setAttribute("session_id", memberVO.getId());
			session.setAttribute("id", memberVO.getId());
			mav.addObject("loginMember", loginMember);
			mav.setViewName("main");
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1)");// 이전 페이지로 이동!
			out.println("</script>");
			out.close();
		}
		return mav;
	}

}
