package org.lipski.web.controller;

import org.lipski.place.dao.PlaceDao;
import org.lipski.place.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlaceController {

    @Autowired
    PlaceDao placeDao;

    @RequestMapping(value = "/place/{id}", method = RequestMethod.GET)
    public ModelAndView placeResponse(@PathVariable(value = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Place place = placeDao.getPlaceById(id);
        modelAndView.addObject("place", place);
        modelAndView.setViewName("place");
        return modelAndView;
    }

    @RequestMapping(value = "/addplace/", method = RequestMethod.POST)
    public String addPlace(@ModelAttribute("addPlace") Place place) {
        placeDao.savePlace(place);
        return "placeAdded";
    }
/*
    @RequestMapping(value = "/addplace", method = RequestMethod.GET)
    public
     */
}
