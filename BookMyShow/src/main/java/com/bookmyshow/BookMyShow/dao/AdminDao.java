package com.bookmyshow.BookMyShow.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Admin;
import com.bookmyshow.BookMyShow.repo.AdminRepo;

@Repository
public class AdminDao {

	@Autowired
	AdminRepo aRepo;
	
	public Admin saveAdmin(Admin admin) {
		return aRepo.save(admin);
	}
	
	public Admin findAdmin(int adminId) {
		Optional<Admin> opAdmin = aRepo.findById(adminId);
		if(opAdmin.isPresent()) {
			return opAdmin.get();
		}
		return null;
	}
	
	
	public Admin deleteAdmin(int adminId) {
		Admin admin = findAdmin(adminId);
		if(admin != null) {
			aRepo.delete(admin);
			return admin;
		}
		return null;
	}
	
	
	public Admin updateAdmin(Admin admin, int adminId) {
		Admin exiAdmin = findAdmin(adminId);
		if(exiAdmin!=null) {
			admin.setAdminId(adminId);
			return aRepo.save(admin);
		}
		return null;
	}
	
	
	public List<Admin> getAllAdmin() {
		return aRepo.findAll();
	}
}
