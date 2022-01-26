package com.carstore.billingservice.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carstore.CarStoreModel.dao.CarRepository;
import com.carstore.CarStoreModel.dao.UserRepository;
import com.carstore.CarStoreModel.model.Car;
import com.carstore.CarStoreModel.model.CartItem;
import com.carstore.CarStoreModel.model.ShoppingCart;
import com.carstore.CarStoreModel.model.User;
import com.carstore.billingservice.service.CartItemService;
import com.carstore.billingservice.service.ShoppingCartService;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping("/add")
	public ResponseEntity<String> addItem(@RequestBody HashMap<String, String> mapper, Principal principal) {
		String carId = (String) mapper.get("carId");
		String qty = (String) mapper.get("qty");

		User user = userRepository.findByUsername(principal.getName());
		Car car = carRepository.findById(Long.parseLong(carId)).orElse(null);

		if (Integer.parseInt(qty) > car.getInStockNumber()) {
			return new ResponseEntity<String>("Not Enough Stock!", HttpStatus.BAD_REQUEST);
		}

		CartItem cartItem = cartItemService.addCarToCartItem(car, user, Integer.parseInt(qty));

		return new ResponseEntity<String>("Car Added Successfully!", HttpStatus.OK);
	}

	@RequestMapping("/getCartItemList")
	public List<CartItem> getCartItemList(Principal principal) {
		User user = userRepository.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();

		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

		shoppingCartService.updateShoppingCart(shoppingCart);

		return cartItemList;
	}

	@RequestMapping("/getShoppingCart")
	public ShoppingCart getShoppingCart(Principal principal) {
		User user = userRepository.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();

		shoppingCartService.updateShoppingCart(shoppingCart);

		return shoppingCart;
	}

	@RequestMapping("/removeItem")
	public ResponseEntity<String> removeItem(@RequestBody String id) {
		cartItemService.removeCartItem(cartItemService.findById(Long.parseLong(id)));

		return new ResponseEntity<String>("Cart Item Removed Successfully!", HttpStatus.OK);
	}

	@RequestMapping("/updateCartItem")
	public ResponseEntity<String> updateCartItem(@RequestBody HashMap<String, String> mapper) {
		String cartItemId = mapper.get("cartItemId");
		String qty = mapper.get("qty");

		CartItem cartItem = cartItemService.findById(Long.parseLong(cartItemId));
		cartItem.setQty(Integer.parseInt(qty));

		cartItemService.updateCartItem(cartItem);

		return new ResponseEntity<String>("Cart Item Updated Successfully!", HttpStatus.OK);
	}

}
