package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private CityService cityService;

    @Scheduled(fixedRate = 20000)
    public void reportCurrentTime() {
        log.info("The time is no {}", dateFormat.format(new Date()));
        RSSFeedParser parser = new RSSFeedParser("http://feeds.nos.nl/nosjournaal?format=xml");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);
            cityService.create(message);
        }

    }
}
