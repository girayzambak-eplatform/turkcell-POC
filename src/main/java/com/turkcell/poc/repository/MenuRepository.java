package com.turkcell.poc.repository;

import com.turkcell.poc.collection.MenuCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<MenuCollection, String> {

}
