package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/news")
    public List<FeedMessage> findCities() {

        return cityService.findAll();
    }

}
