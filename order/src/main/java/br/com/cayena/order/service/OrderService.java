package br.com.cayena.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.cayena.order.dto.CreateOrderRequestDTO;
import br.com.cayena.order.dto.OrderResponseDTO;
import br.com.cayena.order.entity.Order;
import br.com.cayena.order.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponseDTO createOrder(CreateOrderRequestDTO dto) {
        Order order = Order.builder()
            .customerName(dto.getCustomerName())
            .productIds(dto.getProductIds())
            .totalAmount(dto.getTotalAmount())
            .createdAt(LocalDateTime.now())
            .build();
        Order savedOrder = orderRepository.save(order);
        return toDto(savedOrder);
    }

    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll().stream()
            .map(this::toDto)
            .toList();
    }

    public OrderResponseDTO getOrderById(UUID id) {
        return orderRepository.findById(id)
            .map(this::toDto)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    private OrderResponseDTO toDto(Order order) {
        return OrderResponseDTO.builder()
            .id(order.getId())
            .customerName(order.getCustomerName())
            .productIds(order.getProductIds())
            .totalAmount(order.getTotalAmount())
            .status(order.getStatus())
            .createdAt(order.getCreatedAt())
            .build();
    }
}
