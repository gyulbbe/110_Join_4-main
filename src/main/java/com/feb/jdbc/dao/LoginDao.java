package com.feb.jdbc.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.feb.jdbc.entity.Login;

@Repository
public interface LoginDao {

	public int join(HashMap<String, String> params);

	public Login login(HashMap<String, String> params);
	
	public String findPassWd(HashMap<String, String> params);

}