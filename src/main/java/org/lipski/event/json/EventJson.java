package org.lipski.event.json;

import org.lipski.event.model.Event;

import java.util.Date;

public class EventJson {

    Integer id;
    String name;
    Integer placeId;
    Date data;
    String description;

    public EventJson(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.placeId = event.getPlace().getId();
        this.data = event.getData();
        this.description = event.getDescription();
    }
}
