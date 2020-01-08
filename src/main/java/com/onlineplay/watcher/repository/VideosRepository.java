/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.repository;

/**
 *
 * @author Anđelka
 */
import com.onlineplay.watcher.entity.Categories;
import com.onlineplay.watcher.entity.Subcategories;
import com.onlineplay.watcher.entity.Videos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("VideosRepository")
public interface VideosRepository extends JpaRepository<Videos, Long> {

//    @Query(value = "select * from subcategories sub inner join categories c on(sub.id_category = c.id_category) where c.id_category=?1", nativeQuery = true)
//    List<Videos> findById(int id_subcategory);
//    @Query(value = "select * from category c where c.id_category=?1", nativeQuery = true)
//    List<Videos> findByIdCat(int id_category);
//    @Query(value = "select * from category c where c.id_category=?1", nativeQuery = true)
//    List<Videos> findSubcategoriesByCategory(int id_category);
//    @Query(value = "SELECT * FROM videos v WHERE v.categories_id_category = :categories_id_category)and v.subcategories_id_subcategory in :subcategories_id_subcategory)", nativeQuery = true)
//    List<Videos> findSubcategoriesByCategory(int videos);
}
