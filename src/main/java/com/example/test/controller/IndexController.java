package com.example.test.controller;

import com.example.test.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    final static Logger logger = LoggerFactory.getLogger(IndexController.class);
    final private ProductService productService;

    @Autowired
    public IndexController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(value = "/index")
    @ResponseBody
    public Object Index() {
        logger.debug("Hello world.");
        return "Hello World!";
    }

    @GetMapping(value = "/admin/index")
    @ResponseBody
    public Object admin() {
        return "admin Hello World!";
    }


}
