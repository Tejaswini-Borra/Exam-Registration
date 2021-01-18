package com.jpa.Exam_Regis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.Exam_Regis.model.User;
import com.jpa.Exam_Regis.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/register")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String eid=user.getEmailid();
		if(eid!=null && !"".equals(eid))
		{
			User obj1=service.fetchUserByEmailId(eid);
			if(obj1!=null) {
				throw new Exception("User is already Registered");
			}
		}
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	

	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String eid=user.getEmailid();
		String pas=user.getPassword();
		User obj2=null;
		if(eid!=null && !"".equals(eid))
		{
			obj2=service.FetchByEmailIdAndPassword(eid,pas);
		}
		if(obj2 == null) {
			throw new Exception("Bad credentails");
		}
		return obj2;
	}

}
