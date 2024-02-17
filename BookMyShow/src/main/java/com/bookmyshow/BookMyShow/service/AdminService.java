package com.bookmyshow.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.AdminDao;
import com.bookmyshow.BookMyShow.dto.AdminDto;
import com.bookmyshow.BookMyShow.entity.Admin;
import com.bookmyshow.BookMyShow.exceptionHandling.AdminNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	AdminDao dao;
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin) {
	
		AdminDto dto=new AdminDto();
		ModelMapper mapper=new ModelMapper();
		 mapper.map(dao.saveAdmin(admin),dto);
		 ResponseStructure<AdminDto> structure=new ResponseStructure();
		 structure.setData(dto);
		 structure.setMessage("Admin Saved Successfully!!");
		 structure.setStatus(HttpStatus.CREATED.value());
		 return new ResponseEntity(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(int adminId) throws AdminNotFound {
		if(dao.findAdmin(adminId)!=null)
		{
		AdminDto dto=new AdminDto();
		ModelMapper mapper=new ModelMapper();
		 mapper.map(dao.findAdmin(adminId),dto);
		 ResponseStructure<AdminDto> structure=new ResponseStructure();
		 structure.setData(dto);
		 structure.setMessage("Admin Found Successfully!!");
		 structure.setStatus(HttpStatus.FOUND.value());
		 return new ResponseEntity(structure,HttpStatus.FOUND);
		}
		throw new AdminNotFound("Admin with id = "+adminId+" is Not Found");
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(int adminId) throws AdminNotFound {
		Admin admin=dao.deleteAdmin(adminId);
		if(admin!=null)
		{
		AdminDto dto=new AdminDto();
		ModelMapper mapper=new ModelMapper();
		 mapper.map(admin,dto);
		 ResponseStructure<AdminDto> structure=new ResponseStructure();
		 structure.setData(dto);
		 structure.setMessage("Admin with id = "+adminId+" is Successfully Removed!!");
		 structure.setStatus(HttpStatus.OK.value());
		 return new ResponseEntity(structure,HttpStatus.OK);
		}
		throw new AdminNotFound("Admin with id = "+adminId+" is Not Found");
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(Admin admin, int adminId) throws AdminNotFound {
		Admin returnadmin=dao.updateAdmin(admin,adminId);
		if(returnadmin!=null)
		{
		AdminDto dto=new AdminDto();
		ModelMapper mapper=new ModelMapper();
		 mapper.map(returnadmin,dto);
		 ResponseStructure<AdminDto> structure=new ResponseStructure();
		 structure.setData(dto);
		 structure.setMessage("Admin Saved Successfully!!");
		 structure.setStatus(HttpStatus.OK.value());
		 return new ResponseEntity(structure,HttpStatus.OK);
		}
		throw new AdminNotFound("Admin with id = "+adminId+" is Not Found");
	}
	
	public ResponseEntity<ResponseStructure<List<AdminDto>>> getAllAdmin() {
		
		List<AdminDto> dto=new ArrayList<AdminDto>();
		ModelMapper mapper=new ModelMapper();
		 mapper.map(dao.getAllAdmin(),dto);
		 ResponseStructure<List<AdminDto>> structure=new ResponseStructure();
		 structure.setData(dto);
		 structure.setMessage("Admin Saved Successfully!!");
		 structure.setStatus(HttpStatus.FOUND.value());
		 return new ResponseEntity(structure,HttpStatus.FOUND);
	}
}
