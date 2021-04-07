package com.turkcell.poc.controller;

import com.turkcell.poc.dto.ProductDto;
import com.turkcell.poc.enums.RequestTypeEnum;
import com.turkcell.poc.log.LoggerMongo;
import com.turkcell.poc.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @LoggerMongo(requestType = RequestTypeEnum.LIST)
    @RequestMapping(path = "getProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody ResponseEntity<List<ProductDto>> getProductList() {
        List<ProductDto> response = service.getProductList();
        return ResponseEntity.ok().body(response);
    }

    @LoggerMongo(requestType = RequestTypeEnum.UPDATE)
    @RequestMapping(path = "updateProductInfo", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity updateProductInfo(@RequestBody List<String> phoneNumberList) {
        service.updateProductInfo(phoneNumberList);
        return ResponseEntity.ok().body("Success");
    }
}
