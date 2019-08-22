package com.jssm.kardex.controller;

import com.jssm.kardex.exception.CreateException;
import com.jssm.kardex.exception.ProductNotFoundException;
import com.jssm.kardex.exception.DeleteException;
import com.jssm.kardex.exception.UpdateException;
import com.jssm.kardex.model.Product;
import com.jssm.kardex.service.KardexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class KardexController {

    @Autowired
    private KardexServiceImpl kardexService;

    @RequestMapping(value="/create", method=RequestMethod.POST)
    ResponseEntity<Product> createProduct(@RequestBody Product product) throws CreateException {
        return kardexService.createProduct(product);
    }

    @RequestMapping("/read/{id}")
    ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return kardexService.findProductById(id);
    }

    @RequestMapping("/read")
    ResponseEntity<List<Product>> getProducts() {
        return kardexService.findAll();
    }

    @RequestMapping(value="/delete/{id}")
    ResponseEntity deleteProduct(@PathVariable("id") Long id) throws DeleteException {
        return kardexService.deleteProduct(id);
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    ResponseEntity<Product> updateProduct(@RequestBody Product product) throws UpdateException {
        return kardexService.updateProduct(product);
    }

}
