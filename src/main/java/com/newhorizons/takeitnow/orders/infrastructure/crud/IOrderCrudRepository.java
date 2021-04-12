package com.newhorizons.takeitnow.orders.infrastructure.crud;

import com.newhorizons.takeitnow.orders.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface IOrderCrudRepository extends CrudRepository<Order,Long> {
}
