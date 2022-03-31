package com.mou.hmk.ui;

import com.mou.hmk.book.Book;
import com.mou.hmk.main.BookWarehouse;
import com.mou.hmk.util.StringHandle;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import static com.mou.hmk.util.StringHandle.cutString;

public class MainForm extends JFrame {
    public JPanel panel1;
    private JTextField author_input;
    private JButton confirmBtn;
    private JTextField bookName_input;
    private JTextField price_input;
    private JTextField publisher_input;
    private JTextField ISBN_input;
    private JList list1;
    private JButton readBtn;

    public String getList1Select(){
        if(!list1.getSelectedValue().toString().isEmpty()){
            return list1.getSelectedValue().toString();
        }else{
            JOptionPane.showMessageDialog(panel1,"所选书籍不存在","错误", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public MainForm(){
        DefaultListModel dlmIns = new DefaultListModel();


        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = bookName_input.getText();
                String author = author_input.getText();
                String price = price_input.getText();
                String publisher = publisher_input.getText();
                String ISBN = ISBN_input.getText();

                if(BookWarehouse.searchBook(bookName)){
                    JOptionPane.showMessageDialog(panel1,"重名！","错误", JOptionPane.ERROR_MESSAGE);
                }else{
                    if(bookName.isEmpty()||author.isEmpty()||publisher.isEmpty()){
                        JOptionPane.showMessageDialog(panel1,"你至少需要输入书名、作者和出版商这三类信息","错误", JOptionPane.ERROR_MESSAGE);
                    }else if(price!=null&&ISBN!=null){
                        Book outBook = new Book(bookName,ISBN, publisher, cutString(author, '/'),StringHandle.returnNumber(price));
                        BookWarehouse.addBook(outBook);
                        dlmIns.addElement(outBook.getBookName());
                        list1.setModel(dlmIns);
                    }
                }
            }
        });

        readBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame("Reader");
                String in = getList1Select();
                frame1.setContentPane(new BookForm(in).panel1);
                frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame1.pack();
                frame1.setVisible(true);

            }
        });
    }
}
