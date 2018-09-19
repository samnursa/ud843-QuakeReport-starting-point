package com.example.android.quakereport;

public class Earthquake {
    private double mMagnitude;
    private String mCity;
    private String mDate;
    private String mTime;

    public Earthquake(String city, double magnitude, String date, String time){
        mMagnitude = magnitude;
        mCity = city;
        mDate = date;
        mTime = time;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmCity() {
        return mCity;
    }

    public double getmMagnivy() {
        return mMagnitude;
    }

    public String getmTime() {
        return mTime;
    }
}
