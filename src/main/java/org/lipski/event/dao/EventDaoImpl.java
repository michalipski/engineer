package org.lipski.event.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.lipski.event.json.EventJson;
import org.lipski.event.model.Event;
import org.lipski.web.model.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
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

    @Override
    public List<Event> getAllEvents() {
        Session session = sessionFactory.getCurrentSession();
        List<Event> events = session.createCriteria(Event.class).list();
        return events;
    }

    @Override
    public List<Event> getEventsByFilterRequest(FilterRequest filterRequest) {
        Session session = sessionFactory.getCurrentSession();
        List<Event> events = session.createCriteria(Event.class)
                .add(Restrictions.or(
                        Restrictions.eqOrIsNull("name",filterRequest.getName()),
                        Restrictions.eqOrIsNull("place.city",filterRequest.getCity())
                )).list();
        return events;
    }

    @Override
    public Event getEventById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Event event = (Event) session.get(Event.class, id);
        return event;
    }

    @Override
    public void setEventsUpdated(Integer serverId) {
        List<Integer> idsList = getEventIdsForServer(serverId);
        Session session = sessionFactory.getCurrentSession();
        if(!idsList.isEmpty()){
            for (Integer id:idsList) {
                Event event = (Event) session.get(Event.class, id);
                event.setChanged(false);
                session.update(event);
            }
        }
    }

    @Override
    public void updateEvent(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.update(event);
    }

    @Override
    public void addNewEvent(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.save(event);
    }

    @Override
    public void deleteEvent(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Event event = getEventById(id);
        session.delete(event);
    }

    private List<Integer> getEventIdsForServer(Integer serverId) {
        Session session = sessionFactory.getCurrentSession();
        List<Integer> idsList = session.createCriteria(Event.class, "event")
                .createAlias("event.place","place")
                .createAlias("place.bluetoothServer","bluetoothServer")
                .add(Restrictions.eq("bluetoothServer.id",serverId))
                .add(Restrictions.eq("changed",true))
                .setProjection(Projections.property("id"))
                .list();
        return idsList;
    }
}
