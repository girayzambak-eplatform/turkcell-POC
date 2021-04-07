package com.turkcell.poc.service.menu.impl;

import com.turkcell.poc.collection.MenuCollection;
import com.turkcell.poc.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MenuServiceImplTest extends AbstractTestExecutionListener {
    @InjectMocks
    MenuServiceImpl menuService;

    @Mock
    MenuRepository menuRepository;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        setMenuRepositoryFindAllResult();
    }

    private void setMenuRepositoryFindAllResult(){
        List<MenuCollection> list = new ArrayList<>();
        list.add(new MenuCollection().setId("1").setTitle("Fatura İşlemleri"));
        list.add(new MenuCollection().setId("2").setTitle("Tarife İşlemleri"));
        list.add(new MenuCollection().setId("3").setTitle("Paket İşlemleri"));

        when(menuRepository.findAll()).thenReturn(list);
    }

    @Test
    @DisplayName("is blank getMenuList")
    public void test_blank_getMenuList(){
        List<String> result = menuService.getMenuList();
        assertNotNull(result);
    }

    @ParameterizedTest
    @DisplayName("is size true getMenuList")
    @ValueSource(ints = 3)
    public void test_size_getMenuList(int count){
        List<String> result = menuService.getMenuList();
        assertEquals(result.size(), count);
    }

    @DisplayName("has title getMenuList")
    @ParameterizedTest
    @ValueSource(strings = {"Fatura İşlemleri", "Tarife İşlemleri", "Paket İşlemleri" })
    public void test_has_title_getMenuList(String title){
        List<String> result = menuService.getMenuList();
        assertTrue(result.contains(title));
    }
}
