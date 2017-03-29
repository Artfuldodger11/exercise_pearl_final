package project.database;



import project.domain.Feed;

import java.util.List;

public interface FeedsDAO {

    void create(Feed feed) throws DBException;
    List<Feed> getAll() throws DBException;
}
