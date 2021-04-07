package com.turkcell.poc.service.product.impl;

import com.turkcell.poc.collection.ProductCollection;
import com.turkcell.poc.dto.ProductDto;
import com.turkcell.poc.enums.HatDurumuEnum;
import com.turkcell.poc.enums.HatTipiEnum;
import com.turkcell.poc.enums.OdemeTipiEnum;
import com.turkcell.poc.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl service;

    @Mock
    ProductRepository repository;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        setProductRepositoryList();
    }

    private void setProductRepositoryList(){
        List<ProductCollection> list = new ArrayList<>();

        list.add(new ProductCollection()//.setId("1")
                .setKasaNumara(1111)
                .setGsmNumarasi("5330000000")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU)
                .setHatTipi(HatTipiEnum.HAT_TIPI)
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI)
                .setKullaniciAdi("Ad 1 Sad 1"));

        list.add(new ProductCollection()//.setId("2")
                .setKasaNumara(1112)
                .setGsmNumarasi("5330000001")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU)
                .setHatTipi(HatTipiEnum.HAT_TIPI)
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI)
                .setKullaniciAdi("Ad 2 Sad 2"));

        list.add(new ProductCollection()//.setId("3")
                .setKasaNumara(1113)
                .setGsmNumarasi("5330000002")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU)
                .setHatTipi(HatTipiEnum.HAT_TIPI)
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI)
                .setKullaniciAdi("Ad 3 Sad 3"));

        when(repository.findAll()).thenReturn(list);
    }

    @Test
    void test_null_getProductList(){
        List<ProductDto> list = service.getProductList();
        assertNotNull(list);
    }

    @Test
    void test_size_getProductList(){
        List<ProductDto> list = service.getProductList();
        assertEquals(list.size(), 3);
    }
}
