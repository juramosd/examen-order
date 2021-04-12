package com.newhorizons.takeitnow.orders.domain.repository;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDetailDto;

import java.util.List;

public interface IOrderDetailRepository {
    List<OrderDetailDto> getAll();
    OrderDetailDto getOrderDetail(long productId, long orderId, long quantity);
}
