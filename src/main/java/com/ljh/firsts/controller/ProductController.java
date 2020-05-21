package com.ljh.firsts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ljh.firsts.model.Product;
import com.ljh.firsts.service.ProductService;

	@RestController
	@RequestMapping(value = "/product")
	public class ProductController {

	    @Autowired
	    ProductService productService;

	    @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public List<Product> list() {
	        return productService.listShowProduct();
	    }

	    @RequestMapping(value = "/queryItem", method = RequestMethod.GET)
	    public Product query(Integer productId) {
	        return productService.findByProductId(productId);
	    }

	}

