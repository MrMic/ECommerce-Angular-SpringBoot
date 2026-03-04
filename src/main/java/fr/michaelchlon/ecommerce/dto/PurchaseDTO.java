package fr.michaelchlon.ecommerce.dto;

import fr.michaelchlon.ecommerce.entity.Address;
import fr.michaelchlon.ecommerce.entity.Customer;
import fr.michaelchlon.ecommerce.entity.Order;
import fr.michaelchlon.ecommerce.entity.OrderItem;

import lombok.Data;

import java.util.Set;

@Data
public class PurchaseDTO {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
