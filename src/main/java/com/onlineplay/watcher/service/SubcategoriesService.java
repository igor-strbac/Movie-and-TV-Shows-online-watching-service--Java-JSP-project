/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.service;

import com.onlineplay.watcher.entity.Categories;
import com.onlineplay.watcher.entity.Subcategories;
import com.onlineplay.watcher.repository.SubcategoriesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Anđelka
 */
@Service("subcategoriesService")
@Transactional
public class SubcategoriesService {

    private SubcategoriesRepository subcategoriesRepository;

    @Autowired
    public SubcategoriesService(SubcategoriesRepository subcategoriesRepository) {
        this.subcategoriesRepository = subcategoriesRepository;
    }

    public List<Subcategories> findAll() {
        return subcategoriesRepository.findAll();
    }

    public void save(Subcategories subcategories) {
        subcategoriesRepository.save(subcategories);
    }

    public Subcategories get(long id_subcategory) {
        return subcategoriesRepository.findById(id_subcategory).get();
    }

    public void delete(long id_subcategory) {
        subcategoriesRepository.deleteById(id_subcategory);
    }

//    public List<Subcategories> findSubcategoriesByCategory() {
//        return subcategoriesRepository.findSubcategoriesByCategory();
//    }
}
