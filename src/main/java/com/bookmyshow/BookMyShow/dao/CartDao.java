package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Cart;
import com.bookmyshow.BookMyShow.repo.CartRepo;

@Repository
public class CartDao {

	@Autowired
	CartRepo cRepo;

	public Cart saveCart(Cart cart) {
		return cRepo.save(cart);
	}

	public Cart findCart(int cartId) {
		Optional<Cart> opCart = cRepo.findById(cartId);
		if (opCart.isPresent()) {
			return opCart.get();
		}
		return null;
	}

	public Cart deleteCart(int cartId) {
		Cart cart = findCart(cartId);
		if (cart != null) {
			cRepo.delete(cart);
			return cart;
		}
		return null;
	}

	public Cart updateCart(Cart cart, int cartId) {
		Cart exiCart = findCart(cartId);
		if (exiCart != null) {
			cart.setCartId(cartId);
			return cRepo.save(cart);
		}
		return null;
	}

	public List<Cart> getAllCarts() {
		return cRepo.findAll();
	}
}
