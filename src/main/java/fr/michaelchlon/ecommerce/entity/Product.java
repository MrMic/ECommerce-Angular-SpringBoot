package fr.michaelchlon.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
public class Product {

  private Long id;
  private String sku;
  private String name;
  private String description;
  private BigDecimal unitPrice;
  private String imageUrl;
  private boolean active;
  private int unitsInStock;
  private Date dateCreated;
  private Date lastUpdated;

}
