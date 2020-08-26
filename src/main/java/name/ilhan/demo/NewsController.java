package name.ilhan.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/news")
    public List<FeedMessage> findCities() {

        return newsService.findAll();
    }

}
