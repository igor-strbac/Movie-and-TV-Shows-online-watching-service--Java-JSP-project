package com.onlineplay.watcher.service;

import com.onlineplay.watcher.entity.Categories;
import com.onlineplay.watcher.repository.CategoriesRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Anđelka
 */
@Service
@Transactional
public class CategoriesService implements CommandLineRunner {

    private CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public void run(String... args) {
        //this.categoriesRepository.deleteAll();

        // Crete users
        Categories movies = new Categories(1, "Movies");
        Categories series = new Categories(2, "Series");
        Categories cartoons = new Categories(3, "Cartoons");

        List<Categories> categories = Arrays.asList(movies, series, cartoons);

        // Save to db
        this.categoriesRepository.saveAll(categories);
    }

    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    public void save(Categories categories) {
        this.categoriesRepository.save(categories);
    }

    public Categories get(long id_category) {
        return categoriesRepository.findById(id_category).get();
    }

    public void delete(long id_category) {
        categoriesRepository.deleteById(id_category);
    }
}
