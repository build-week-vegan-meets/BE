package com.lambdaschool.veganmeets.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "resturants")
public class Resturant extends Auditable
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long resturantid;

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

        public Resturant(String resturantid, String resturantname, String address, String phonenumber, String hoursofoperation, ArrayList<String> menuitems)
        {
            setResturantname(resturantname);
            setAddress(address);
            setPhoneNumber(phonenumber);
            setHoursOfOperation(hoursofoperation);
            setMenuItems(menuitems);
        }


        //declaration of the functions being called
        public long getResturantid()
        {
            return resturantid;
        }

        public void setResturantid(long resturantid)
        {
            this.resturantid = resturantid;
        }

        public String getResturantname()
        {
            return resturantname;
        }

        public void setResturantname(String resturantname)
        {
            this.resturantname = resturantname;
        }

        public String getAddress()
        {
            return address;
        }

        public void setAddress(String address)
        {
            this.address = address;
        }

        public String getPhonenumber()
        {
            return phonenumber;
        }

        public void setPhoneNumber(String phonenumber)
        {
            this.phonenumber = phonenumber;
        }

        public String getHoursofoperation()
        {
            return hoursofoperation;
        }

        public void setHoursOfOperation(String hoursofoperation)
        {
            this.address = hoursofoperation;
        }


        public ArrayList<String> getMenuitems()
        {
            return menuitems;
        }

        public void setMenuItems(ArrayList<String> menuitems)
        {
            this.menuitems = menuitems;
        }

        @Override
        public String toString()
        {
            return "Resturant{" + "resturantid=" + resturantid + ", resturantname='" + resturantname + '\'' + ", address='" + address + '\'' + ", phonenumber=" + phonenumber + ", hoursofoperation=" + hoursofoperation +  '}';
        }
    }
