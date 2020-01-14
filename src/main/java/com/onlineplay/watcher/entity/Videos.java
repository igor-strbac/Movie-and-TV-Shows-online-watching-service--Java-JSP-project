/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Anđelka
 */
@Entity
@Table(name = "videos")
public class Videos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_video")
    private long id_video;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;
    
    @Column(name = "picture_link")
    private String pictureLink;

    @Column(name = "length")
    private String length;

    @Column(name = "description")
    private String description;

    @Column(name = "added")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date added = new Date();
 
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subcategories_id_subcategory")
    private Subcategories subcategories;
    
    public Videos() {
    }

    public Videos(long id_video, String title, String link, String pictureLink, String length, String description, Subcategories subcategories) {
        this.id_video = id_video;
        this.title = title;
        this.link = link;
        this.pictureLink = pictureLink;
        this.length = length;
        this.description = description;
        this.subcategories = subcategories;
    }

    public long getId_video() {
        return id_video;
    }

    public void setId_video(long id_video) {
        this.id_video = id_video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Subcategories getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Subcategories subcategories) {
        this.subcategories = subcategories;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.id_video ^ (this.id_video >>> 32));
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Objects.hashCode(this.link);
        hash = 47 * hash + Objects.hashCode(this.pictureLink);
        hash = 47 * hash + Objects.hashCode(this.length);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.added);
        hash = 47 * hash + Objects.hashCode(this.subcategories);
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
        final Videos other = (Videos) obj;
        if (this.id_video != other.id_video) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.link, other.link)) {
            return false;
        }
        if (!Objects.equals(this.pictureLink, other.pictureLink)) {
            return false;
        }
        if (!Objects.equals(this.length, other.length)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.added, other.added)) {
            return false;
        }
        if (!Objects.equals(this.subcategories, other.subcategories)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Videos{" + "id_video=" + id_video + ", title=" + title + ", link=" + link + ", pictureLink=" + pictureLink + ", length=" + length + ", description=" + description + ", added=" + added + ", subcategories=" + subcategories + '}';
    }


}
