package com.lambdaschool.veganmeets.controllers;

import com.lambdaschool.veganmeets.models.APIOpenLibrary;
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
@RequestMapping("/otherapis")
public class ResturantController
{
    private static final Logger logger = LoggerFactory.getLogger(ResturantController.class);
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/openlibrary/{isbn}",
                produces = {"application/json"})
    public ResponseEntity<?> listABookGivenISBN(HttpServletRequest request,
                                                @PathVariable
                                                        String isbn)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        String requestURL = "https://openlibrary.org/api/books?bibkeys=" + "ISBN:" + isbn + "&format=json";

        ParameterizedTypeReference<Map<String, APIOpenLibrary>> responseType = new ParameterizedTypeReference<Map<String, APIOpenLibrary>>()
        {
        };
        ResponseEntity<Map<String, APIOpenLibrary>> responseEntity = restTemplate.exchange(requestURL, HttpMethod.GET, null, responseType);

        Map<String, APIOpenLibrary> ourBooks = responseEntity.getBody();

        // goodreads

        System.out.println(ourBooks);
        return new ResponseEntity<>(ourBooks, HttpStatus.OK);
    }
}
