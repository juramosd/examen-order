package com.newhorizons.takeitnow.orders.application.mainmodule.mapper;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDto;
import com.newhorizons.takeitnow.orders.domain.entity.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderMapper {

    OrderDto toOrderDto(Order product);

    List<OrderDto> toProductsDto(List<Order> products);

    @InheritInverseConfiguration
    Order toProduct(OrderDto productDto);
}
