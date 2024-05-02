package dev.vishnu.productservice.controllers;

import models.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import services.FakeStoreProduct;
import services.ProductService;

@RestController
public class ProductController {


    ProductService productService=new FakeStoreProduct();


//    @PostMapping("/products")
//    public void createProduct(){
//
//    }

//    @GetMapping("/products")
//    public void getAllProducts(){
//
//    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){

         return productService.getSingleProduct(id);
    }


//    public void deleteProductById(Long id){
//
//    }
}
