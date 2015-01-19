package org.lipski.place.dao;

import org.hibernate.criterion.Restrictions;
import org.lipski.place.model.Place;

import java.util.List;

public interface PlaceDao {

    public Place getPlaceById(Integer id);
    public List<Place> getPlacesWithRestrictions(Restrictions restrictions);
    public void savePlace(Place place);
}
