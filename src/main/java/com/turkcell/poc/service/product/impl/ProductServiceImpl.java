package com.turkcell.poc.service.product.impl;

import com.turkcell.poc.dto.ProductDto;
import com.turkcell.poc.collection.ProductCollection;
import com.turkcell.poc.repository.ProductRepository;
import com.turkcell.poc.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private AsyncProductService service;

    /**
     * Veritabanından tüm product kayıtlarını çeken servistir.
     *
     * @return List<ProductDto>
     */
    @Override
    @Transactional
    public List<ProductDto> getProductList() {
        List<ProductCollection> list = repository.findAll().stream().limit(10).collect(Collectors.toList());
        return list.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    /**
     * Gelen telefon listesine göre veritabanından kayıtları bulup, ilgili kayıtların Kasanumarası alanlarını random kasanumarası ile günceller.
     *
     * @param phoneNumberList
     */
    @Override
    @Transactional
    public void updateProductInfo(List<String> phoneNumberList) {
        List<ProductCollection> result = repository.findByGsmNumarasiIn(phoneNumberList);
        for(ProductCollection collection : result){
            service.updateProductKasaNo(collection);
        }
    }

    /**
     * ProductCollection'u ProductDto'ya convert eder
     *
     * @param collection
     * @return ProductDto
     */
    private ProductDto convertEntityToDto(ProductCollection collection){
        ProductDto dto = new ProductDto();
        return dto.setGsmNumarasi(collection.getGsmNumarasi())
                .setHatDurumu(collection.getHatDurumu().name())
                .setHatTipi(collection.getHatTipi().name())
                .setOdemeTipi(collection.getOdemeTipi().name())
                .setKasaNumara(collection.getKasaNumara())
                .setKullaniciAdi(collection.getKullaniciAdi());
    }


}
