package com.jssm.kardex.service;

import com.jssm.kardex.exception.CreateException;
import com.jssm.kardex.exception.ProductNotFoundException;
import com.jssm.kardex.repository.KardexRepository;
import com.jssm.kardex.exception.DeleteException;
import com.jssm.kardex.exception.UpdateException;
import com.jssm.kardex.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KardexServiceImpl implements KardexService {

    @Autowired
    private KardexRepository kardexRepository;

    @Override
    public ResponseEntity<Product> createProduct(Product product) throws CreateException {
        try {
            return new ResponseEntity<>(kardexRepository.save(product), HttpStatus.OK);
        } catch (Exception ex){
            throw new CreateException();
        }
    }

    @Override
    public ResponseEntity deleteProduct(Long id) throws DeleteException {
        try {
            kardexRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            throw new DeleteException();
        }
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product product) throws UpdateException {
        List<Product> products = kardexRepository.findAll();
        for(Product auxProduct : products){
            if(product.getId().equals(auxProduct.getId())){
                return new ResponseEntity<>(kardexRepository.save(product), HttpStatus.OK);
            }
        }
        throw new UpdateException();
    }

    @Override
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(kardexRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> findProductById(Long id) throws ProductNotFoundException {
        try {
            return new ResponseEntity<>(kardexRepository.findById(id).get(), HttpStatus.OK);
        } catch (Exception ex){
            throw new ProductNotFoundException();
        }
    }
}
