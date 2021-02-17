package com.enumjpa.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Article {
    @Id
    private Long id;

    private String title;

    @Enumerated(EnumType.ORDINAL)
    private EStatus status;

    @Enumerated(EnumType.STRING)
    private EType type;

    public Article() {
    }

    public Article(Long id, String title, EStatus status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Article(Long id, String title, EStatus status, EType type) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.type = type;
    }

    public Article(EType type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public EStatus getStatus() {
        return status;
    }
}
