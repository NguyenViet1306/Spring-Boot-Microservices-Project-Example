package com.progamingtechie.order_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progamingtechie.order_service.dto.OrderLineItemsDto;
import com.progamingtechie.order_service.dto.OrderRequest;
import com.progamingtechie.order_service.entity.Order;
import com.progamingtechie.order_service.entity.OrderLineItems;
import com.progamingtechie.order_service.entity.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItems = orderRequest.getOrderlineItemsDtoList().stream().map(this::mapToDto).toList();
		order.setOrderlineIstemList(orderLineItems);
		orderRepository.save(order);
	}

	private OrderLineItems mapToDto(OrderLineItemsDto dto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(dto.getPrice());
		orderLineItems.setQuantity(dto.getQuantity());
		orderLineItems.setSkuCode(dto.getSkuCode());
		return orderLineItems;
	}
}
