package com.example.test.controller;

import com.example.test.model.Product;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    final private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/product/insert")
    public Object Insert(String name, Integer price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        try {
            return productService.insert(product);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @GetMapping(value = "/product/update/{id}/{name}")
    public Object Update(@PathVariable Integer id, @PathVariable String name) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        return productService.updateByPrimaryKey(product);
    }

    @GetMapping(value = "/product/{id}")
    public Object Product(@PathVariable Integer id) {
        return productService.selectByPrimaryKey(id);
    }

    //ab -n 100  -c 10 -p 'http://localhost:8081/api/product/balance/3/4'
    @GetMapping(value = "/product/balance/{rid}/{aid}")
    public Object Balance(@PathVariable Integer rid, @PathVariable Integer aid) {
        return productService.balance(rid, aid);
    }
}
