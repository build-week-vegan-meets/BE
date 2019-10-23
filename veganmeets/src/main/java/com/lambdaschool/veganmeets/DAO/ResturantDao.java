package com.lambdaschool.veganmeets.DAO;

import org.springframework.stereotype.Repository;

import com.lambdaschool.veganmeets.models.Resturant;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository

public class ResturantDao {

    private static Map<Integer, Resturant> resturants;
    static{
        resturants = new HashMap<Integer, Resturant>(){
            {
                put(1, new Resturant(1, "Shelby's Resturant", "123 address Here", "805-795-7709", "8-5"));
                put(2, new Resturant(2, "Josh's Resturant", "456 address Here", "805-795-7708", "8-6"));
                put(3, new Resturant(3, "Mom's Resturant", "789 address Here", "805-795-7707", "8-4"));
                put(4, new Resturant(4, "Remy's Resturant", "654 address Here", "805-795-7752", "8-3"));
                put(5, new Resturant(5, "Bentley's Resturant", "321 address Here", "805-795-8521", "12-5"));
            }
        };
    }

    public Collection<Resturant> getAllResturants(){
        return this.resturants.values();
    }
    public Resturant getResturantById(int id){
        return this.resturants.get(id);
    }

    public void removeResturantById(int id) {
        this.resturants.remove(id);
    }

    public void updateResturant(Resturant resturant) {
        Resturant update = resturants.get(resturant.getId());
        update.setResturantname(resturant.getResturantname());
        update.setAddress(resturant.getAddress());
        update.setPhonenumber(resturant.getPhonenumber());
        update.setHoursofoperation(resturant.getHoursofoperation());
        resturants.put(resturant.getId(), resturant);
    }

    public void insertResturanttoDB(Resturant resturant) {
        this.resturants.put(resturant.getId(), resturant);
    }
}