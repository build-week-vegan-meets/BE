package com.lambdaschool.veganmeets.controllers;

import com.lambdaschool.veganmeets.models.APIOpenLibrary;
import com.lambdaschool.veganmeets.models.Resturant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/resturants")
public class ResturantController
{
    private static final Logger logger = LoggerFactory.getLogger(ResturantController.class);
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/{resturantid}",
                produces = {"application/json"})
    public ResponseEntity<?> ListAResturantByID(HttpServletRequest request,
                                                @PathVariable
                                                        String resturantid)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        String requestURL = "http://localhost:2019/resturants" + resturantid + "&format=json";

        ParameterizedTypeReference<Map<String, Resturant>> responseType = new ParameterizedTypeReference<Map<String, Resturant>>()
        {
        };
        ResponseEntity<Map<String, Resturant>> responseEntity = restTemplate.exchange(requestURL, HttpMethod.GET, null, responseType);

        Map<String, Resturant> ourResturant = responseEntity.getBody();

        System.out.println(ourResturant);
        return new ResponseEntity<>(ourResturant, HttpStatus.OK);
    }
}
