package org.lipski.place.dao;

import org.hibernate.SessionFactory;
import org.lipski.place.model.Grade;
import org.lipski.place.model.Place;
import org.lipski.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeDaoImpl implements GradeDao{

    @Autowired
    SessionFactory sessionFactory;

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
