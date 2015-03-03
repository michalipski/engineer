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

    public PlaceJson() {
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Date openHour) {
        this.openHour = openHour;
    }

    public Date getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Date closeHour) {
        this.closeHour = closeHour;
    }
}
