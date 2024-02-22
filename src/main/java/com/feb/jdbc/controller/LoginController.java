package com.feb.jdbc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/loginPage.do")
	public String goLoginForm() {
		return "login";
	}
	
	@PostMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params, 
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int result = loginService.join(params);
		if(result == 1) {
			mv.addObject("msg", "회원가입 성공");
		} else {
			mv.addObject("msg", "회원가입 실패");
		}
		mv.setViewName("login");
		return mv;
	}
	
	@PostMapping("/login.do")
	public ModelAndView login(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		
		boolean isLoggedIn = loginService.login(params);
		if(isLoggedIn) {
			mv.addObject("msg", "로그인 성공");
		} else {
			mv.addObject("msg", "로그인 실패");
		}
		mv.setViewName("login");
		return mv;
	}
}
