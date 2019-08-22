package com.jssm.kardex.service;

import com.jssm.kardex.exception.CreateException;
import com.jssm.kardex.exception.ProductNotFoundException;
import com.jssm.kardex.exception.DeleteException;
import com.jssm.kardex.exception.UpdateException;
import com.jssm.kardex.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface KardexService {
    ResponseEntity<Product> createProduct(Product product) throws CreateException;
    ResponseEntity deleteProduct(Long id) throws DeleteException;
    ResponseEntity<Product> updateProduct(Product product) throws UpdateException;
    ResponseEntity<List<Product>> findAll();
    ResponseEntity<Product> findProductById(Long id) throws ProductNotFoundException;
}
