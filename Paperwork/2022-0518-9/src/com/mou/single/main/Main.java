package com.mou.single.main;

import com.mou.single.util.Book;
import com.mou.single.util.Note;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        String[] bn = {"《1》","《2》","《3》","《4》","《5》"};
        String[] ISBN  ={"echo","alpha","bravo","nov","delta"};
        String[] author = {"i","you","lgbt","john","sun"};

        for(int i = 0;i<books.length;i++){
            books[i] = new Book(bn[i],ISBN[i],author[i],0,0,0);
        }

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }
}
