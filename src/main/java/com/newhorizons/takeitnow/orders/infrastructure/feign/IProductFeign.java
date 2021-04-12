package com.newhorizons.takeitnow.orders.infrastructure.feign;

import com.newhorizons.takeitnow.orders.domain.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "product-service")
@RequestMapping("/products")
public interface IProductFeign {
    @GetMapping("/getAll")
    List<Product> getAll();
    @GetMapping("/getProduct/{productId}")
    Product getProduct(@PathVariable("productId") long productId);
}
