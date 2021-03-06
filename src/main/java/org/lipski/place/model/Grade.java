package org.lipski.place.model;

import org.lipski.users.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "grades")
public class Grade implements Serializable{

    @Id
    @Column(name = "grade_id")
    Integer id;

    @Column(name = "grade")
    Integer grade;

    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    Place place;

    @Column(name = "date")
    Date date;

    @Column(name = "changed")
    Boolean changed;

    public Grade() {
    }

    public Grade(Integer grade, User author, Date date, Place place, Boolean changed) {
        this.grade = grade;
        this.author = author;
        this.date = date;
        this.place = place;
        this.changed = changed;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Boolean getChanged() {
        return changed;
    }

    public void setChanged(Boolean changed) {
        this.changed = changed;
    }
}
