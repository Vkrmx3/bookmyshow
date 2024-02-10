package com.bookmyshow.BookMyShow.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TheatreAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreAdminId;
	private String theatreAdminName;
	private String theatreAdminEmail;
	private String theatreAdminPassword;
	
	@OneToMany
	private List<Theatre> theatre;
	
}
