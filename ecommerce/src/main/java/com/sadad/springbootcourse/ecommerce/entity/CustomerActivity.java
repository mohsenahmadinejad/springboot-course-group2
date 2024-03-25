package com.sadad.springbootcourse.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//@Data
//@ToString(exclude = "customer")
//@EqualsAndHashCode(exclude = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_Customer_Activity")
//@Audited

public class CustomerActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime activityDate;


    @ManyToOne
    @JoinColumn(name = "fk_customer_id",referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;




}
