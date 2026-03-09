package fr.michaelchlon.ecommerce.service;

import fr.michaelchlon.ecommerce.dao.CustomerRepository;
import fr.michaelchlon.ecommerce.dto.PurchaseDTO;
import fr.michaelchlon.ecommerce.dto.PurchaseResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    // INFO: CONSTRUCTOR ─────────────────────────────────────────────────────
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseResponseDTO placeOrder(PurchaseDTO purchase) {
        // TODO Auto-generated method stub
        return null;
    }
}
