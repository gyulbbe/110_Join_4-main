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

		//입력id = 클라이언트가 화면에 입력한 id
		String memberId = params.get("memberId");
		//진짜id = db에 저장되어있는 id
		String realMemberId = loginDao.findSameId(params);

		//중복검사
		if(Objects.equals(memberId, realMemberId)) {
			return 0;
		}
		
		//아이디가 6자 이하일 시 0반환
		if(memberId.length()>=6) {
			return loginDao.join(params);
		} else {
			return 0;
		}
	}

	public boolean login(HashMap<String, String> params) {

		//입력 pw = 클라이언트가 화면에 입력한 비밀번호
		String passWd = params.get("passWd");
		//진짜 pw = db에 저장되어있는 비밀번호
		String realPassWd = loginDao.findPassWd(params);

		//비밀번호 확인
		if(Objects.equals(passWd, realPassWd)) {
			return true;
		} else {
			return false;
		}

	}
}
