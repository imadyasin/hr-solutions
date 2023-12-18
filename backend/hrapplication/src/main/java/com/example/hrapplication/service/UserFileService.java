package com.example.hrapplication.service;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrapplication.entity.User;
import com.example.hrapplication.repository.UserRepository;

@Service
public class UserFileService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserFileService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String saveImage(MultipartFile file, String name , String email) throws IOException {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		
		user.setContentType("application/pdf");
		 
		user.setImage(file.getBytes());
		
		userRepository.save(user);
		
		return"Image Saved in Database";
		
	}

}
