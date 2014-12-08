package org.lipski.place.model;

import org.lipski.users.model.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comments", catalog = "engineerdb")
public class Comment {

    Integer id;
    User author;
    Place place;
    String description;
    Date date;

    public Comment() {
    }

    public Comment(User author, Place place, String description, Date date) {
        this.author = author;
        this.place = place;
        this.description = description;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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
