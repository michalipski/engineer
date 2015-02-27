package org.lipski.place.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.lipski.place.json.PlaceJson;
import org.lipski.place.model.Place;
import org.lipski.web.model.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PlaceDaoImpl implements PlaceDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Place getPlaceById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Place place = (Place) session.get(Place.class,id);
        Hibernate.initialize(place.getComments());
        return place;
    }

    @Override
    public List<Place> getAllPlaces(){
        Session session = sessionFactory.getCurrentSession();
        List<Place> places = session.createCriteria(Place.class).list();
        return places;
    }

    @Override
    public List<Place> getPlacesByCity(String cityName) {
        return null;
    }

    @Override
    public boolean deletePlace(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(getPlaceById(id));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updatePlace(Place place) {
        Session session = sessionFactory.getCurrentSession();
//        try {
            session.update(place);
//        } catch (Exception e) {
//            return false;
//        }
        return true;
    }

    @Override
    public List<PlaceJson> getJsonPlacesList(Integer serverId) {
        Session session = sessionFactory.getCurrentSession();

        List<Place> placeList = session.createCriteria(Place.class)
                .add(Restrictions.eq("bluetoothServer.id",serverId))
                .add(Restrictions.eq("changed",true))
                .list();

        List<PlaceJson> jsonPlaceList = new ArrayList<>();

        for (Place place:placeList) {
            PlaceJson placeJson = Place.getJsonPlace(place);
            jsonPlaceList.add(placeJson);
        }

        return jsonPlaceList;
    }

    public List<Integer> getPlaceIdsForBtServer(Integer serverId) {
        Session session = sessionFactory.getCurrentSession();

        List<Integer> idsList = session.createCriteria(Place.class)
                .add(Restrictions.eq("bluetoothServer.id",serverId))
                .setProjection(Projections.property("id"))
                .list();

        return idsList;
    }

    public PlaceJson getJsonPlace(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Place place = (Place) session.get(Place.class,id);
        PlaceJson placeJson = new PlaceJson(place);
        return placeJson;
    }


    @Override
    public List<Place> getPlacesWithRestrictions(Restrictions restrictions) {
        return null;
    }

    @Override
    public List<Place> getPlacesByFilterRequest(FilterRequest filterRequest) {
        Session session = sessionFactory.getCurrentSession();
        List<Place> places = session.createCriteria(Place.class)
                .add(Restrictions.or(Restrictions.eqOrIsNull("name", filterRequest.getName()),
                                     Restrictions.eqOrIsNull("city",filterRequest.getCity())))
                .list();
        return places;
    }

    @Override
    public void savePlace(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.save(place);
    }


}
