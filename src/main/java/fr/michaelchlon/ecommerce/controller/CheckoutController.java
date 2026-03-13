package fr.michaelchlon.ecommerce.controller;

import fr.michaelchlon.ecommerce.dto.PurchaseDTO;
import fr.michaelchlon.ecommerce.dto.PurchaseResponseDTO;
import fr.michaelchlon.ecommerce.service.CheckoutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    // INFO: CONSTRUCTOR ─────────────────────────────────────────────────────
    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    // ______________________________________________________________________
    @PostMapping("/purchase")
    public PurchaseResponseDTO placeOrder(@RequestBody PurchaseDTO purchase) {
        PurchaseResponseDTO purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
