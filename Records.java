package com.example.milagecalculator;

public class Records {

    public float distance;
    public float petrol;
    public float mileage;

    public Records(float distance, float petrol, float mileage) {
        this.distance = distance;
        this.petrol = petrol;
        this.mileage = mileage;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getPetrol() {
        return petrol;
    }

    public void setPetrol(float petrol) {
        this.petrol = petrol;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }
}
