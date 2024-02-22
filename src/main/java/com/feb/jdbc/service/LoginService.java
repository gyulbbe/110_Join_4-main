package com.feb.jdbc.service;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.jdbc.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;

	public int join(HashMap<String, String> params) {
		
//		아이디가 6자 이하일 시 0반환
		String memberId = params.get("memberId");
		if(memberId.length()>=6) {
		return loginDao.join(params);
		} else {
			return 0;
		}
	}

	public boolean login(HashMap<String, String> params) {
		
		//비밀번호 같지 않으면 로그인 안되게
		String passWd = params.get("passWd");
		String realPassWd = loginDao.findPassWd(params);
		if(Objects.equals(passWd, realPassWd)){
			return true;
		} else {
			return false;
		}
		
	}
	
}
