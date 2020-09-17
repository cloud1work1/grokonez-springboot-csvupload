package com.grokonez.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.grokonez.entity.User;
import com.grokonez.repository.UserRepository;
import com.grokonez.util.CSVUtil;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public List<User> saveFile(MultipartFile file) {
		List<User> users = null;
		try {
			users = CSVUtil.parseCSVFile(file.getInputStream());
			userRepository.saveAll(users);
		} catch(IOException ioex) {
			throw new RuntimeException("Exception occured while storing file! -> " + ioex.getMessage());
		}
		return users;
	}
}
