package org.lipski.place.json;

import org.lipski.place.model.Grade;

import java.util.Date;

public class GradeJson {

    Integer id;
    Integer grade;
    Integer userId;
    Integer placeId;
    Date date;

    public GradeJson(Grade grade) {
        this.id = grade.getId();
        this.grade = grade.getGrade();
        this.userId = grade.getAuthor().getId();
        this.placeId = grade.getPlace().getId();
        this.date = grade.getDate();
    }
}
