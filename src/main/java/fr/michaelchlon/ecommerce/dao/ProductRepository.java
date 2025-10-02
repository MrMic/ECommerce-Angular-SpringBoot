package fr.michaelchlon.ecommerce.dao;

import fr.michaelchlon.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
