package org.lipski.event.dao;

import org.lipski.event.json.EventJson;
import org.lipski.event.model.Event;
import org.lipski.web.model.FilterRequest;

import java.util.List;

public interface EventDao {
    List<EventJson> getJsonEventsList(Integer serverId);

    public List<Event> getAllEvents();

    public List<Event> getEventsByFilterRequest(FilterRequest filterRequest);

    public Event getEventById(Integer id);

    public void setEventsUpdated(Integer serverId);

    public void updateEvent(Event event);

    public void addNewEvent(Event event);

    public void deleteEvent(Integer id);
}
