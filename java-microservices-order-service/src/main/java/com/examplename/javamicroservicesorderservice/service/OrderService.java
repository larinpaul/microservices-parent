package com.examplename.javamicroservicesorderservice.service;

import com.examplename.javamicroservicesorderservice.dto.OrderLineItemsDto;
import com.examplename.javamicroservicesorderservice.dto.OrderRequest;
import com.examplename.javamicroservicesorderservice.model.Order;
import com.examplename.javamicroservicesorderservice.model.OrderLineItems;
import com.examplename.javamicroservicesorderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }

}
