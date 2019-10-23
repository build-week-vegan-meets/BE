package com.lambdaschool.veganmeets.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "resturants")
public class Resturant extends Auditable
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column(nullable = false,
                unique = false)
        private String resturantname;

        @Column(nullable = false,
                unique = true)
        private String address;

        @Column(nullable = false,
                unique = true)
        private String phonenumber;

        @Column(nullable = false,
                unique = false)
        private String hoursofoperation;

        @Column(nullable = true,
                unique = false)
        private ArrayList<String> menuitems = new ArrayList<>();

        public Resturant()
        {
        }

        public Resturant(int id, String resturantname, String address, String phonenumber, String hoursofoperation) {
        this.id = id;
        this.resturantname = resturantname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.hoursofoperation = hoursofoperation;
    }

        public int getId() {
            return id;
        }

    public void setId(int id) {
        this.id = id;
    }

    public String getResturantname() {
        return resturantname;
    }

    public void setResturantname(String resturantname) {
        this.resturantname = resturantname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getHoursofoperation() {
        return hoursofoperation;
    }

    public void setHoursofoperation(String hoursofoperation) {
        this.hoursofoperation = hoursofoperation;
    }
}
