package com.jpa.Exam_Regis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.Exam_Regis.Repository.RegistrationRepository;
import com.jpa.Exam_Regis.model.User;


@Service
public class RegistrationService{
	
	@Autowired
	private RegistrationRepository re;
	
   public User saveUser(User user) {
		return re.save(user);
	}
	
   public User fetchUserByEmailId(String eid) {
	   return re.findByemailid(eid);
   }

public User FetchByEmailIdAndPassword(String eid, String pas) {
	return re.findByemailidAndPassword(eid, pas);
}
 
}
