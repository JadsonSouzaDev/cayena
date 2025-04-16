package br.com.cayena.order.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.cayena.order.entity.OrderStatus;

@Data
@Builder
public class OrderResponseDTO {
    private UUID id;
    private String customerName;
    private List<String> productIds;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private LocalDateTime createdAt;
}
