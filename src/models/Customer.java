package models;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private int age;
    private String address;
    private String id;
    private String phoneNumber;
    private String email;

    public Customer() {
    }

    public Customer(String name, int age, String address, String id, String phoneNumber, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Customer(String id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
