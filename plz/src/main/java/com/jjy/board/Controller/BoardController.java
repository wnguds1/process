package com.jjy.board.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jjy.board.Service.BoardService;
import com.jjy.board.Service.MemberService;
import com.jjy.board.Vo.BoardVO;
import com.jjy.board.Vo.MemberVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private ModelAndView mav;
	
	@Autowired
	private MemberService ms;
	@Autowired
	private BoardService bs;
	
	// 비밀번호 암호와
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView Join(@ModelAttribute MemberVO memberVO,HttpServletResponse response) {
		mav = new ModelAndView();
		System.out.println("보드컨트롤러 1");
		String encPassword = passEncoder.encode(memberVO.getPw());
		memberVO.setPw(encPassword);
		System.out.println("암호화 비밀번호 : "+memberVO.getPw());
		mav = ms.join(memberVO);
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView memberLogin(@ModelAttribute MemberVO memberVO, HttpServletResponse response)
			throws IOException {
		mav = new ModelAndView();
		mav = ms.memberLogin(memberVO, response);
		return mav;
	}
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView boardList(Locale locale, Model model ){
		mav = new ModelAndView();
		mav =  bs.boardList();
		return mav;
	}
	@RequestMapping(value="boardWriteform", method = RequestMethod.GET)
	public String gesipanwriteform(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		return "boardWrite";
	}
	
	
	
	
	
}
