package project.database;


import project.domain.Item;

public interface ItemsDAO {

    void create(Item item) throws DBException;
    Item getByFeedId(String feed_id) throws DBException;
}
