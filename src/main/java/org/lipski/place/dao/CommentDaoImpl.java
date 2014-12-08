package org.lipski.place.dao;

import org.hibernate.SessionFactory;
import org.lipski.place.model.Comment;
import org.lipski.place.model.Place;
import org.lipski.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Comment> findUserComments(User u) {
        return null;
    }

    @Override
    public List<Comment> findPlaceComments(Place p) {
        return null;
    }
}
