package com.sairaj.springbootecommerce.service;

import com.sairaj.springbootecommerce.dao.CustomerRepository;
import com.sairaj.springbootecommerce.dto.Purchase;
import com.sairaj.springbootecommerce.dto.PurchaseResponse;
import com.sairaj.springbootecommerce.entity.Customer;
import com.sairaj.springbootecommerce.entity.Order;
import com.sairaj.springbootecommerce.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();;

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));


        // populate order with billingAddress and ShippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());


        // populate the customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);


    }

    private String generateOrderTrackingNumber() {
        //generate a random UUID number(UUID version-4)
        //For details see:

        return UUID.randomUUID().toString();

    }
}
