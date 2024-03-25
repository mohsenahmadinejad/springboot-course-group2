package com.sadad.springbootcourse.ecommerce.entity;


import jakarta.persistence.*;
import lombok.*;


//@Data
@Getter
@Setter
//@EqualsAndHashCode(exclude = "order")
//@ToString(exclude = "order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_Shipping_Address")
@Entity
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private String  street;
    private String  city;
    private String  state;
    private String  zipCode;


    @OneToOne
    @JoinColumn(name = "fk_order_id",referencedColumnName = "id")
    private Order order;




}

