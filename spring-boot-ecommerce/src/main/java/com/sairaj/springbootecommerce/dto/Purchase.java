package com.sairaj.springbootecommerce.dto;

import com.sairaj.springbootecommerce.entity.Address;
import com.sairaj.springbootecommerce.entity.Customer;
import com.sairaj.springbootecommerce.entity.Order;
import com.sairaj.springbootecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {


    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem>  orderItems;


}
