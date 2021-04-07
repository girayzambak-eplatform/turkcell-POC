package com.turkcell.poc.dto;

import com.turkcell.poc.base.BaseDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductDto extends BaseDto {
    private String gsmNumarasi;
    private String kullaniciAdi;
    private String hatTipi;
    private String hatDurumu;
    private String odemeTipi;
    private Integer kasaNumara;
}
