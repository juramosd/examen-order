package com.newhorizons.takeitnow.orders.domain.repository;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository {
    List<OrderDto> getAll();
    Optional<OrderDto> getOrder(Long orderId);
    Optional<OrderDto> save(OrderDto orderDto);
    Optional<OrderDto> modify(OrderDto orderDto);
    void delete(OrderDto orderDto);
}
