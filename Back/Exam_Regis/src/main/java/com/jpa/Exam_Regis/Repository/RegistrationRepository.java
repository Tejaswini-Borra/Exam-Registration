package com.jpa.Exam_Regis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.Exam_Regis.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {

	public User findByemailid(String emailid);

	public User findByemailidAndPassword(String emailid, String password);

}
