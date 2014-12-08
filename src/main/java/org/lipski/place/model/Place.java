package org.lipski.place.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "places", catalog = "engineerdb")
public class Place {

    Integer id;
    String name;
    String address;
    String city;
    String description;
    Integer phone;
    Time openHour;
    Time closeHour;
    List<Comment> comments;
    List<Grade> grades;

    public Place() {
    }

    public Place(String name, String address, String city, String description, Integer phone, Time openHour, Time closeHour) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.description = description;
        this.phone = phone;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.comments = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Time getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Time openHour) {
        this.openHour = openHour;
    }

    public Time getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Time closeHour) {
        this.closeHour = closeHour;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
