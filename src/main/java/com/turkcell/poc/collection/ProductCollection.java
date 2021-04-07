package com.turkcell.poc.collection;

import com.turkcell.poc.base.BaseCollection;
import com.turkcell.poc.enums.HatDurumuEnum;
import com.turkcell.poc.enums.HatTipiEnum;
import com.turkcell.poc.enums.OdemeTipiEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "product")
@Data
@Accessors(chain = true)
public class ProductCollection extends BaseCollection {

    @Field("gsm_numarasi")
    private String gsmNumarasi;

    @Field("kullanici_adi")
    private String kullaniciAdi;

    @Field("hat_tipi")
    private HatTipiEnum hatTipi;

    @Field("hat_durumu")
    private HatDurumuEnum hatDurumu;

    @Field("odeme_tipi")
    private OdemeTipiEnum odemeTipi;

    @Field("kasa_numara")
    private Integer kasaNumara;
}
