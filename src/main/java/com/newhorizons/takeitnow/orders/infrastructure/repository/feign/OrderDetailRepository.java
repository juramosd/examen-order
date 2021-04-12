package com.newhorizons.takeitnow.orders.infrastructure.repository.feign;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDetailDto;
import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDto;
import com.newhorizons.takeitnow.orders.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.orders.application.mainmodule.mapper.IOrderMapper;
import com.newhorizons.takeitnow.orders.application.mainmodule.mapper.IProductMapper;
import com.newhorizons.takeitnow.orders.domain.entity.Order;
import com.newhorizons.takeitnow.orders.domain.entity.Product;
import com.newhorizons.takeitnow.orders.domain.repository.IOrderDetailRepository;
import com.newhorizons.takeitnow.orders.domain.repository.IOrderRepository;
import com.newhorizons.takeitnow.orders.infrastructure.crud.IOrderCrudRepository;
import com.newhorizons.takeitnow.orders.infrastructure.feign.IProductFeign;
import com.newhorizons.takeitnow.orders.infrastructure.repository.rest.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("repositoryFeign")
public class OrderDetailRepository implements IOrderDetailRepository {

    @Autowired
    private IProductFeign productFeign;

    @Autowired
    private IOrderCrudRepository orderCrudRepository;

    @Autowired
    private IProductMapper productMapper;

    @Autowired
    private IOrderMapper orderMapper;

    @Override
    public List<OrderDetailDto> getAll() {
        List<Product> products = productFeign.getAll();
        List<Order> orders = (List<Order>) orderCrudRepository.findAll();
        List<ProductDto> productsDto = productMapper.toProductsDto(products);
        List<OrderDto> ordersDto = orderMapper.toProductsDto(orders);
        List<OrderDetailDto> list = new ArrayList<>();

        if(ordersDto.size() >0){
            for (OrderDto order:ordersDto) {

                for (ProductDto prod:productsDto) {
                    list.add(new OrderDetailDto(prod,order,1L));

                }
            }
        }

        return list;
    }

    @Override
    public OrderDetailDto getOrderDetail(long productId, long orderId, long quantity) {
        Product product = productFeign.getProduct(productId);
        ProductDto productDto = productMapper.toProductDto(product);
        Optional<Order> order = orderCrudRepository.findById(orderId);
        OrderDto orderDto = orderMapper.toOrderDto(order.get());
        return new OrderDetailDto(productDto, orderDto, quantity);
    }
}
