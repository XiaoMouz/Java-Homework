package com.mou.hmk.ui;

import com.mou.hmk.book.Book;
import com.mou.hmk.book.BookDataHandle;
import com.mou.hmk.main.AppMain;
import com.mou.hmk.main.BookWarehouse;

import javax.swing.*;
import java.awt.*;

public class BookForm extends JFrame {
    public JPanel panel1;
    private JLabel bookInfo;
    private JButton markBtn;
    private JButton deleteBtn;
    private JLabel bookISBN;
    private JLabel bookName;
    private JTextArea textArea1;
    protected String needReadBookName;

    public BookForm(String name){
        this.needReadBookName = name;
        refreshInfo();
    }

    public void refreshInfo(){
        if(BookWarehouse.searchBook(needReadBookName)) {
            Book takeBook = BookWarehouse.getBook(needReadBookName);
            this.bookName.setText(takeBook.getBookName());
            this.bookISBN.setText(takeBook.getISBN());
            StringBuilder takeBook_info = new StringBuilder();
            BookDataHandle.getAllAuthor(takeBook);
            try {
                assert false;
                takeBook_info.append("作者:").append(BookDataHandle.getAllAuthor(takeBook));
                takeBook_info.append("\t|出版商:").append(takeBook.getPublisher());
                takeBook_info.append("\t|价格:").append(takeBook.getPrice());
                this.bookInfo.setText(takeBook_info.toString());

            } catch (NullPointerException error) {

            }
        }else{
            JOptionPane.showMessageDialog(panel1,"你妈妈的","错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
