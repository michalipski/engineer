package org.lipski.place.model;

import org.lipski.btserver.model.BluetoothServer;
import org.lipski.event.model.Event;
import org.lipski.place.json.PlaceJson;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "places")
public class Place implements Serializable{

    @Id
    @Column(name = "place_id", nullable = false)
    Integer id;

    @Column(name = "name", nullable = false, length = 45)
    String name;

    @Column(name = "address", nullable = false, length = 60)
    String address;

    @Column(name = "city", nullable = false, length = 45)
    String city;

    @Column(name = "description")
    String description;

    @Column(name = "phone", length = 9)
    Integer phone;

    @DateTimeFormat(pattern = "HH:mm", iso = DateTimeFormat.ISO.TIME)
    @Column(name = "open_hour")
    Date openHour;

    @DateTimeFormat(pattern = "HH:mm", iso = DateTimeFormat.ISO.TIME)
    @Column(name = "close_hour")
    Date closeHour;

    @OneToMany(mappedBy = "place")
    List<Comment> comments;

    @OneToMany(mappedBy = "place")
    List<Grade> grades;

    @OneToMany(mappedBy = "place")
    List<Event> events;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "server_id", nullable = false)
    BluetoothServer bluetoothServer;

    @Column(name = "changed")
    Boolean changed;

    public Place() {
    }

    public Place(String name, String address, String city, String description, Integer phone, Date openHour, Date closeHour, Boolean changed) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.description = description;
        this.phone = phone;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.changed = changed;
        this.comments = new ArrayList<>();
        this.grades = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public static Place getPlaceForBluetoothCommunication(Place place, ArrayList<Comment> comments) {
        Place placeClone = new Place();
        placeClone.setId(place.getId());
        placeClone.setName(place.getName());
        placeClone.setAddress(place.getAddress());
        placeClone.setCity(place.getCity());
        placeClone.setDescription(place.getDescription());
        placeClone.setPhone(place.getPhone());
        placeClone.setOpenHour(place.getOpenHour());
        placeClone.setCloseHour(place.getCloseHour());
        placeClone.setComments(comments);

        return placeClone;
    }

    public static PlaceJson getJsonPlace(Place place) {
        return new PlaceJson(place);
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

    public Date getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Date openHour) {
        this.openHour = openHour;
    }

    public Date getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Date closeHour) {
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public BluetoothServer getBluetoothServer() {
        return bluetoothServer;
    }

    public void setBluetoothServer(BluetoothServer bluetoothServer) {
        this.bluetoothServer = bluetoothServer;
    }

    public Boolean getChanged() {
        return changed;
    }

    public void setChanged(Boolean changed) {
        this.changed = changed;
    }
}
