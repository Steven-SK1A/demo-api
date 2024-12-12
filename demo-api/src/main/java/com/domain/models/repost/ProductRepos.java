package com.domain.models.repost;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.domain.models.entities.Product;

public interface ProductRepos extends CrudRepository<Product, Long>{
    
    List<Product> findByNameContains(String name);
}
