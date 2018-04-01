package com.xxxx.restservice;

import com.xxxx.mybatis.domain.Product;

public interface IProductRestService {
    Product getById(int id);

    Product insertProduct(Product product);

    void deleteProduct(int productid);
}
