package com.mou.hmk.main;

import com.mou.hmk.book.Book;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class BookWarehouse {
    public static final HashMap<String, Book> books = new HashMap<String,Book>() {
    };

    public static void addBook(Book book){
        books.put(book.getBookName(),book);
    }

    /**
     * 搜索是否存在该键
     * @param bookName 需要检查的键
     * @return 存在即true
     */
    public static boolean searchBook(String bookName){
        return books.containsKey(bookName);
    }

    /**
     * 在使用getBook获取书时请使用searchBook()来检查书籍是否存在
     * @param bookName 书名
     * @return 书
     */
    public static Book getBook(String bookName){
        if(searchBook(bookName)){
            return books.get(bookName);
        }else{
            return null;
        }
    }

    /**
     * 在使用getBook删除书时请使用searchBook()来检查书籍是否存在
     * @param bookName 书名
     * @return 是否成功
     */
    public static boolean removeBook(String bookName){
        try {
            if (searchBook(bookName)) {
                return books.remove(bookName, getBook(bookName));
            } else {
                return false;
            }
        }catch (NullPointerException error){
            return false;
        }
    }
}
