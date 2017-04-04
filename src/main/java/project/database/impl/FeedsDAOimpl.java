package project.database.impl;


import project.database.DBException;
import project.database.FeedsDAO;
import project.domain.Feed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component ("ORM_FeedsDAO")
@Transactional
public class FeedsDAOimpl implements FeedsDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Feed feed) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(feed);
    }

    @Override
    public List<Feed> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Feed.class).list();
    }

    @Override
    public Feed getFeedById(Integer id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (Feed) session.get(Feed.class, id);
    }


}
