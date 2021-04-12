package com.newhorizons.takeitnow.orders.infrastructure.repository.rest;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDto;
import com.newhorizons.takeitnow.orders.application.mainmodule.mapper.IOrderMapper;
import com.newhorizons.takeitnow.orders.domain.entity.Order;
import com.newhorizons.takeitnow.orders.domain.repository.IOrderRepository;
import com.newhorizons.takeitnow.orders.infrastructure.crud.IOrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements IOrderRepository {

    @Autowired
    private IOrderCrudRepository orderCrudRepository;

    @Autowired
    private IOrderMapper orderMapper;
    @Override
    public List<OrderDto> getAll() {
        List<Order> products = (List<Order>) orderCrudRepository.findAll();
        return orderMapper.toProductsDto(products);
    }

    @Override
    public Optional<OrderDto> getOrder(Long orderId) {
        return orderCrudRepository.findById(orderId).map(e -> orderMapper.toOrderDto(e));
    }

    @Override
    public Optional<OrderDto> save(OrderDto orderDto) {
        Order order = orderMapper.toProduct(orderDto);
        order.setDateRegister(LocalDateTime.now());
        order = orderCrudRepository.save(order);
        return Optional.ofNullable(orderMapper.toOrderDto(order));
    }

    @Override
    public Optional<OrderDto> modify(OrderDto orderDto) {
        Order order = orderMapper.toProduct(orderDto);
        order = orderCrudRepository.save(order);
        return Optional.ofNullable(orderMapper.toOrderDto(order));
    }

    @Override
    public void delete(OrderDto orderDto) {
        Order order = orderMapper.toProduct(orderDto);
        orderCrudRepository.delete(order);
    }
}
