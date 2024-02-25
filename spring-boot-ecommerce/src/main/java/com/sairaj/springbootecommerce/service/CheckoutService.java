package com.sairaj.springbootecommerce.service;

import com.sairaj.springbootecommerce.dto.Purchase;
import com.sairaj.springbootecommerce.dto.PurchaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);



}
