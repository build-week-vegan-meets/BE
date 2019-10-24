package com.lambdaschool.veganmeets.controllers;
import com.lambdaschool.veganmeets.models.Rating;
import com.lambdaschool.veganmeets.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Rating getRatingById(@PathVariable("id") int id){
        return ratingService.getRatingById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteRatingById(@PathVariable("id") int id){
        ratingService.removeRatingById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateRating(@RequestBody Rating rating){
        ratingService.updateRating(rating);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertRating (@RequestBody Rating rating){
        ratingService.insertRating(rating);
    }
}
