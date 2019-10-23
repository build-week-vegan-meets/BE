package com.lambdaschool.veganmeets.DAO;

import com.lambdaschool.veganmeets.models.Rating;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository

public class RatingDao {

    private static Map<Integer, Rating> ratings;
    static{
        ratings = new HashMap<Integer, Rating>(){
            {
                put(1, new Rating(1, "1", "5"));
                put(2, new Rating(2, "1", "5" ));
                put(3, new Rating(3, "2", "4"));
            }
        };
    }

    public Collection<Rating> getAllRatings(){
        return this.ratings.values();
    }
    public Rating getRatingById(int id){
        return this.ratings.get(id);
    }

    public void removeRatingById(int id) {
        this.ratings.remove(id);
    }

    public void updateRating(Rating rating) {
        Rating update = ratings.get(rating.getId());
        update.setResturantid(rating.getResturantid());
        update.setRating(rating.getRating());
        ratings.put(rating.getId(), rating);
    }

    public void insertRatingtoDB(Rating rating) {
        this.ratings.put(rating.getId(), rating);
    }
}