package com.example.hrapplication.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrapplication.entity.User;
import com.example.hrapplication.repository.UserRepository;
import com.example.hrapplication.service.UserFileService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserFileService userFileService;
	
	@GetMapping("/get")
	public String sayHi(){
		return "hiiiii";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/save")
	public String saveImageOrFile(@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("email") String email) throws IOException
	{
		return userFileService.saveImage(file, name, email);
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
	    List<User> users = userRepository.findAll();
	    users.forEach(user -> user.setContentType("application/pdf")); // Set content type for each user
	    return users;
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }

}
