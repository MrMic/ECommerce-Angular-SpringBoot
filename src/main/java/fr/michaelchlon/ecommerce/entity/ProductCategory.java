package fr.michaelchlon.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "product_category")
// @Data - Lombok / known bug
@Getter
@Setter
public class ProductCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "category_name")
  private String CategoryName;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
  private Set<Product> products;
}
