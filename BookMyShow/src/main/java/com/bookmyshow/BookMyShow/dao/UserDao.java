package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmyshow.BookMyShow.entity.User;
import com.bookmyshow.BookMyShow.repo.UserRepo;

public class UserDao {

	@Autowired
	UserRepo uRepo;
	
	public User saveUser(User user) {
		return uRepo.save(user);
	}
	
	public User findUser(int userId) {
		Optional<User> opUser = uRepo.findById(userId);
		if(opUser.isPresent()) {
			return opUser.get();
		}
		return null;
	}
	
	
	public User deleteUser(int userId) {
		User user = findUser(userId);
		if(user != null) {
			uRepo.delete(user);
			return user;
		}
		return null;
	}
	
	
	public User updateUser(User user, int userId) {
		User exiUser = findUser(userId);
		if(exiUser!=null) {
			user.setUserId(userId);
			return uRepo.save(user);
		}
		return null;
	}
	
	
	public List<User> getAllUser() {
		return uRepo.findAll();
	}
	
}
