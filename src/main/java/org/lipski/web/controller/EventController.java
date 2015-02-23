package org.lipski.web.controller;

import org.lipski.event.dao.EventDao;
import org.lipski.event.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {

    @Autowired
    EventDao eventDao;


}
