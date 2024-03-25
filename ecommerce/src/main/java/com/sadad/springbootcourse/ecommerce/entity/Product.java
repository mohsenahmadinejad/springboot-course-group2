package com.sadad.springbootcourse.ecommerce.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


//@Data
@Getter
@Setter
//@EqualsAndHashCode
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_Product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private String  productName;
    private Double unitPrice;
    private String description;



    @ManyToMany(mappedBy = "products")
    private List<Category> categories;



}

