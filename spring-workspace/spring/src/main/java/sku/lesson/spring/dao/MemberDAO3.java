package sku.lesson.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sku.lesson.spring.dto.MemberDTO;
import sku.lesson.spring.utils.ConnectionManager;

@Repository
public class MemberDAO3 {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(MemberDTO member) {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.member.insert", member);
		if(affectedCount>0) {
			flag = true;
		}
		
		return flag;
	}

	public ArrayList<MemberDTO> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = null;
		list = (ArrayList)sqlSession.selectList("mapper.member.selectAll");
		
		return list;
	}
	
	//search
	public MemberDTO select(String id) {
		MemberDTO dto = null;
		dto = sqlSession.selectOne("mapper.member.select", id);
		return dto;
	}
	//update
	public boolean update(MemberDTO dto) {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.member.update",dto);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}
	//delete
	public boolean delete(String id) {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.member.delete",id);
		if(affectedCount>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public boolean selectById(String id) {
		boolean flag = false;
		int affectedCount = sqlSession.selectOne("mapper.member.selectById",id);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}
}






