package com.mou.base;

public class Cylinder {
    private static double PI=3.1415;
    public double r;
    public double h;

    public double getSurfaceArea(){
        return 2*PI*r*r + 2*PI*r*h;
    }

    public double getVolume(){
        return PI*r*r*h;
    }

    public void setInfo(double r,double h){
        this.r = r;
        this.h = h;
    }
}
