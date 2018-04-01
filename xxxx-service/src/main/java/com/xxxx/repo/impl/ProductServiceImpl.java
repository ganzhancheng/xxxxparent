package com.xxxx.repo.impl;

import com.xxxx.mybatis.IDao.ProductMapper;
import com.xxxx.mybatis.domain.Product;
import com.xxxx.repo.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("productService")
public class ProductServiceImpl implements IProductService{

    @Resource
    ProductMapper productMapper;

    @Override
    public Product getById(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void deleteProduct(int productid) {
        productMapper.deleteByPrimaryKey(productid);
    }
}
