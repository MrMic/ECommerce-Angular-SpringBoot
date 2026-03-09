package fr.michaelchlon.ecommerce.service;

import fr.michaelchlon.ecommerce.dto.PurchaseDTO;
import fr.michaelchlon.ecommerce.dto.PurchaseResponseDTO;

public interface CheckoutService {
    PurchaseResponseDTO placeOrder(PurchaseDTO purchase);
}
