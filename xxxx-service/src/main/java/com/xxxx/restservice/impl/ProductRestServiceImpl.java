package com.xxxx.restservice.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.xxxx.mybatis.domain.Product;
import com.xxxx.repo.IProductService;
import com.xxxx.restservice.IProductRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
@Service("productRestService")
public class ProductRestServiceImpl implements IProductRestService{

    @Autowired
    IProductService productService;

    @Path("/getprduct/{productId}")
    @GET
    @Override
    public Product getById(@PathVariable("productId") int productId) {
        return productService.getById(productId);
    }

    @Path("/insertproduct")
    @POST
    @Override
    public void insertProduct(@RequestBody Product product) {
        productService.insertProduct(product);
    }

    @Path("/deleteproduct/{productId}")
    @DELETE
    @Override
    public void deleteProduct(@PathVariable("productId")int productId) {
        productService.deleteProduct(productId);
    }
}
