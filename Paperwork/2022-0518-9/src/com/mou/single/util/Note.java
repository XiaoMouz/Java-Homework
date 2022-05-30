package com.mou.single.util;

public class Note {
    private static Note note = null;
    private Note(){ System.out.println("懒汉式"); }
    public static Note getNote(){
        if(note==null){
            note = new Note();
        }
        return note; }
}
