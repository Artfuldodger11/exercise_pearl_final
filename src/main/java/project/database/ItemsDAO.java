package project.database;


import org.joda.time.LocalDateTime;
import project.domain.Feed;
import project.domain.Item;

import java.util.List;

public interface ItemsDAO {

    int create(Item item) throws DBException;

    List<Item> getItemsListByFeedId(int feed_id) throws DBException;


}
