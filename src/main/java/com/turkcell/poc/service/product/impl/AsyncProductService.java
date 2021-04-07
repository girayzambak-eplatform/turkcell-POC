package com.turkcell.poc.service.product.impl;

import com.turkcell.poc.collection.ProductCollection;
import com.turkcell.poc.repository.ProductRepository;
import com.turkcell.poc.utils.ProductsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsyncProductService {
    @Autowired
    private ProductRepository repository;

    /**
     * Async olarak gelen collection'u kasa numarasına random yeni kasa numarası atar.
     *
     * @param collection
     */
    @Transactional
    @Async("taskExecutor")
    public void updateProductKasaNo(ProductCollection collection){
        collection.setKasaNumara(ProductsUtil.generateRandomKasaNo());
        repository.save(collection);
    }
}
