package com.newhorizons.takeitnow.orders.application.mainmodule.service;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDetailDto;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetailDto> getAll();
    OrderDetailDto getItem(long productId,long orderId,  long quantity);
}
