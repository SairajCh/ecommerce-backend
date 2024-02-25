package com.sairaj.springbootecommerce.controller;

import com.sairaj.springbootecommerce.dto.Purchase;
import com.sairaj.springbootecommerce.dto.PurchaseResponse;
import com.sairaj.springbootecommerce.service.CheckoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    private CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
