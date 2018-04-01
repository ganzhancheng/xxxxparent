package com.xxxx.restservice.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.xxxx.mybatis.domain.Product;
import com.xxxx.repo.IProductService;
import com.xxxx.restservice.IProductRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
@Service("productRestService")
public class ProductRestServiceImpl implements IProductRestService {

    @Autowired
    IProductService productService;

    @Path("/getproduct/{id}")
    @GET
    @Override
    public Product getById(@PathParam("id")  int productId) {
        Product byId = productService.getById(productId);
        return byId;
    }

    @Path("/insertproduct")
    @POST
    @Override
    public Product insertProduct(@RequestBody Product product) {
        productService.insertProduct(product);

        return new Product();
    }

    @Path("/deleteproduct/{productId}")
    @DELETE
    @Override
    public void deleteProduct(@PathParam("productId")int productId) {
        productService.deleteProduct(productId);
    }
}
