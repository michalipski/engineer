package org.lipski.event.json;

import org.lipski.event.model.Event;

import java.util.Date;

public class EventJson {

    Integer id;
    String name;
    Integer placeId;
    Date data;
    String description;

    public EventJson() {
    }

    public EventJson(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.placeId = event.getPlace().getId();
        this.data = event.getData();
        this.description = event.getDescription();
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

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
