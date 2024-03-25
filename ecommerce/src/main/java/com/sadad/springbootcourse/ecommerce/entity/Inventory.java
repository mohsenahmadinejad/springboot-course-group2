package com.sadad.springbootcourse.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_Inventory")
//@Audited

public class Inventory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;


    @OneToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @JsonBackReference("inventory")
    private Product product;

}