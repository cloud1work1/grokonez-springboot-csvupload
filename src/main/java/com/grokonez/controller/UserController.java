package com.grokonez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grokonez.entity.User;
import com.grokonez.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/users/upload")
	public ResponseEntity<List<User>> loadAndSave(@RequestParam("file") MultipartFile file) {
		List<User> users = null;
		try {
			users = userService.saveFile(file);
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
