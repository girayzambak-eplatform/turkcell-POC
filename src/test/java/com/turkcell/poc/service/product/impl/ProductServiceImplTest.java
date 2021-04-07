package com.turkcell.poc.service.product.impl;

import com.turkcell.poc.collection.ProductCollection;
import com.turkcell.poc.dto.ProductDto;
import com.turkcell.poc.enums.HatDurumuEnum;
import com.turkcell.poc.enums.HatTipiEnum;
import com.turkcell.poc.enums.OdemeTipiEnum;
import com.turkcell.poc.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

        list.add(new ProductCollection()
                .setId("1")
                .setKasaNumara(1111)
                .setGsmNumarasi("5330000000")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU)
                .setHatTipi(HatTipiEnum.HAT_TIPI)
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI)
                .setKullaniciAdi("Ad 1 Sad 1"));

        list.add(new ProductCollection()
                .setId("2")
                .setKasaNumara(1112)
                .setGsmNumarasi("5330000001")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU)
                .setHatTipi(HatTipiEnum.HAT_TIPI)
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI)
                .setKullaniciAdi("Ad 2 Sad 2"));

        list.add(new ProductCollection()
                .setId("3")
                .setKasaNumara(1113)
                .setGsmNumarasi("5330000002")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU)
                .setHatTipi(HatTipiEnum.HAT_TIPI)
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI)
                .setKullaniciAdi("Ad 3 Sad 3"));

        when(repository.findAll()).thenReturn(list);
    }

    @Test
    @DisplayName("is blank getProductList")
    void test_blank_getProductList(){
        List<ProductDto> list = service.getProductList();
        assertNotNull(list);
    }

    @ParameterizedTest
    @DisplayName("is size true getProductList")
    @ValueSource(ints = 3)
    void test_size_getProductList(int count){
        List<ProductDto> list = service.getProductList();
        assertEquals(list.size(), count);
    }

    @DisplayName("has gsmNo getProductList")
    @ParameterizedTest
    @ValueSource(strings = {"5330000000", "5330000001", "5330000002"})
    public void test_has_gsmno_getMenuList(String gsmno){
        List<ProductDto> result = service.getProductList();
        assertTrue(result.stream().map(ProductDto::getGsmNumarasi).anyMatch(row -> row.equals(gsmno)));
    }

    @DisplayName("has kasaNo getProductList")
    @ParameterizedTest
    @ValueSource(ints = {1111, 1112, 1113})
    public void test_has_kasano_getMenuList(Integer kasaNo){
        List<ProductDto> result = service.getProductList();
        assertTrue(result.stream().map(ProductDto::getKasaNumara).anyMatch(row -> row.equals(kasaNo)));
    }
}
