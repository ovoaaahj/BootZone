package com.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.MemberVO;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long>{
	
	public List<MemberVO> findById(String id); 
	
	public List<MemberVO> findByPass(String pass); //like검색도 가능 

}
