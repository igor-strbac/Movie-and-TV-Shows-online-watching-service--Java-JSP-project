/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.service;

import com.onlineplay.watcher.entity.Subcategories;
import com.onlineplay.watcher.entity.Videos;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onlineplay.watcher.repository.VideosRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Anđelka
 */
@Service("videosService")
@Transactional
public class VideosService {

    private VideosRepository videosRepository;

    @Autowired
    public VideosService(VideosRepository videosRepository) {
        this.videosRepository = videosRepository;
    }

    public List<Videos> findAll() {
        return videosRepository.findAll();
    }

    public void save(Videos videos) {
        videosRepository.save(videos);
    }

    public Videos get(long id_video) {
        return videosRepository.findById(id_video).get();
    }

    public void delete(long id_video) {
        videosRepository.deleteById(id_video);
    }

    //public List<Videos> findSubcategoriesByCategory() {
    //    return videosRepository.findSubcategoriesByCategory(3);
    //}

    // public Videos findByTitle(String title) {
    //     return contentRepository.findByTitle(title);
    // }
    //
}
