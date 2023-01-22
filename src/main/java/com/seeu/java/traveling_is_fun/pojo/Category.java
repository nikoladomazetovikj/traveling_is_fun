package com.seeu.java.traveling_is_fun.pojo;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categories name;

    public Category(Long id, Categories name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categories getName() {
        return name;
    }

    public void setName(Categories name) {
        this.name = name;
    }
}
