package com.newhorizons.takeitnow.orders.presentation.web.controller;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDetailDto;
import com.newhorizons.takeitnow.orders.application.mainmodule.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService itemService;

    @GetMapping("/getAll")
    public List<OrderDetailDto> getAll(){
        return itemService.getAll();
    }

    @GetMapping("/getOrderDetail/{productId}/{orderId}/{quantity}")
    public OrderDetailDto getItem(@PathVariable("productId") long productId,@PathVariable("orderId") long orderId, @PathVariable("quantity") long quantity){
        return itemService.getItem(productId,orderId, quantity);
    }
}
