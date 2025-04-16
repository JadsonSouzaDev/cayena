package br.com.cayena.order.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderRequestDTO {
    private String customerName;
    private List<String> productIds;
    private BigDecimal totalAmount;
}
