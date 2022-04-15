package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Repository.MemberRepository;
import com.project.dto.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public int LoginCheck(MemberVO vo) { 
		List<MemberVO> member = memberRepository.findById(vo.getId()); 
		
		int val = 0;
		if(member != null) {
			if(member.get(0).getPass().equals(vo.getPass())){
				val = 1;
			}
		}
		return val; 
	}

	public int insertUser(MemberVO member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
		
		return 1;
	}

	public int CheckId(MemberVO vo) {
		// TODO Auto-generated method stub
		List<MemberVO> member = memberRepository.findById(vo.getId()); 
		int val = 0;
			if(member.size() >0) {
				val = 1;
			}
		return val;
	}



}
