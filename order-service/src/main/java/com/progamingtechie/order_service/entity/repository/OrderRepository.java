package com.progamingtechie.order_service.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progamingtechie.order_service.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
