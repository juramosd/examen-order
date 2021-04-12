package com.newhorizons.takeitnow.orders.domain.service;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDetailDto;
import com.newhorizons.takeitnow.orders.application.mainmodule.service.IOrderDetailService;
import com.newhorizons.takeitnow.orders.domain.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    @Qualifier("repositoryFeign")
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailDto> getAll() {
        return orderDetailRepository.getAll();
    }

    @Override
    public OrderDetailDto getItem(long productId, long orderId, long quantity) {
        return orderDetailRepository.getOrderDetail(productId,orderId,quantity);
    }
}
