package org.lipski.place.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.lipski.place.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceDaoImpl implements PlaceDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Place getPlaceById(Integer id) {
        return null;
    }

    @Override
    public List<Place> getPlacesWithRestrictions(Restrictions restrictions) {
        return null;
    }
}
