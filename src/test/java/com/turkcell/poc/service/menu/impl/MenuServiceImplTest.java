package com.turkcell.poc.service.menu.impl;

import com.turkcell.poc.collection.MenuCollection;
import com.turkcell.poc.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        list.add(new MenuCollection()
                //.setId("1")
                .setTitle("Fatura İşlemleri"));
        list.add(new MenuCollection()
                //.setId("2")
                .setTitle("Tarife İşlemleri"));
        list.add(new MenuCollection()
                //.setId("3")
                .setTitle("Paket İşlemleri"));

        when(menuRepository.findAll()).thenReturn(list);
    }

    @Test
    public void getMenuList(){
        List<String> result = menuService.getMenuList();
        assertEquals(result.size(), 3);
    }
}
