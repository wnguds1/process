package com.jjy.board.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jjy.board.Dao.BoardDAO;
import com.jjy.board.Vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private HttpSession session;
	@Autowired
	private BoardDAO bdao;
	
	private ModelAndView mav;
	
	public ModelAndView boardList() {
		mav = new ModelAndView();
		List<BoardVO> blist=bdao.boardLsit();
		mav.addObject("boardList", blist);
		mav.setViewName("boardList");
		return mav;
	}

}
