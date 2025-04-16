package br.com.cayena.order.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cayena.order.dto.CreateOrderRequestDTO;
import br.com.cayena.order.dto.OrderResponseDTO;
import br.com.cayena.order.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody CreateOrderRequestDTO dto) {
        OrderResponseDTO order = orderService.createOrder(dto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable UUID id) {
        OrderResponseDTO order = orderService.getOrderById(id);
        return order != null ? new ResponseEntity<>(order, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
