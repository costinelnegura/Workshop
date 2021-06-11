package com.costinel.Workshop.jdbc.domain;

public class Claim {
    private int id;
    private String salutation;
    private String first_name;
    private String last_name;
    private String address;
    private String postcode;
    private int mobile_number;
    private String email;
    private String vehicle_make;
    private String vehicle_model;
    private String vehicle_registration;
    private String notes;

    public Claim() {
    }

    public Claim(String salutation, String first_name, String last_name, String address, String postcode,
                 int mobile_number, String email, String vehicle_make, String vehicle_model,
                 String vehicle_registration, String notes) {
        this.salutation = salutation;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.postcode = postcode;
        this.mobile_number = mobile_number;
        this.email = email;
        this.vehicle_make = vehicle_make;
        this.vehicle_model = vehicle_model;
        this.vehicle_registration = vehicle_registration;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicle_make() {
        return vehicle_make;
    }

    public void setVehicle_make(String vehicle_make) {
        this.vehicle_make = vehicle_make;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getVehicle_registration() {
        return vehicle_registration;
    }

    public void setVehicle_registration(String vehicle_registration) {
        this.vehicle_registration = vehicle_registration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", salutation='" + salutation + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", mobile_number=" + mobile_number +
                ", email='" + email + '\'' +
                ", vehicle_make='" + vehicle_make + '\'' +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", vehicle_registration='" + vehicle_registration + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
