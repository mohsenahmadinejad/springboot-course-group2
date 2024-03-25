package com.sadad.springbootcourse.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

//@Data
//@ToString(exclude = "customer")
//@EqualsAndHashCode(exclude = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String  status;


    @ManyToOne
    @JoinColumn(name = "fk_customer_id",referencedColumnName = "id")
    private Customer customer;



    @OneToMany(mappedBy = "order" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;


    @OneToOne(mappedBy = "order" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;

}
