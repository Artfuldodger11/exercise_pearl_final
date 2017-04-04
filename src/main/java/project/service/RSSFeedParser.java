package project.service;


import project.domain.Feed;
import project.domain.Item;

import java.util.List;

public interface RSSFeedParser {

    Feed readFeed();

    List<Item> readItems();
}
