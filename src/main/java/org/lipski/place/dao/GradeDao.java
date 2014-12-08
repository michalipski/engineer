package org.lipski.place.dao;

import org.lipski.place.model.Grade;
import org.lipski.place.model.Place;
import org.lipski.users.model.User;

import java.util.List;

public interface GradeDao {

    public List<Grade> findUserGrades(User u);
    public List<Grade> findPlaceGrades(Place p);
    public Double getAverageGradeForPlace(Place p);
}
