package name.ilhan.demo;

import java.util.List;

public interface INewsService {
    List<FeedMessage> findAll();
    FeedMessage create(FeedMessage feedMessage);
}
