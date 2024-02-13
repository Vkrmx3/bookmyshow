package com.bookmyshow.BookMyShow.dto;

import java.util.List;

import com.bookmyshow.BookMyShow.entity.Theatre;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreAdminDto {

	private int theatreAdminId;
	private String theatreAdminName;
	private String theatreAdminEmail;
	
	private List<Theatre> theatre;
}
