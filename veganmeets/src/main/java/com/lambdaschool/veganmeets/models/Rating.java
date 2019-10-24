package com.lambdaschool.veganmeets.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "rating")
public class Rating extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false,
            unique = false)
    private String resturantid;

    @Column(nullable = false,
            unique = false)
    private String rating;

    public Rating(){}

    public Rating(int id, String resturantid, String rating) {
        this.id = id;
        this.resturantid = resturantid;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResturantid() {
        return resturantid;
    }

    public void setResturantid(String resturantid) {
        this.resturantid = resturantid;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
