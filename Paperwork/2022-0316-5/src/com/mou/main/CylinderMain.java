package com.mou.main;

import com.mou.base.Cylinder;

public class CylinderMain {
    public static void main(String[] args) {
        Cylinder y = new Cylinder();
        y.setInfo(3.33,4.12);
        System.out.println("体积是"+y.getVolume());
        System.out.println("表面积是"+y.getSurfaceArea());
    }
}
