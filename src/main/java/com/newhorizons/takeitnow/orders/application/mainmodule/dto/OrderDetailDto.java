package com.newhorizons.takeitnow.orders.application.mainmodule.dto;

import com.newhorizons.takeitnow.orders.domain.entity.Order;
import com.newhorizons.takeitnow.orders.domain.entity.Product;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Date;

public class OrderDetailDto {
    private Long idOrderDetail;

    private OrderDto order;

    private Long quantity;

    private LocalDateTime dateRegister;

    private ProductDto product;

    public OrderDetailDto() {
    }

    public OrderDetailDto(ProductDto product,OrderDto order, Long quantity) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
        this.dateRegister = LocalDateTime.now();
    }

    public Long getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(Long idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDateTime dateRegister) {
        this.dateRegister = dateRegister;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Double getTotal(){
        return product.getPrice() * quantity;
    }
}
