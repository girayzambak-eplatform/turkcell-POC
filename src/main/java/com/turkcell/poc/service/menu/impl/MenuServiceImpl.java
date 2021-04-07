package com.turkcell.poc.service.menu.impl;

import com.turkcell.poc.collection.MenuCollection;
import com.turkcell.poc.repository.MenuRepository;
import com.turkcell.poc.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository repository;


    /**
     * Veritabanından tüm menu kayıtlarını çeken servistir.
     *
     * @return List<String>
     */
    @Override
    @Transactional(readOnly = true)
    public List<String> getMenuList() {
        List<MenuCollection> list = repository.findAll();
        return list.stream().map(MenuCollection::getTitle).collect(Collectors.toList());
    }
}
