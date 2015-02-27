package org.lipski.event.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.lipski.event.json.EventJson;
import org.lipski.event.model.Event;
import org.lipski.place.json.CommentJson;
import org.lipski.place.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<EventJson> getJsonEventsList(Integer serverId) {
        Session session = sessionFactory.getCurrentSession();
        List<Event> eventList = session.createCriteria(Event.class,"event")
                .createAlias("comment.place","place")
                .createAlias("place.bluetoothServer","bluetoothServer")
                .add(Restrictions.eq("bluetoothServer.id", serverId))
                .add(Restrictions.eq("changed",true))
                .list();

        List<EventJson> jsonEventsList = new ArrayList<>();
        for(Event event:eventList) {
            EventJson eventJson = new EventJson(event);
            jsonEventsList.add(eventJson);
        }

        return jsonEventsList;
    }
}
