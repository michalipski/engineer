package org.lipski.place.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.lipski.place.json.CommentJson;
import org.lipski.place.model.Comment;
import org.lipski.place.model.Place;
import org.lipski.users.dao.UserDao;
import org.lipski.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        comment.setChanged(true);

        Session session = sessionFactory.getCurrentSession();
        session.save(comment);
    }

    @Override
    @Transactional
    public List<CommentJson> getJsonCommentsList(Integer serverId) {
        Session session = sessionFactory.getCurrentSession();
        List<Comment> commentList = session.createCriteria(Comment.class,"comment")
                .createAlias("comment.place","place")
                .createAlias("place.bluetoothServer","bluetoothServer")
                .add(Restrictions.eq("bluetoothServer.id",serverId))
                .add(Restrictions.eq("changed",true))
                .list();

        List<CommentJson> jsonCommentsList = new ArrayList<>();
        for(Comment comment:commentList) {
            CommentJson commentJson = new CommentJson(comment);
            jsonCommentsList.add(commentJson);
        }

        return jsonCommentsList;
    }

    @Transactional
    private List<Integer> getCommentIdsForServer(Integer serverId) {
        Session session = sessionFactory.getCurrentSession();
        List<Integer> idsList = session.createCriteria(Comment.class, "comment")
                .createAlias("comment.place","place")
                .createAlias("place.bluetoothServer","bluetoothServer")
                .add(Restrictions.eq("bluetoothServer.id",serverId))
                .add(Restrictions.eq("changed",true))
                .setProjection(Projections.property("id"))
                .list();
        return idsList;
    }

    @Override
    @Transactional
    public void setCommentsUpdated(Integer serverId) {
        List<Integer> commentIds = getCommentIdsForServer(serverId);
        Session session = sessionFactory.getCurrentSession();

        if(!commentIds.isEmpty()) {
            for (Integer id:commentIds) {
                Comment comment = (Comment) session.get(Comment.class,id);
                comment.setChanged(false);
                session.update(comment);
            }
        }
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
