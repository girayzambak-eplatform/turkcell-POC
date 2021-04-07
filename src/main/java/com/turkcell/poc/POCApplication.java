package com.turkcell.poc;

import com.turkcell.poc.collection.MenuCollection;
import com.turkcell.poc.collection.ProductCollection;
import com.turkcell.poc.enums.HatDurumuEnum;
import com.turkcell.poc.enums.HatTipiEnum;
import com.turkcell.poc.enums.OdemeTipiEnum;
import com.turkcell.poc.repository.MenuRepository;
import com.turkcell.poc.repository.ProductRepository;
import com.turkcell.poc.utils.ProductsUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class POCApplication {
    private static final String[] MENU_LIST = {"Fatura İşlemleri", "Tarife İşlemleri", "Paket İşlemleri", "Hat İşlemleri", "Ayarlar", "Ürün ve Servisler", "Faturasız Hat İşlemleri", "Yetkili ve Kullanıcı İşlemleri", "Raporlama Merkezi", "İştecep Kampanyası"};

    public static void main(String[] args) {
        SpringApplication.run(POCApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MenuRepository menuRepository, ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                menuRepository.deleteAll();
                productRepository.deleteAll();

                List<MenuCollection> menuCollectionList = new ArrayList<>();
                for (String menuTitle : MENU_LIST) {
                    menuCollectionList.add(new MenuCollection().setTitle(menuTitle));
                }

                List<ProductCollection> productCollectionList = new ArrayList<>();
                for(int i=0; i<1000; i++){
                    productCollectionList.add(new ProductCollection().setGsmNumarasi(ProductsUtil.generateGsmNumber(i))
                    .setHatDurumu(HatDurumuEnum.HAT_DURUMU)
                    .setHatTipi(HatTipiEnum.HAT_TIPI)
                    .setOdemeTipi(OdemeTipiEnum.ODEME_TIPI)
                    .setKasaNumara(ProductsUtil.generateRandomKasaNo())
                    .setKullaniciAdi(ProductsUtil.generateRandomName()));
                }

                menuRepository.saveAll(menuCollectionList);
                productRepository.saveAll(productCollectionList);

            }
        };
    }
}
