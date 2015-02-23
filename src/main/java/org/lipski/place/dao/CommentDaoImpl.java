package org.lipski.place.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lipski.place.model.Comment;
import org.lipski.place.model.Place;
import org.lipski.users.dao.UserDao;
import org.lipski.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;

    @Autowired
    PlaceDao placeDao;

    @Override
    @Transactional
    public void saveCommentForPlace(Integer placeId, String username, String content) {
        Place place = placeDao.getPlaceById(placeId);
        User user = userDao.findByUserName(username);

        Comment comment = new Comment(user,place,content,new Date());

        Session session = sessionFactory.getCurrentSession();
        session.save(comment);
    }

    @Override
    public List<Comment> findUserComments(User u) {
        return null;
    }

    @Override
    public List<Comment> findPlaceComments(Place p) {
        return null;
    }
}
