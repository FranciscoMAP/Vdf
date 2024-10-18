package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Login;
import com.repository.LoginRepository;

import jakarta.annotation.PostConstruct;

@Service
public class LoginService {
	
	
	@Autowired
	LoginRepository loginRepository;
	
	@PostConstruct // make sure that this method is executed before rest to save admin data
	public void init() {
		Login ll = new Login();
		ll.setEmailid("admin@gmail.com");
		ll.setEmailpassword("admin123");
		loginRepository.save(ll);
	}
	
	
	public String signIn(Login login) {
		Optional<Login> loginResult =loginRepository.findLoginByEmailAndPassword(login.getEmailid(), login.getEmailpassword());
		if (loginResult.isPresent()){
			if (login.getEmailid().equals("admin@gmail.com") && login.getEmailpassword().equals("admin123")) {
				return "admin";
			}
			else return "customer";
			
		}else return "error";
	}
	
	public Boolean signUp( Login login) {
		Optional<Login> loginResult =loginRepository.findLoginByEmail(login.getEmailid());
		if(loginResult.isPresent()) {
			return false;
		}else {
			loginRepository.save(login);
			return true;	
			}
	}
	
	public boolean updateAdminPassword(String emailpassword) { return loginRepository.updateAdminPassword(emailpassword)>0;
	}
	
}
	


