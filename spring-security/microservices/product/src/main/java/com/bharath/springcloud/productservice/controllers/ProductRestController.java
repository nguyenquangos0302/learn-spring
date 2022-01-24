package com.bharath.springcloud.productservice.controllers;

import com.bharath.springcloud.productservice.dto.Coupon;
import com.bharath.springcloud.productservice.model.Product;
import com.bharath.springcloud.productservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${couponService.url}")
    private String couponServiceURL;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        ResponseEntity<Coupon> forEntity = restTemplate.getForEntity(couponServiceURL + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(forEntity.getBody().getDiscount()));
        return productRepo.save(product);
    }

    public Product sendErrorResponde(Product product) {
        return product;
    }

}
