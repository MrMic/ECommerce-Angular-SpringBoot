package fr.michaelchlon.ecommerce.service;

import fr.michaelchlon.ecommerce.dao.CustomerRepository;
import fr.michaelchlon.ecommerce.dto.PurchaseDTO;
import fr.michaelchlon.ecommerce.dto.PurchaseResponseDTO;
import fr.michaelchlon.ecommerce.entity.Customer;
import fr.michaelchlon.ecommerce.entity.Order;
import fr.michaelchlon.ecommerce.entity.OrderItem;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    // INFO: CONSTRUCTOR ─────────────────────────────────────────────────────
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponseDTO placeOrder(PurchaseDTO purchase) {
        // Retrieve the order info from dto
        Order order = purchase.getOrder();

        // Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // Populate the order with orderItems
        // Populate the order with billingAddress and shippingAddress
        // Populate the customer with order
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // Populate the order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // Populate the customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // Save to the database
        customerRepository.save(customer);

        // Return a response
        return new PurchaseResponseDTO(orderTrackingNumber);
    }

    // ______________________________________________________________________
    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        //   For details see: https://www.baeldung.com/java-uuid
        return UUID.randomUUID().toString();
    }
}
