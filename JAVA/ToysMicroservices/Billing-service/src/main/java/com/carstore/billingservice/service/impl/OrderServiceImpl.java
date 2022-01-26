package com.carstore.billingservice.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carstore.CarStoreModel.dao.BillingAddressRepository;
import com.carstore.CarStoreModel.dao.OrderRepository;
import com.carstore.CarStoreModel.dao.PaymentRepository;
import com.carstore.CarStoreModel.dao.ShippingAddressRepository;
import com.carstore.CarStoreModel.model.BillingAddress;
import com.carstore.CarStoreModel.model.Car;
import com.carstore.CarStoreModel.model.CartItem;
import com.carstore.CarStoreModel.model.Order;
import com.carstore.CarStoreModel.model.Payment;
import com.carstore.CarStoreModel.model.ShippingAddress;
import com.carstore.CarStoreModel.model.ShoppingCart;
import com.carstore.CarStoreModel.model.User;
import com.carstore.CarStoreModel.utility.MailTemplate;
import com.carstore.billingservice.service.CartItemService;
import com.carstore.billingservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillingAddressRepository billingAddressRepository;

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private MailTemplate mailTemplate;

    public synchronized Order createOrder(
            ShoppingCart shoppingCart,
            ShippingAddress shippingAddress,
            BillingAddress billingAddress,
            Payment payment,
            String shippingMethod,
            User user
    ) {
        Order order = new Order();
        order.setBillingAddress(billingAddress);
        order.setOrderStatus("created");
        order.setPayment(payment);
        order.setShippingAddress(shippingAddress);
        order.setShippingMethod(shippingMethod);

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        for (CartItem cartItem : cartItemList) {
            Car car = cartItem.getCar();
            cartItem.setOrder(order);
            car.setInStockNumber(car.getInStockNumber() - cartItem.getQty());
        }

        order.setCartItemList(cartItemList);
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setOrderTotal(shoppingCart.getGrandTotal());
        shippingAddress.setOrder(order);
        billingAddress.setOrder(order);
        payment.setOrder(order);
        order.setUser(user);
        order = orderRepository.save(order);

        return order;
    }

    public Order findOne(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public BillingAddressRepository getBillingAddressRepository() {
		return billingAddressRepository;
	}

	public void setBillingAddressRepository(BillingAddressRepository billingAddressRepository) {
		this.billingAddressRepository = billingAddressRepository;
	}

	public ShippingAddressRepository getShippingAddressRepository() {
		return shippingAddressRepository;
	}

	public void setShippingAddressRepository(ShippingAddressRepository shippingAddressRepository) {
		this.shippingAddressRepository = shippingAddressRepository;
	}

	public PaymentRepository getPaymentRepository() {
		return paymentRepository;
	}

	public void setPaymentRepository(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	public CartItemService getCartItemService() {
		return cartItemService;
	}

	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	public MailTemplate getMailTemplate() {
		return mailTemplate;
	}

	public void setMailTemplate(MailTemplate mailTemplate) {
		this.mailTemplate = mailTemplate;
	}
}