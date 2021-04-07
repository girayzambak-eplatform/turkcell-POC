package com.turkcell.poc.controller;

import com.turkcell.poc.dto.ProductDto;
import com.turkcell.poc.enums.HatDurumuEnum;
import com.turkcell.poc.enums.HatTipiEnum;
import com.turkcell.poc.enums.OdemeTipiEnum;
import com.turkcell.poc.service.product.impl.ProductServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ProductControllerTest {
    @InjectMocks
    private ProductController controller;

    @Mock
    private ProductServiceImpl service;


    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        setProductServiceGetProductListResult();
    }

    private void setProductServiceGetProductListResult(){
        List<ProductDto> list = new ArrayList<>();

        list.add(new ProductDto()
                .setKasaNumara(1111)
                .setGsmNumarasi("5330000000")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU.toString())
                .setHatTipi(HatTipiEnum.HAT_TIPI.toString())
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI.toString())
                .setKullaniciAdi("Ad 1 Sad 1"));

        list.add(new ProductDto()
                .setKasaNumara(1112)
                .setGsmNumarasi("5330000001")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU.toString())
                .setHatTipi(HatTipiEnum.HAT_TIPI.toString())
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI.toString())
                .setKullaniciAdi("Ad 2 Sad 2"));

        list.add(new ProductDto()
                .setKasaNumara(1113)
                .setGsmNumarasi("5330000002")
                .setHatDurumu(HatDurumuEnum.HAT_DURUMU.toString())
                .setHatTipi(HatTipiEnum.HAT_TIPI.toString())
                .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI.toString())
                .setKullaniciAdi("Ad 3 Sad 3"));

        when(service.getProductList()).thenReturn(list);
    }

    @Test
    public void test_list_getProductList(){
        ResponseEntity<List<ProductDto>> list = controller.getProductList();
        assertNotNull(list.getBody());
    }

    @Test
    public void test_size_getProductList(){
        ResponseEntity<List<ProductDto>> list = controller.getProductList();
        assertEquals(list.getBody().size(), 3);
    }
}
