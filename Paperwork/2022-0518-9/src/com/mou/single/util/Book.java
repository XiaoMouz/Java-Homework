package com.mou.single.util;

public class Book {
    public Book(){}

    public Book(String name, String ISBN, String author, int reader, int subscribe,int pages) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.reader = reader;
        this.subscribe = subscribe;
        this.pages = pages;
    }

    private String name;
    private String ISBN;
    private String author;
    private int reader;
    private int subscribe;
    private int pages;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getReader() {
        return reader;
    }
    public void setReader(int reader) {
        this.reader = reader;
    }
    public int getSubscribe() {
        return subscribe;
    }
    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }
    public int getPages() { return pages; };
    public void setPages(int pages){this.pages = pages;}

    public void addReader(){
        reader++;
    }
    public void addSubscribe(){
        subscribe++;
    }

    @Override
    public String toString() {
        return  "书名:" + name + "\t\t" +
                "ISBN:'" + ISBN + "\t\t" +
                "author:" + author + "\t\t" +
                "reader:" + reader + "\t\t" +
                "subscribe:" + subscribe + "\t\t"+
                "pages:" + pages ;
    }
}
