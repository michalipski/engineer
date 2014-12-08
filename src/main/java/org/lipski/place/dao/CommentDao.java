package org.lipski.place.dao;

import org.lipski.place.model.Comment;
import org.lipski.place.model.Place;
import org.lipski.users.model.User;

import java.util.List;

public interface CommentDao {

    public List<Comment> findUserComments(User u);
    public List<Comment> findPlaceComments(Place p);
}