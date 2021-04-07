package com.turkcell.poc.controller;

import com.turkcell.poc.enums.RequestTypeEnum;
import com.turkcell.poc.log.LoggerMongo;
import com.turkcell.poc.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService service;

    @LoggerMongo(requestType = RequestTypeEnum.LIST)
    @RequestMapping(value = "/getMenuList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity getMenuList() {
        List<String> response = service.getMenuList();
        return ResponseEntity.ok().body(response);
    }
}
