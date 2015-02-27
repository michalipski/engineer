package org.lipski.web.json;

import com.google.gson.Gson;
import org.lipski.event.json.EventJson;
import org.lipski.place.json.CommentJson;
import org.lipski.place.json.GradeJson;
import org.lipski.place.json.PlaceJson;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjectConverter {

    Gson gson = new Gson();

    public String getCommentListJson(List<CommentJson> commentList) {
        return gson.toJson(commentList);
    }

    public String getPlaceListJson(List<PlaceJson> placeList) {
        return gson.toJson(placeList);
    }

    public String getGradeListJson(List<GradeJson> gradeList) {
        return gson.toJson(gradeList);
    }

    public String getEventListJson(List<EventJson> eventList) {
        return  gson.toJson(eventList);
    }
}
