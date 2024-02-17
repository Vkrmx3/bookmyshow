package com.bookmyshow.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.BookMyShow.dto.AdminDto;
import com.bookmyshow.BookMyShow.entity.Admin;
import com.bookmyshow.BookMyShow.exceptionHandling.AdminNotFound;
import com.bookmyshow.BookMyShow.service.AdminService;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("BmsAdmin")
public class AdminController {
	@Autowired
AdminService service;
	
	@PostMapping("save")
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@Valid Admin admin, BindingResult result){
		return service.saveAdmin(admin);
	}
	
	@GetMapping("find")
	public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(int adminId) throws AdminNotFound
	{
		return service.findAdmin(adminId);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(int adminId) throws AdminNotFound {
	return service.deleteAdmin(adminId);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@Valid Admin admin, BindingResult result, int adminId) throws AdminNotFound {
	return service.updateAdmin(admin, adminId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<AdminDto>>> getAllAdmin() {
return service.getAllAdmins();
	}
}
