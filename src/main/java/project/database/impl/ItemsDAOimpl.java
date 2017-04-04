package project.database.impl;


import org.hibernate.criterion.Restrictions;
import project.database.DBException;
import project.database.ItemsDAO;

import project.domain.Feed;
import project.domain.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component ("ORM_ItemsDAO")
@Transactional
public class ItemsDAOimpl implements ItemsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int create(Item item) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
        session.flush();
        return item.getId();
    }

    @Override
    public List<Item> getItemsListByFeedId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return(List<Item>) session.createCriteria(Item.class).add(Restrictions.eq("feed_id", id)).list();
    }


}
