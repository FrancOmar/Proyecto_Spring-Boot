package com.spring.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("12345"));

		//$2a$10$mTQxIK/ngAFtCJRlvSM3bOm4jYWQ6ZyfhW6./cSeOM1BrAnRXIi3G
		//$2a$10$/Go/t2a42cteUXsLGVOy1eXNG2vihi.WfrN33bS037H9Q2rYDr92W
	}

}
