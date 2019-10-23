package com.lambdaschool.veganmeets.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Menu Items")
public class Menu extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false,
            unique = false)
    private String name;

    @Column(nullable = false,
            unique = true)
    private String description;

    @Column(nullable = false,
            unique = true)
    private String price;

    @Column(nullable = false,
            unique = false)
    private String resturantid;

    public Menu()
    {
    }

    public Menu(int id, String name, String description, String price, String resturantid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.resturantid = resturantid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getResturantid() {
        return resturantid;
    }

    public void setResturantid(String resturantid) {
        this.resturantid = resturantid;
    }
}
