package br.com.cayena.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import br.com.cayena.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    
}
