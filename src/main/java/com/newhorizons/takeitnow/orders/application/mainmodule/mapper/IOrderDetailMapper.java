package com.newhorizons.takeitnow.orders.application.mainmodule.mapper;

import com.newhorizons.takeitnow.orders.application.mainmodule.dto.OrderDetailDto;
import com.newhorizons.takeitnow.orders.domain.entity.OrderDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderDetailMapper {
    OrderDetailDto toItemDto(OrderDetail item);

    List<OrderDetailDto> toItemsDto(List<OrderDetail> items);

    @InheritInverseConfiguration
    OrderDetail toItem(OrderDetailDto itemDto);
}
