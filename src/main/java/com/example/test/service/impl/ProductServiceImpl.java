package com.example.test.service.impl;

import com.example.test.mapper.ProductMapper;
import com.example.test.model.Product;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product find(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override

    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int balance(int rid, int aid) {
        Product rProduct = productMapper.selectByPrimaryKey(rid);
        Product aProduct = productMapper.selectByPrimaryKey(aid);

        if (rProduct.getPrice() > 0) {
            Integer price = rProduct.getPrice();
            rProduct.setPrice(price - 1);
            productMapper.updateByPrimaryKeySelective(rProduct);
//            int i = 1/0;
            aProduct.setPrice(aProduct.getPrice() + 1);
            productMapper.updateByPrimaryKeySelective(aProduct);


            return 1;
        }

        return 0;
    }

}