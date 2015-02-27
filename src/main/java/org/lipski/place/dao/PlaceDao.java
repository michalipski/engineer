package org.lipski.place.dao;

import org.hibernate.criterion.Restrictions;
import org.lipski.place.json.PlaceJson;
import org.lipski.place.model.Place;
import org.lipski.web.model.FilterRequest;

import java.util.List;

public interface PlaceDao {

    public Place getPlaceById(Integer id);
    public List<Place> getPlacesWithRestrictions(Restrictions restrictions);
    public List<Place> getPlacesByFilterRequest(FilterRequest filterRequest);
    public void savePlace(Place place);

    public List<Place> getAllPlaces();
    public List<Place> getPlacesByCity(String cityName);

    public boolean deletePlace(Integer id);
    public boolean updatePlace(Place place);

    List<PlaceJson> getJsonPlacesList(Integer id);
}
