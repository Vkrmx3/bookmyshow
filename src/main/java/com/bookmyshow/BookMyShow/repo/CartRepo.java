package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.BookMyShow.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
