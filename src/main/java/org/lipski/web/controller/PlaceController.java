package org.lipski.web.controller;

import org.lipski.place.dao.CommentDao;
import org.lipski.place.dao.GradeDao;
import org.lipski.place.dao.PlaceDao;
import org.lipski.place.model.Place;
import org.lipski.web.model.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

@Controller
public class PlaceController {

    @Autowired
    PlaceDao placeDao;

    @Autowired
    CommentDao commentDao;

    @Autowired
    GradeDao gradeDao;

    @RequestMapping(value = "/place/{id}", method = RequestMethod.GET)
    public ModelAndView placeResponse(@PathVariable(value = "id") Integer id){
        UserDetails userDetails;
        try {
            userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (ClassCastException e) {
            userDetails = null;
        }
        return getModelForPlace(id,userDetails);
    }

    @RequestMapping(value = "/addplace", method = RequestMethod.POST)
    public String addPlace(@ModelAttribute("place") Place place, BindingResult bindingResult) {
        place.setChanged(true);
        placeDao.savePlace(place);
        return "placeAdded";
    }

    @RequestMapping(value = "/addplace", method = RequestMethod.GET)
    public String addPlaceForm(Map<String, Object> model) {
        Place place = new Place();
        model.put("place",place);
        return "addplace";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView placesList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Place> places = placeDao.getAllPlaces();
        modelAndView.addObject("places",places);
        modelAndView.addObject("filterRequest",new FilterRequest());
        modelAndView.setViewName("placesList");
        return modelAndView;
    }

    @RequestMapping(value = "/filterplaceslist", method = RequestMethod.POST)
    public ModelAndView filterList(@ModelAttribute(value = "filterRequest")
                                      @Nullable FilterRequest filterRequest,
                                   BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<Place> places = placeDao.getPlacesByFilterRequest(filterRequest);
        modelAndView.addObject("filterRequest",filterRequest);
        modelAndView.addObject("places", places);
        modelAndView.setViewName("placesList");
        return modelAndView;
    }

    @RequestMapping(value = "/place/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePlace(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if(placeDao.deletePlace(id)) {
            modelAndView.addObject("message","Place deleted succesfully");
        } else {
            modelAndView.addObject("message","Place not deleted");
        }
        modelAndView.setViewName("response");
        return modelAndView;
    }

    @RequestMapping(value = "/place/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPlaceForm(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Place place = placeDao.getPlaceById(id);
        modelAndView.addObject("editedPlace",place);
        modelAndView.setViewName("editPlace");
        return modelAndView;
    }

    @RequestMapping(value = "/place/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editPlaceResponse(@ModelAttribute(value = "editedPlace") Place place, @PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        place.setId(id);
        place.setChanged(true);
        if(placeDao.updatePlace(place)) {
            modelAndView.addObject("message","Place edited successfully");
        } else {
            modelAndView.addObject("message","Place not edited");
        }
        modelAndView.setViewName("response");
        return modelAndView;
    }

    @RequestMapping(value = "/place/grade/{id}", method = RequestMethod.POST)
    public ModelAndView gradePlace(@RequestParam(value = "grade") Integer grade, @PathVariable(value = "id") Integer id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        gradeDao.saveGradeForPlace(id,userDetails.getUsername(),grade);
        return getModelForPlace(id,userDetails);
    }

    @RequestMapping(value ="/place/comment/{id}", method = RequestMethod.POST)
    public ModelAndView commentPlace(@RequestParam(value = "comment") String comment, @PathVariable(value = "id") Integer id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentDao.saveCommentForPlace(id,userDetails.getUsername(),comment);
        return getModelForPlace(id,userDetails);
    }

    @RequestMapping(value = "/remotecomment", method = RequestMethod.POST, produces = "text/plain")
    public ModelAndView remoteComment(@RequestParam(value = "placeId") Integer placeId,
                                      @RequestParam(value = "username") String username,
                                      @RequestParam(value = "comment") String comment) {
        ModelAndView modelAndView = new ModelAndView();
        Boolean result = true;
        try {
            commentDao.saveCommentForPlace(placeId, username, comment);
        } catch (Exception e) {
            result = false;
        }
        modelAndView.addObject("result",result);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/remotegrade", method = RequestMethod.POST, produces = "text/plain")
    public ModelAndView remoteGrade(@RequestParam(value = "placeId") Integer placeId,
                                    @RequestParam(value = "username") String username,
                                    @RequestParam(value = "comment") Integer grade) {
        ModelAndView modelAndView = new ModelAndView();
        Boolean result = true;
        try {
            gradeDao.saveGradeForPlace(placeId,username,grade);
        } catch (Exception e) {
            result = false;
        }
        modelAndView.addObject("result",result);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    public ModelAndView getModelForPlace(Integer id, UserDetails userDetails) {
        ModelAndView modelAndView = new ModelAndView();
        Place place = placeDao.getPlaceById(id);
        if(userDetails==null) {
            modelAndView.addObject("grade",-1);
        } else {
            if (gradeDao.isGradedByUser(id,userDetails.getUsername())) {
                modelAndView.addObject("grade",gradeDao.getUserGradeForPlace(id,userDetails.getUsername()));
            } else {
                modelAndView.addObject("grade",0);
            }
        }

        modelAndView.addObject("place",place);
        modelAndView.setViewName("place");
        return modelAndView;
    }

}
