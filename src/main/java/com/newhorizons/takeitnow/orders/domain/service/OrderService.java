package com.newhorizons.takeitnow.orders.domain.service;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDto;
import com.newhorizons.takeitnow.orders.application.mainmodule.service.IOrderService;
import com.newhorizons.takeitnow.orders.domain.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Optional<OrderDto> getOrder(Long orderId) {
        return orderRepository.getOrder(orderId);
    }

    @Override
    public Optional<OrderDto> save(OrderDto orderDto) {
        return orderRepository.save(orderDto);
    }

    @Override
    public Optional<OrderDto> modify(OrderDto orderDto) {
        return orderRepository.modify(orderDto);
    }

    @Override
    public void delete(OrderDto orderDto) {
        orderRepository.delete(orderDto);
    }
}
