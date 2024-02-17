package com.bookmyshow.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.TheatreAdminDao;
import com.bookmyshow.BookMyShow.dto.TheatreAdminDto;
import com.bookmyshow.BookMyShow.entity.TheatreAdmin;
import com.bookmyshow.BookMyShow.exceptionHandling.TheatreAdminNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class TheatreAdminService {
	@Autowired
	TheatreAdminDao dao;

	public ResponseEntity<ResponseStructure<TheatreAdminDto>> saveTheatreAdmin(TheatreAdmin admin) {

		TheatreAdminDto dto = new TheatreAdminDto();
		ModelMapper mapper = new ModelMapper();
		mapper.map(dao.saveTheatreAdmin(admin), dto);
		ResponseStructure<TheatreAdminDto> structure = new ResponseStructure();
		structure.setData(dto);
		structure.setMessage("TheatreAdmin Saved Successfully!!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<TheatreAdminDto>> findTheatreAdmin(int theatreAdminId)
			throws TheatreAdminNotFound {
		if (dao.findTheatreAdmin(theatreAdminId) != null) {
			TheatreAdminDto dto = new TheatreAdminDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(dao.findTheatreAdmin(theatreAdminId), dto);
			ResponseStructure<TheatreAdminDto> structure = new ResponseStructure();
			structure.setData(dto);
			structure.setMessage("TheatreAdmin Found Successfully!!");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		throw new TheatreAdminNotFound("TheatreAdmin with id = " + theatreAdminId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<TheatreAdminDto>> deleteTheatreAdmin(int theatreAdminId)
			throws TheatreAdminNotFound {
		TheatreAdmin admin = dao.deleteTheatreAdmin(theatreAdminId);
		if (admin != null) {
			TheatreAdminDto dto = new TheatreAdminDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(admin, dto);
			ResponseStructure<TheatreAdminDto> structure = new ResponseStructure();
			structure.setData(dto);
			structure.setMessage("TheatreAdmin with id = " + theatreAdminId + " is Successfully Removed!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new TheatreAdminNotFound("TheatreAdmin with id = " + theatreAdminId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<TheatreAdminDto>> updateTheatreAdmin(TheatreAdmin admin, int theatreAdminId)
			throws TheatreAdminNotFound {
		TheatreAdmin returnadmin = dao.updateTheatreAdmin(admin, theatreAdminId);
		if (returnadmin != null) {
			TheatreAdminDto dto = new TheatreAdminDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(returnadmin, dto);
			ResponseStructure<TheatreAdminDto> structure = new ResponseStructure();
			structure.setData(dto);
			structure.setMessage("TheatreAdmin Updated Successfully!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new TheatreAdminNotFound("TheatreAdmin with id = " + theatreAdminId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<List<TheatreAdminDto>>> getAllTheatreAdmins() {

		List<TheatreAdminDto> dto = new ArrayList<TheatreAdminDto>();
		ModelMapper mapper = new ModelMapper();
		mapper.map(dao.getAllTheatreAdmins(), dto);
		ResponseStructure<List<TheatreAdminDto>> structure = new ResponseStructure();
		structure.setData(dto);
		structure.setMessage("Admin Retrived Successfully!!");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity(structure, HttpStatus.FOUND);
	}
}
