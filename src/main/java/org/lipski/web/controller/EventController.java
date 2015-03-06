package org.lipski.web.controller;

import org.lipski.event.dao.EventDao;
import org.lipski.event.model.Event;
import org.lipski.place.dao.PlaceDao;
import org.lipski.place.model.Place;
import org.lipski.web.model.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Nullable;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    EventDao eventDao;

    @Autowired
    PlaceDao placeDao;

    @RequestMapping(value = "event/list", method = RequestMethod.GET)
    public ModelAndView getEventsList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Event> events = eventDao.getAllEvents();
        modelAndView.addObject("events",events);
        modelAndView.addObject("filterRequest",new FilterRequest());
        modelAndView.setViewName("eventsList");
        return modelAndView;
    }

    @RequestMapping(value = "event/{id}", method = RequestMethod.GET)
    public ModelAndView getEventById(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Event event = eventDao.getEventById(id);
        modelAndView.addObject("event",event);
        modelAndView.setViewName("event");
        return modelAndView;
    }

    @RequestMapping(value = "filtereventslist", method = RequestMethod.POST)
    public ModelAndView filterList(@ModelAttribute(value = "filterRequest")
                                   @Nullable FilterRequest filterRequest,
                                   BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<Event> events = eventDao.getEventsByFilterRequest(filterRequest);
        modelAndView.addObject("filterRequest",filterRequest);
        modelAndView.addObject("events", events);
        modelAndView.setViewName("eventsList");
        return modelAndView;
    }

    @RequestMapping(value = "event/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editEventForm(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Event event = eventDao.getEventById(id);
        List<Place> places = placeDao.getAllPlaces();
        modelAndView.addObject("editedEvent",event);
        modelAndView.addObject("placesList",places);
        modelAndView.setViewName("editEvent");
        return modelAndView;
    }

    @RequestMapping(value = "event/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editEvent(@ModelAttribute(value = "editedEvent") Event event,
                                  @PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Place place = placeDao.getPlaceById(event.getPlace().getId());
        event.setPlace(place);
        event.setChanged(true);
        try {
            eventDao.updateEvent(event);
            modelAndView.addObject("message","Event edited successfully");
        } catch (Exception e) {
            modelAndView.addObject("message","Event not edited");
        }
        modelAndView.setViewName("response");
        return modelAndView;
    }

    @RequestMapping(value = "addevent", method = RequestMethod.POST)
    public ModelAndView addEvent(@ModelAttribute(value = "addedEvent") Event event) {
        ModelAndView modelAndView = new ModelAndView();
        Place place = placeDao.getPlaceById(event.getPlace().getId());
        event.setPlace(place);
        event.setChanged(true);
        try {
            eventDao.addNewEvent(event);
            modelAndView.addObject("message","Event added successfully");
        } catch (Exception e) {
            modelAndView.addObject("message","Event not added");
        }
        modelAndView.setViewName("response");
        return modelAndView;
    }

    @RequestMapping(value = "addevent", method = RequestMethod.GET)
    public ModelAndView addEventForm() {
        ModelAndView modelAndView = new ModelAndView();
        Event event = new Event();
        List<Place> places = placeDao.getAllPlaces();
        modelAndView.addObject("event",event);
        modelAndView.addObject("placesList",places);
        modelAndView.setViewName("addEvent");
        return modelAndView;
    }

    @RequestMapping(value = "event/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEvent(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            eventDao.deleteEvent(id);
            modelAndView.addObject("message","Event deleted");
        } catch (Exception e) {
            modelAndView.addObject("message","Event not deleted");
        }
        modelAndView.setViewName("response");
        return modelAndView;
    }

}
