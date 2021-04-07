package com.turkcell.poc.repository;

import com.turkcell.poc.collection.ProductCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductCollection, String> {
    List<ProductCollection> findByGsmNumarasiIn(List<String> gsmNumarasiList);
}
