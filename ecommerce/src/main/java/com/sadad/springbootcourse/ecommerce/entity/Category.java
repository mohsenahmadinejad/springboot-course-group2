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
@Table(name = "tbl_category")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private String  categoryName;

    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_category_product",
            joinColumns = @JoinColumn(name = "fk_category_id",referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name = "fk_product_id",referencedColumnName = "id")
    )
    private List<Product> products;

}

