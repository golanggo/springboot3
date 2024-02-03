package com.example.test.service;

import com.example.test.model.Product;

public interface ProductService {

    Product find(int id);

    int insert(Product record);

    int updateByPrimaryKey(Product record);

    Product selectByPrimaryKey(Integer id);

    int balance(int rid, int aid);
}
