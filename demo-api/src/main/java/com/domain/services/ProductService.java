package com.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.models.entities.Product;
import com.domain.models.repost.ProductRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepos productRepos;

    public Product save(Product product){
        return productRepos.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> product = productRepos.findById(id);
        if(!product.isPresent()){
            return  null;
        }
        return product.get();
    }

    public Iterable<Product> findAll(){
        return productRepos.findAll();
    }

    public void removeOne(Long id){
        productRepos.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepos.findByNameContains(name);
    }
}
