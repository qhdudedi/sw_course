package sku.lesson.spring.controller;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sku.lesson.spring.dto.MemberDTO;
import sku.lesson.spring.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {


	@RequestMapping(value = "/ajax", method = RequestMethod.POST)
	@ResponseBody
	public String checkId(HttpServletRequest request) {
		MemberService ms = new MemberService();
		boolean check = ms.checkId(request.getParameter("userId"));
		return "{\"result\":"+check+"}";
	}
	
	@RequestMapping(value = "/registView", method = RequestMethod.GET)
	public String registView() {
		return "./member/regist";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(HttpServletRequest request) {
		String name = request.getParameter("userName");
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		Timestamp date = new Timestamp(System.currentTimeMillis());
		MemberDTO dto = new MemberDTO(id, name, pwd, date);
		System.out.println(dto);
		//service 에게 전달
		MemberService ms = new MemberService();
		boolean flag = ms.registMember(dto);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public String list(HttpServletRequest request) {
		MemberService ms = new MemberService();
		ArrayList<MemberDTO> list = ms.getMemberData();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		return "./member/list";
	}
	
	//search
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request) {
		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		MemberDTO dto = ms.findById(id);
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		System.out.println("search >>> "+id);
		return "./member/detail";
	}
	//updateview
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(HttpServletRequest request) {
		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		MemberDTO dto = ms.findById(id);
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		System.out.println("update view >>> "+id);
		return "./member/update";
	}
	//update
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String name = request.getParameter("userName");
		
		//서비츠 요청
		MemberService ms = new MemberService();
		ms.modifyMember(new MemberDTO(id, name, pwd, null));

		System.out.println("update >>> "+id);
		//request.setAttribute("userId", id);
		return "redirect:search?userId="+id;
	}
	//delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		ms.remove(id);
		System.out.println("delete >>> "+id);
		return "redirect:list";
	}
}
