package com.example.demo;

import java.util.List;

public interface ICityService {
    List<FeedMessage> findAll();
    FeedMessage create(FeedMessage feedMessage);
}
