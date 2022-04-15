package com.project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //생성자를 자동으로 생성해주는 어노테이션
@NoArgsConstructor
@Entity(name="member")
public class MemberVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성을 데이터 베이스에 위임 하는 방식


	private int mbrNo;

	private String id;

	private String pass;
	
	private String email;
	
	private String name;
	
	private String gender;
	
	private String phone;
	
	
	@Builder
	public MemberVO(String id,String pass) {
//		this.mbrNo = mbrNo;
		this.id = id;
		this.pass = pass;
	}
	
	
	
}
