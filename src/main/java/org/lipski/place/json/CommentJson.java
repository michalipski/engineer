package org.lipski.place.json;

import org.lipski.place.model.Comment;

import java.util.Date;

public class CommentJson {

    Integer id;
    Integer userId;
    Integer placeId;
    String description;
    Date date;

    public CommentJson() {
    }

    public CommentJson(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getAuthor().getId();
        this.placeId = comment.getPlace().getId();
        this.description = comment.getDescription();
        this.date = comment.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
