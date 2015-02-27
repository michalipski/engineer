package org.lipski.web.controller;

import org.lipski.event.dao.EventDao;
import org.lipski.event.json.EventJson;
import org.lipski.place.dao.CommentDao;
import org.lipski.place.dao.GradeDao;
import org.lipski.place.dao.PlaceDao;
import org.lipski.place.json.CommentJson;
import org.lipski.place.json.GradeJson;
import org.lipski.place.json.PlaceJson;
import org.lipski.web.json.ObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/btserver")
public class BluetoothRequestController {

    @Autowired
    PlaceDao placeDao;

    @Autowired
    CommentDao commentDao;

    @Autowired
    GradeDao gradeDao;

    @Autowired
    EventDao eventDao;

    @Autowired
    ObjectConverter objectConverter;

    @RequestMapping(value = "/getjsonplaces/{id}", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView getJsonPlaces(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        List<PlaceJson> placeJsonList = placeDao.getJsonPlacesList(id);
        String places = objectConverter.getPlaceListJson(placeJsonList);
        modelAndView.addObject("response",places);
        modelAndView.setViewName("jsonresponse");
        return modelAndView;
    }

    @RequestMapping(value = "/getjsoncomments/{id}" ,method = RequestMethod.GET, produces = "application/json")
    public ModelAndView getJsonComments(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        List<CommentJson> commentJsonList = commentDao.getJsonCommentsList(id);
        String comments = objectConverter.getCommentListJson(commentJsonList);
        modelAndView.addObject("response",comments);
        modelAndView.setViewName("jsonresponse");
        return modelAndView;
    }

    @RequestMapping(value = "/getjsonevents/{id}" ,method = RequestMethod.GET, produces = "application/json")
    public ModelAndView getJsonEvents(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        List<EventJson> eventJsonList = eventDao.getJsonEventsList(id);
        String events = objectConverter.getEventListJson(eventJsonList);
        modelAndView.addObject("response",events);
        modelAndView.setViewName("jsonresponse");
        return modelAndView;
    }

    @RequestMapping(value = "/getjsongrades/{id}" ,method = RequestMethod.GET, produces = "application/json")
    public ModelAndView getJsonGrades(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        List<GradeJson> gradeJsonList = gradeDao.getJsonGradesList(id);
        String grades = objectConverter.getGradeListJson(gradeJsonList);
        modelAndView.addObject("response",grades);
        modelAndView.setViewName("jsonresponse");
        return modelAndView;
    }

}
