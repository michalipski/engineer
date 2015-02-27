package org.lipski.event.dao;

import org.lipski.event.json.EventJson;

import java.util.List;

public interface EventDao {
    List<EventJson> getJsonEventsList(Integer serverId);
}
