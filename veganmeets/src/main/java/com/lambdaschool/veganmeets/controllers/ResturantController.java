package com.lambdaschool.veganmeets.controllers;

import com.lambdaschool.veganmeets.models.Resturant;
import com.lambdaschool.veganmeets.services.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/resturants")
public class ResturantController {

    @Autowired
    private ResturantService resturantService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Resturant> getAllResturants(){
        return resturantService.getAllResturants();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Resturant getResturantById(@PathVariable("id") int id){
        return resturantService.getResturantById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteResturantById(@PathVariable("id") int id){
        resturantService.removeResturantById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateResturant(@RequestBody Resturant resturant){
        resturantService.updateResturant(resturant);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertResturant (@RequestBody Resturant resturant){
        resturantService.insertResturant(resturant);
    }
}
