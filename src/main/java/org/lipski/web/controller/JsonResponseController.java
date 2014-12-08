package org.lipski.web.controller;

import org.lipski.place.dao.PlaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class JsonResponseController {

    @Autowired
    PlaceDao placeDao;

}
