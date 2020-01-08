/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Anđelka
 */
@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private long id_category;
    @Column(name = "category_name")
    private String category_name;

    public Categories() {
    }

    public Categories(long id_category, String category_name) {
        this.id_category = id_category;
        this.category_name = category_name;
    }
    public long getId_category() {
        return id_category;
    }

    public void setId_category(long id_category) {
        this.id_category = id_category;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Categories{" + "id_category=" + id_category + ", category_name=" + category_name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id_category ^ (this.id_category >>> 32));
        hash = 97 * hash + Objects.hashCode(this.category_name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categories other = (Categories) obj;
        if (this.id_category != other.id_category) {
            return false;
        }
        if (!Objects.equals(this.category_name, other.category_name)) {
            return false;
        }
        return true;
    }
    
}
