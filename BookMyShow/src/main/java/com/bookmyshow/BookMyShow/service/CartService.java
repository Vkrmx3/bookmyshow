package com.bookmyshow.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.CartDao;
import com.bookmyshow.BookMyShow.entity.Cart;
import com.bookmyshow.BookMyShow.exceptionHandling.CartNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class CartService {


	@Autowired
	CartDao dao;
	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart) {
	
		
		 ResponseStructure<Cart> structure=new ResponseStructure();
		 structure.setData(dao.saveCart(cart));
		 structure.setMessage("Cart Saved Successfully!!");
		 structure.setStatus(HttpStatus.CREATED.value());
		 return new ResponseEntity(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Cart>> findCart(int cartId) throws CartNotFound {
		if(dao.findCart(cartId)!=null)
		{
		
		 ResponseStructure<Cart> structure=new ResponseStructure();
		 structure.setData(dao.findCart(cartId));
		 structure.setMessage("Cart Found Successfully!!");
		 structure.setStatus(HttpStatus.FOUND.value());
		 return new ResponseEntity(structure,HttpStatus.FOUND);
		}
		throw new CartNotFound("Cart with id = "+cartId+" is Not Found");
	}
	
	public ResponseEntity<ResponseStructure<Cart>> deleteCart(int cartId) throws CartNotFound {
		Cart cart=dao.deleteCart(cartId);
		if(cart!=null)
		{
		 ResponseStructure<Cart> structure=new ResponseStructure();
		 structure.setData(cart);
		 structure.setMessage("Cart with id = "+cartId+" is Successfully Removed!!");
		 structure.setStatus(HttpStatus.OK.value());
		 return new ResponseEntity(structure,HttpStatus.OK);
		}
		throw new CartNotFound("Cart with id = "+cartId+" is Not Found");
	}
	
	public ResponseEntity<ResponseStructure<Cart>> updateCart(Cart cart, int cartId) throws CartNotFound {
		Cart returncart=dao.updateCart(cart,cartId);
		if(returncart!=null)
		{
	
		 ResponseStructure<Cart> structure=new ResponseStructure();
		 structure.setData(returncart);
		 structure.setMessage("Cart with id = "+cartId+"is Successfully Updated!!");
		 structure.setStatus(HttpStatus.OK.value());
		 return new ResponseEntity(structure,HttpStatus.OK);
		}
		throw new CartNotFound("Cart with id = "+cartId+" is Not Found");
	}
	
	public ResponseEntity<ResponseStructure<List<Cart>>> getAllCart() {
		
		 ResponseStructure<List<Cart>> structure=new ResponseStructure();
		 structure.setData(dao.getAllCart());
		 structure.setMessage("Admin Saved Successfully!!");
		 structure.setStatus(HttpStatus.FOUND.value());
		 return new ResponseEntity(structure,HttpStatus.FOUND);
	}
}
