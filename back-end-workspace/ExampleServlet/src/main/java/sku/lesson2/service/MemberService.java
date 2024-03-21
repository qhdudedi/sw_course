package sku.lesson2.service;

import java.util.ArrayList;

import sku.lesson2.dao.MemberDAO;
import sku.lesson2.dto.MemberDTO;

public class MemberService {
	
	
	public boolean checkId(String id) {
		boolean flag = false;
		MemberDAO dao = new MemberDAO();
		flag = dao.selectById(id);
		return flag;
	}
	public boolean registMember(MemberDTO member) {
		boolean flag = false;
		MemberDAO dao = new MemberDAO();
		flag = dao.insert(member);
		return flag;
	}

	public ArrayList<MemberDTO> getMemberData() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = new MemberDAO().selectAll();
		return list;
	}
	//조건 조회
	public MemberDTO findById(String id) {
		MemberDTO dto = null;
		MemberDAO dao = new MemberDAO();
		dto = dao.select(id);
		return dto;
	}
	//수정
	public boolean modifyMember(MemberDTO dto) {
		boolean flag = false;
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
		return flag;
	}
	//삭제
	public boolean remove(String id) {
		boolean flag = false;
		flag = new MemberDAO().delete(id);
		return flag;
	}
}
