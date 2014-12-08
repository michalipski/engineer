package org.lipski.place.model;

import org.lipski.users.model.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "grades", catalog = "engineerdb")
public class Grade {

    Integer id;
    Integer grade;
    User author;
    Date date;

    public Grade() {
    }

    public Grade(Integer grade, User author, Date date) {
        this.grade = grade;
        this.author = author;
        this.date = date;
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
}
