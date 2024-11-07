package com.example.Microservice.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Food")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID productId;

    @Column(name = "productName")
    String productName;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "image")
    String image;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Feedback> feedbacks;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;

    @OneToOne(mappedBy = "food")  // Correct mappedBy
    OrderItem orderItem;
}
