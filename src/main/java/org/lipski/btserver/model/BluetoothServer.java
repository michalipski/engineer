package org.lipski.btserver.model;

import org.lipski.place.model.Place;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bt_servers")
public class BluetoothServer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Integer id;

    @Column(name = "mac_address")
    String macAddress;

    @OneToMany(mappedBy = "bluetoothServer")
    List<Place> places;

    public BluetoothServer() {
    }

    public BluetoothServer(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
