package com.example.test.controller;

import com.example.test.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class IndexController {

    final static Logger logger = LoggerFactory.getLogger(IndexController.class);
    final private ProductService productService;

    @Autowired
    public IndexController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(value = "/")
    public Object index() throws UnknownHostException {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostname = localHost.getHostName();
            return hostname + " \r\n Hello World!";
        } catch (Exception $e) {
            return "hostname is empty \r\n Hello World!";
        }
    }

    @GetMapping(value = "/index/{name}")
    public Object varIndex(@PathVariable String name) {
        return name + " Hello World!";
    }

    @GetMapping(value = "/index/query")
    public Object urlCode(String name) {
        return name + " Hello World!";
    }

    @PostMapping(value = "/index/bodyformdata")
    public Object body(String name) {
        return name + " Hello World!";
    }

}
