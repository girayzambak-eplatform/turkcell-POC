package com.turkcell.poc.controller;

import com.turkcell.poc.collection.MenuCollection;
import com.turkcell.poc.repository.MenuRepository;
import com.turkcell.poc.service.menu.impl.MenuServiceImpl;
import com.turkcell.poc.service.menu.impl.MenuServiceImplTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MenuControllerTest {
    @InjectMocks
    private MenuController menuController;

    @Mock
    private MenuServiceImpl service;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        setMenuServiceMenuListResult();
    }

    private void setMenuServiceMenuListResult(){
        List<String> list = new ArrayList<>();
        list.add("Fatura İşlemleri");
        list.add("Tarife İşlemleri");
        list.add("Paket İşlemleri");

        when(service.getMenuList()).thenReturn(list);
    }

    @Test
    void test_null_getMenuList() {
        ResponseEntity<List<String>> result = menuController.getMenuList();
        assertNotNull(result.getBody());
    }


    @Test
    void test_size_getMenuList() {
        ResponseEntity<List<String>> result = menuController.getMenuList();
        assertEquals(result.getBody().size(), 3);
    }

}
