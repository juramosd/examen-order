package com.newhorizons.takeitnow.orders.presentation.web.controller;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDto;
import com.newhorizons.takeitnow.orders.application.mainmodule.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private Environment environment;

    @Autowired
    private IOrderService orderService;

    @GetMapping("/getAll")
    public List<OrderDto> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/getOrder/{productId}")
    public OrderDto getProduct(@PathVariable("orderId") long orderId){
        OrderDto orderDto = orderService.getOrder(orderId).get();
        return orderDto;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public OrderDto registrar(@RequestBody OrderDto cargo) {
        cargo = orderService.save(cargo).get();
        return cargo;
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public OrderDto modificar(@RequestBody OrderDto cargo) {
        cargo =  orderService.modify(cargo).get();
        return cargo;
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        OrderDto clas = orderService.getOrder(id).get();
        if(clas==null) {

        }else {
            orderService.delete(clas);
        }
    }
}
