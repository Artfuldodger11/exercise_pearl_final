package project.database.impl;


import project.database.DBException;
import project.database.ItemsDAO;

import project.domain.Feed;
import project.domain.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component ("ORM_ItemsDAO")
@Transactional
public class ItemsDAOimpl implements ItemsDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void create(Item item) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public Item getByFeedId(String feed_id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (Item) session.get(Item.class, feed_id);
    }
}
