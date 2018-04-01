package com.xxxx.repo;

import com.xxxx.mybatis.domain.Product;

public interface IProductService {
    Product getById(int id);

    void insertProduct(Product product);

    void deleteProduct(int productid);
}
