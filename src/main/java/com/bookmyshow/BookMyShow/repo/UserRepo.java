package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookmyshow.BookMyShow.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
