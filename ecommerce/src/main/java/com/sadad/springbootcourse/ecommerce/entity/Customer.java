package com.sadad.springbootcourse.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sadad.springbootcourse.ecommerce.config.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

//@Data
//@ToString(exclude = "orders")
//@EqualsAndHashCode(exclude = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_customer"
//        ,
//        uniqueConstraints =@UniqueConstraint(
//                name = "email_enique",
//                columnNames = "email_address"
//        )
)
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;


    @Column(name = "email_address")
    private String email;


    @OneToMany(mappedBy = "customer" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_customer_id" ,referencedColumnName = "id" ,nullable = false )
    @JsonIgnore
    private List<Order> orders;


}
