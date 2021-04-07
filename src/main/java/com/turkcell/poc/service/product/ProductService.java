package com.turkcell.poc.service.product;

import com.turkcell.poc.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProductList();

    void updateProductInfo(List<String> phoneNumberList);
}
