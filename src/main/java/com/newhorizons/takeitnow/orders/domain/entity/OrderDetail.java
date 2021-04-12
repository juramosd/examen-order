package com.newhorizons.takeitnow.orders.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

public class OrderDetail {

    private Long idOrderDetail;

    private Order order;

    private Long quantity;

    private LocalDateTime dateRegister;

    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(Product product, Order order, Long quantity) {
        this.order  = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(Long idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
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



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getTotal(){
        return product.getPrice() * quantity.doubleValue();
    }
}
