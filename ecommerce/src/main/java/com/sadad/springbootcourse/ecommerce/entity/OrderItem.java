package com.sadad.springbootcourse.ecommerce.entity;


import jakarta.persistence.*;
import lombok.*;


//@Data
@Getter
@Setter
//@EqualsAndHashCode(exclude = "customer")
//@ToString(exclude = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_order_item")
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private String  productName;
    private Integer quantity;
    private Double price;


    @ManyToOne
    @JoinColumn(name = "fk_order_id",referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "fk_product_id",referencedColumnName = "id")
    private Product product;





}

