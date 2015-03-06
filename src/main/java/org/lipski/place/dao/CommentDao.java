package org.lipski.place.dao;

import org.lipski.place.json.CommentJson;
import org.lipski.place.model.Comment;
import org.lipski.place.model.Place;
import org.lipski.users.model.User;

import java.util.List;

public interface CommentDao {

    public List<Comment> findUserComments(User u);
    public List<Comment> findPlaceComments(Place p);
    public void saveCommentForPlace(Integer placeId, String username, String content);

    public List<CommentJson> getJsonCommentsList(Integer serverId);

    public void setCommentsUpdated(Integer serverId);
}
