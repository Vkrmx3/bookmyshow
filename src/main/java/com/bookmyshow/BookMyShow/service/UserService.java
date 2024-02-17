package com.bookmyshow.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.UserDao;
import com.bookmyshow.BookMyShow.dto.UserDto;
import com.bookmyshow.BookMyShow.entity.User;
import com.bookmyshow.BookMyShow.exceptionHandling.UserNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user) {

		UserDto dto = new UserDto();
		ModelMapper mapper = new ModelMapper();
		mapper.map(dao.saveUser(user), dto);
		ResponseStructure<UserDto> structure = new ResponseStructure();
		structure.setData(dto);
		structure.setMessage("User Saved Successfully!!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<UserDto>> findUser(int userId) throws UserNotFound {
		if (dao.findUser(userId) != null) {
			UserDto dto = new UserDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(dao.findUser(userId), dto);
			ResponseStructure<UserDto> structure = new ResponseStructure();
			structure.setData(dto);
			structure.setMessage("User Found Successfully!!");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		throw new UserNotFound("Admin with id = " + userId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int userId) throws UserNotFound {
		User user = dao.deleteUser(userId);
		if (user != null) {
			UserDto dto = new UserDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(user, dto);
			ResponseStructure<UserDto> structure = new ResponseStructure();
			structure.setData(dto);
			structure.setMessage("User with id = " + userId + " is Successfully Removed!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new UserNotFound("User with id = " + userId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user, int userId) throws UserNotFound {
		User returnUser = dao.updateUser(user, userId);
		if (returnUser != null) {
			UserDto dto = new UserDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(returnUser, dto);
			ResponseStructure<UserDto> structure = new ResponseStructure();
			structure.setData(dto);
			structure.setMessage("User Updated Successfully!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new UserNotFound("User with id = " + userId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<List<UserDto>>> getAllUsers() {

		List<UserDto> dto = new ArrayList<UserDto>();
		ModelMapper mapper = new ModelMapper();
		mapper.map(dao.getAllUsers(), dto);
		ResponseStructure<List<UserDto>> structure = new ResponseStructure();
		structure.setData(dto);
		structure.setMessage("User Retrived Successfully!!");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity(structure, HttpStatus.FOUND);
	}
}
