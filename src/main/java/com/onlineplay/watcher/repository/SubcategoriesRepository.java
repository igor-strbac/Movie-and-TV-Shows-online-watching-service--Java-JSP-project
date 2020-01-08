/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.repository;

import com.onlineplay.watcher.entity.Subcategories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anđelka
 */
@Repository("subcategoriesRepository")
public interface SubcategoriesRepository extends JpaRepository<Subcategories, Long> {

//    @Query(value = "select * from subcategories sub inner join categories c on(sub.id_category = c.id_category) where c.id_subcategory=:id_subcategory", nativeQuery = true)
//    List<Subcategories> findById(int id_subcategory);

//    @Query(value = "select * from subcategories sub where categories_id_category=:categories_id_category", nativeQuery = true)
//    List<Subcategories> findSubcategoriesByCategory();
    
    //"select * from subcategories sub inner join categories c on(sub.id_category = c.id_category) where sub.id_category=1"
}
