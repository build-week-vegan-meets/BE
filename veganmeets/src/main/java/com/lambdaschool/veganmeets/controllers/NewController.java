package com.lambdaschool.veganmeets.controllers;

import com.lambdaschool.veganmeets.models.Resturant;
import com.lambdaschool.veganmeets.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

// in order to return an auth token
// client goes to this end point
// client then goes to login end point

@RestController
public class NewController
{
    private static final Logger logger = LoggerFactory.getLogger(ResturantController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/createnewresturant",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewResturant(HttpServletRequest request, @Valid
    @RequestBody
            Resturant newresturant) throws URISyntaxException
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");



        // ** TODO addresturantfucntions


        // set the location header for the newly created resource - to another controller!
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromUriString(request.getServerName() + ":" + request.getLocalPort() + "/resturants/resturant/resturantid")
                                                          .buildAndExpand(newresturant.getResturantid())
                                                          .toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("favicon.ico")
    void returnNoFavicon()
    {
        logger.trace("favicon.ico endpoint accessed!");
    }
}
