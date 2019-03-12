package com.jjy.board.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jjy.board.Vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int join(MemberVO memberVO) {
		System.out.println("보드DAO");
		return sqlSession.insert("Member.join", memberVO);
	}

	public MemberVO memberLogin(MemberVO memberVO) {
		return sqlSession.selectOne("Member.login", memberVO);
	}

}
