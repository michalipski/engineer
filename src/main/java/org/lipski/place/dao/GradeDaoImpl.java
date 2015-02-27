package org.lipski.place.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.lipski.place.json.GradeJson;
import org.lipski.place.model.Comment;
import org.lipski.place.model.Grade;
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
public class GradeDaoImpl implements GradeDao{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    PlaceDao placeDao;

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public void saveGradeForPlace(Integer placeId, String username, Integer grade) {
        Place place = placeDao.getPlaceById(placeId);
        User user = userDao.findByUserName(username);

        Grade g = new Grade(grade,user,new Date(),place);

        Session session = sessionFactory.getCurrentSession();
        session.save(g);
    }

    @Override
    @Transactional
    public Integer getUserGradeForPlace(Integer placeId, String username) {
        Session session = sessionFactory.getCurrentSession();
        List<Grade> grades = session.createCriteria(Grade.class, "grade")
                .createAlias("grade.author", "author")
                .createAlias("grade.place","place")
                .add(Restrictions.and(
                        Restrictions.eq("place.id",placeId),
                        Restrictions.like("author.username",username)
                )).list();
        return grades.get(0).getGrade();
    }

    @Override
    @Transactional
    public boolean isGradedByUser(Integer placeId, String username) {
        Session session = sessionFactory.getCurrentSession();
        List<Grade> grades = session.createCriteria(Grade.class, "grade")
                .createAlias("grade.author", "author")
                .createAlias("grade.place","place")
                .add(Restrictions.and(
                        Restrictions.eq("place.id",placeId),
                        Restrictions.like("author.username",username)
                )).list();
        if (grades.size()>0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public List<GradeJson> getJsonGradesList(Integer serverId) {
        Session session = sessionFactory.getCurrentSession();
        List<Grade> gradeList = session.createCriteria(Grade.class,"grade")
                .createAlias("grade.place","place")
                .createAlias("place.bluetoothServer","bluetoothServer")
                .add(Restrictions.eq("bluetoothServer.id",serverId))
                .add(Restrictions.eq("changed",true))
                .list();

        List<GradeJson> jsonGradesList = new ArrayList<>();
        for(Grade grade:gradeList) {
            GradeJson gradeJson = new GradeJson(grade);
            jsonGradesList.add(gradeJson);
        }

        return jsonGradesList;
    }

    @Override
    public List<Grade> findUserGrades(User u) {
        return null;
    }

    @Override
    public List<Grade> findPlaceGrades(Place p) {
        return null;
    }

    @Override
    public Double getAverageGradeForPlace(Place p) {
        return null;
    }
}
