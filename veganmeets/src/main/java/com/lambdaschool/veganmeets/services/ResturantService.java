package com.lambdaschool.veganmeets.services;

import com.lambdaschool.veganmeets.DAO.ResturantDao;
import com.lambdaschool.veganmeets.models.Resturant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ResturantService {

    @Autowired
    private ResturantDao resturantDao;

    public Collection<Resturant> getAllResturants(){
        return this.resturantDao.getAllResturants();
    }
    public Resturant getResturantById(int id){
        return this.resturantDao.getResturantById(id);
    }

    public void removeResturantById(int id) {
        this.resturantDao.removeResturantById(id);
    }

    public void updateResturant(Resturant resturant) {
        this.resturantDao.updateResturant(resturant);
    }

    public void insertResturant(Resturant resturant) {
        this.resturantDao.insertResturanttoDB(resturant);
    }
}
