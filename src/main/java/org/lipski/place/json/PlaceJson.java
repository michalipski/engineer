package org.lipski.place.json;

import org.lipski.place.model.Place;

import java.util.Date;

public class PlaceJson {

    Integer id;
    String name;
    String address;
    String city;
    String description;
    Integer phone;
    Date openHour;
    Date closeHour;

    public PlaceJson(Place place) {
        this.id = place.getId();
        this.address = place.getAddress();
        this.name = place.getName();
        this.city = place.getCity();
        this.description = place.getDescription();
        this.phone = place.getPhone();
        this.openHour = place.getOpenHour();
        this.closeHour = place.getCloseHour();
    }
}
