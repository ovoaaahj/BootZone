package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.MemberVO;
import com.project.service.MemberService;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
	
	@Autowired MemberService MemberService;
	
	//로그인
	@PostMapping(value="/login")
	public Map<String,Object> login(@RequestBody Map<String, Object> params){
		Map<String,Object> map = new HashMap<String,Object>();
		MemberVO member = new MemberVO();
		member.setId((String) params.get("id"));
		member.setPass((String) params.get("pass"));
		
		System.out.println("id ::"+params.get("id"));
		System.out.println("pass ::"+params.get("pass"));
		
		int val = MemberService.LoginCheck(member);
		
		System.out.println("val ::"+val);
		
		map.put("result", val);
		
		return map;
	}
	
	//회원가입
	@PostMapping(value="/join")
	public Map<String,Object> join(@RequestBody Map<String,Object> params){
//	public Map<String,Object> join(MemberVO member){
		Map<String,Object> map = new HashMap<String,Object>();

		MemberVO member = new MemberVO();
		member.setId((String) params.get("id"));
		member.setPass((String)params.get("pass"));
		member.setEmail((String)params.get("email"));
		member.setName((String)params.get("name"));
		member.setPhone((String)params.get("phone"));
		int val = MemberService.insertUser(member);
		map.put("result", val);
		return map;
	}
	
	//아이디 중복체크 result  값이 1이면 있다 , 0이면 없다.
	@PostMapping(value="/idcheck")
	public Map<String,Object> idcheck(@RequestBody Map<String,Object> params){
		
		Map<String,Object> map = new HashMap<String,Object>();
		MemberVO member = new MemberVO();
		member.setId((String) params.get("id"));
		
		int val = MemberService.CheckId(member);
		
		map.put("result", val);
		return map;
	}
	
	
}
