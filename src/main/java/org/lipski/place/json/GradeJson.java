package org.lipski.place.json;

import org.lipski.place.model.Grade;

import java.util.Date;

public class GradeJson {

    Integer id;
    Integer grade;
    Integer userId;
    Integer placeId;
    Date date;

    public GradeJson() {
    }

    public GradeJson(Grade grade) {
        this.id = grade.getId();
        this.grade = grade.getGrade();
        this.userId = grade.getAuthor().getId();
        this.placeId = grade.getPlace().getId();
        this.date = grade.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
