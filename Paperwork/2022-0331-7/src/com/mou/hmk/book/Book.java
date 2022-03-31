package com.mou.hmk.book;

import java.util.Dictionary;

public class Book {
    public String bookName;
    public String ISBN;
    public String publisher;
    public String[] author;
    public double price = 0;
    public Dictionary<Integer,String> pages;

    public Book(String bookName, String ISBN, String publisher, String[] author, double price) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
    }

    /**
     * 空构造
     */
    public Book(){}

    /**
     * 完整信息初始化
     * @param bookName 书名
     * @param ISBN ISBN码
     * @param publisher 出版商
     * @param author 作者
     * @param price 价格
     * @param pages 页面
     */
    public Book(String bookName, String ISBN, String publisher, String[] author, double price, Dictionary<Integer, String> pages) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    /**
     * 基础初始化
     * @param bookName 书名
     * @param publisher 出版商
     * @param author 作者
     */
    public Book(String bookName, String publisher, String[] author){
        this.bookName = bookName;
        this.publisher = publisher;
        this.author = author;
    }





    public String getBookName() { return this.bookName; }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getISBN() {
        return this.ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String[] getAuthor() {
        return this.author;
    }
    public void setAuthor(String[] author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Dictionary<Integer, String> getPages() {
        return pages;
    }
    public void setPages(Dictionary<Integer, String> pages) {
        this.pages = pages;
    }
}
