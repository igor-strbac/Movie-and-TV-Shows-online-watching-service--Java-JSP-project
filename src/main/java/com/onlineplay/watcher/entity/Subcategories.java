/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Anđelka
 */
@Entity
@Table(name = "subcategories")
public class Subcategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategory")
    private long id_subcategory;

    @Column(name = "subcategory_name")
    private String subcategory_name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categories_id_category")
    private Categories categories;

//    @OneToMany(mappedBy = "subcategories")
//    private Set<Match> match = new HashSet<>();

    public Subcategories() {
    }

    public long getId_subcategory() {
        return id_subcategory;
    }

    public void setId_subcategory(long id_subcategory) {
        this.id_subcategory = id_subcategory;
    }

    public String getSubcategory_name() {
        return subcategory_name;
    }

    public void setSubcategory_name(String subcategory_name) {
        this.subcategory_name = subcategory_name;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.id_subcategory ^ (this.id_subcategory >>> 32));
        hash = 41 * hash + Objects.hashCode(this.subcategory_name);
        hash = 41 * hash + Objects.hashCode(this.categories);
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
        final Subcategories other = (Subcategories) obj;
        if (this.id_subcategory != other.id_subcategory) {
            return false;
        }
        if (!Objects.equals(this.subcategory_name, other.subcategory_name)) {
            return false;
        }
        if (!Objects.equals(this.categories, other.categories)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Subcategories{" + "id_subcategory=" + id_subcategory + ", subcategory_name=" + subcategory_name + ", categories=" + categories + '}';
    }


}
