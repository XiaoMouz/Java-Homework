package com.mou.lambda;

import java.text.Collator;
import java.util.*;

public class BookSort {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Collections.addAll(books,new Book("《穆斯林的葬礼》","霍达",1059),
                new Book("《目送》","龙应台",949),
                new Book("《傲慢与偏见》","简·奥斯丁",794),
                new Book("《致加西亚的信》","阿尔伯特·哈伯德",696),
                new Book("《时间简史》","史蒂芬·霍金",8964)
                );

        System.out.println("按书籍名称升序:");
        Collections.sort(books,(s1,s2)-> Collator.getInstance(Locale.CHINESE).compare(s1.getName(),s2.getName()));
        books.forEach(System.out::println);

        System.out.println("按作者名称升序:");
        Collections.sort(books,(s1,s2)-> Collator.getInstance(Locale.CHINESE).compare(s1.getAuthor(),s2.getAuthor()));
        books.forEach(System.out::println);

        System.out.println("按页数升序:");
        Collections.sort(books, Comparator.comparingInt(Book::getPages));
        books.forEach(System.out::println);
    }
}

class Book{
    private String name;
    private String author;
    private int pages;

    public Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "书名:"+this.name+"|作者:"+this.author+"|页数:"+this.pages;
    }
}