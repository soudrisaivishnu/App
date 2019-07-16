package com.example.apartmentmanager;

public class Details {
String username;
String password;
String emailid;
String phoneNo;
String address;

    public Details(String username, String password, String emailid, String phoneNo, String address) {
        this.username = username;
        this.password = password;
        this.emailid = emailid;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
