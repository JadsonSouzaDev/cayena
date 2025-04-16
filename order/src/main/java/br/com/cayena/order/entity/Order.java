package br.com.cayena.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String customerName;

    @ElementCollection
    private List<String> productIds;

    private BigDecimal totalAmount;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    private LocalDateTime createdAt;
}
