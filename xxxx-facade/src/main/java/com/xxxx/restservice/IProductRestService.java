package com.xxxx.restservice;

import com.xxxx.mybatis.domain.Product;

public interface IProductRestService {
    Product getById(int id);

    void insertProduct(Product product);

    void deleteProduct(int productid);
}
