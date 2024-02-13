package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookmyshow.BookMyShow.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
