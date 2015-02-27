package org.lipski.place.json;

import org.lipski.place.model.Comment;

import java.util.Date;

public class CommentJson {

    Integer id;
    Integer userId;
    Integer placeId;
    String description;
    Date date;

    public CommentJson(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getAuthor().getId();
        this.placeId = comment.getPlace().getId();
        this.description = comment.getDescription();
        this.date = comment.getDate();
    }
}
