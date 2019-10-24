package com.lambdaschool.veganmeets.services;

import com.lambdaschool.veganmeets.DAO.RatingDao;
import com.lambdaschool.veganmeets.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RatingService {

    @Autowired
    private RatingDao ratingDao;

    public Collection<Rating> getAllRatings(){
        return this.ratingDao.getAllRatings();
    }
    public Rating getRatingById(int id){
        return this.ratingDao.getRatingById(id);
    }

    public void removeRatingById(int id) {
        this.ratingDao.removeRatingById(id);
    }

    public void updateRating(Rating rating) {
        this.ratingDao.updateRating(rating);
    }

    public void insertRating(Rating rating) {
        this.ratingDao.insertRatingtoDB(rating);
    }
}
