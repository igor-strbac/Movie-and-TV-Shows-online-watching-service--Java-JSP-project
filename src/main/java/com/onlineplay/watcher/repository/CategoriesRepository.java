/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlineplay.watcher.entity.Categories;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Anđelka
 */
@Repository("categoriesRepository")
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

//    @Query(value = "select * from categories where id_category=?", nativeQuery = true)
//    List<Categories> findAllCat();
    
    
    
}
