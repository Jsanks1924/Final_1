package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import java.io.Serializable;

public class Hospital implements Comparable<Hospital>, Serializable {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty address = new SimpleStringProperty("");
    private  SimpleStringProperty city = new SimpleStringProperty("");
    private  SimpleStringProperty state = new SimpleStringProperty("");
    private  SimpleStringProperty zip = new SimpleStringProperty("");
    private  SimpleStringProperty latitude = new SimpleStringProperty("");
    private  SimpleStringProperty longitude = new SimpleStringProperty("");
    private  SimpleStringProperty phone = new SimpleStringProperty("");
    private  SimpleStringProperty photo = new SimpleStringProperty("");

    public String getPhoto() {
        return photo.get();
    }

    public SimpleStringProperty photoProperty() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo.set(photo);
    }




    public Hospital(String name, String address, String city, String state, String zip,
                    String latitude, String longitude,String phone, String photo) {
        setName(name);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setLatitude(latitude);
        setLongitude(longitude);
        setPhone(phone);
        setPhoto(photo);
    }

    public Hospital(String latitude, String longitude) {
        this.name = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.state = new SimpleStringProperty("");
        this.zip = new SimpleStringProperty("");
        this.latitude = new SimpleStringProperty(latitude);
        this.longitude = new SimpleStringProperty(longitude);
        this.phone = new SimpleStringProperty("");
        this.photo = new SimpleStringProperty("");
    }

    public Hospital() {
        this(" ", " ", " ", " ", " ", " ", " ", " ","");
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getZip() {
        return zip.get();
    }

    public SimpleStringProperty zipProperty() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip.set(zip);
    }

    public String getLatitude() {
        return latitude.get();
    }

    public SimpleStringProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }

    public String getLongitude() {
        return longitude.get();
    }

    public SimpleStringProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }


    @Override
    public String toString() {
        return "Hospital{" +
                "name=" + name +
                ", address=" + address +
                ", city=" + city +
                ", state=" + state +
                ", zip=" + zip +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", phone=" + phone +
                ", photo=" + photo +
                '}';
    }

    @Override
    public int compareTo(Hospital o) {

        int compare = this.latitude.get().compareTo(o.getLatitude());
        return (compare == 0) ? this.longitude.get().compareTo(o.getLongitude()) : compare;
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }


}

