package com.sadad.springbootcourse.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_customer"
        ,
        uniqueConstraints =@UniqueConstraint(
                name = "email_enique",
                columnNames = "email_address"
        )
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;


    @Column(name = "email_address")
    private String email;

}
