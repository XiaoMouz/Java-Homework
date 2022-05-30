package com.mou.test.main;

public class StringFlipContrast {
    public static void main(String[] args) {
        String rdStr = "";
        if (rdStr.equals(new StringBuilder(rdStr).reverse().toString())) {
            System.out.println("s");
        } else {
            System.out.println("f");
        }
    }
}
