package com.controller;

import com.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.LoginService;
import com.service.ProductService;


@Controller
//@RequestMapping("shorty-shoes") // http://localhost:9191/shorty-shoes/*
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "shorty-shoes/login") // http://localhost:9191/shorty-shoes/login*
	public String openLoginPage () {
		return "Login";
	}

	@PostMapping(value = "shorty-shoes/signIn")
	public String loginPage (Login ll, Model mm) {
		String loginResult = loginService.signIn(ll);
		if (loginResult.equals("admin")) {
			mm.addAttribute("product_mgmt", new Product());
			mm.addAttribute("buttonText", "Add product");
		//	mm.addAttribute("buttonText2", "Delete product");
		//	mm.addAttribute("buttonText3", "View product");
			mm.addAttribute("products",productService.findAll());
			return "Admin";
		}
		else if (loginResult.equals("customer")) {
			mm.addAttribute("productFiltered", new Product());
			mm.addAttribute("products",productService.findAll());
			return "Customer";}
		else {
			mm.addAttribute("msgSignUpError", "Login doesn't exist");
			return "Login";
		}
	}
	
	@PostMapping(value = "shorty-shoes/signUp")
	public String signUpPage (Login ll, Model mm) {
		Boolean signUpResult = loginService.signUp(ll);
		if (signUpResult)mm.addAttribute("msgSignUpSuccess", "Success");
		else mm.addAttribute("msgSignUpError", "Error");
		return "Login";
	}
	
	@PostMapping(value = "updateAdminPassword")
	public String updateAdminPassword(Model mm, Login login){
		if(loginService.updateAdminPassword(login.getEmailpassword())) {
			mm.addAttribute("msgPasswordUpdateSucess", "Password updated");
		}else mm.addAttribute("msgPasswordUpdateError", "Password not updated");
		
		mm.addAttribute("product_mgmt", new Product());
		mm.addAttribute("buttonText", "Add product");
		mm.addAttribute("products",productService.findAll());
		
		return "Admin";
		
	}
	
	

}
