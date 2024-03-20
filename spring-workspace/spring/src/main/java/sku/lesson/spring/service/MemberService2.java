package sku.lesson.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sku.lesson.spring.dao.MemberDAO2;
import sku.lesson.spring.dto.MemberDTO;

@Service
public class MemberService2 {
	
	@Autowired
	private MemberDAO2 dao;
	
	public boolean checkId(String id) {
		boolean flag = false;
		flag = dao.selectById(id);
		return flag;
	}
	public boolean registMember(MemberDTO member) {
		boolean flag = false;
		flag = dao.insert(member);
		return flag;
	}

	public ArrayList<MemberDTO> getMemberData() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = dao.selectAll();
		return list;
	}
	//조건 조회
	public MemberDTO findById(String id) {
		MemberDTO dto = null;
		dto = dao.select(id);
		return dto;
	}
	//수정
	public boolean modifyMember(MemberDTO dto) {
		boolean flag = false;
		dao.update(dto);
		return flag;
	}
	//삭제
	public boolean remove(String id) {
		boolean flag = false;
		flag = dao.delete(id);
		return flag;
	}
}
