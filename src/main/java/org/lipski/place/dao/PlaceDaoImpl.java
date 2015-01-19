package org.lipski.place.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.lipski.place.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PlaceDaoImpl implements PlaceDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Place getPlaceById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Place place = (Place) session.get(Place.class,id);
        Hibernate.initialize(place.getComments());
        return place;
    }

    public List<Place> getAllPlaces(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Place");
        List<Place> places = query.list();
        return places;
    }

    @Override
    public List<Place> getPlacesWithRestrictions(Restrictions restrictions) {
        return null;
    }

    public void savePlace(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.save(place);
    }
}
