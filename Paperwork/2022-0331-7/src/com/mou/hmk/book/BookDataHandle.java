package com.mou.hmk.book;

public class BookDataHandle {
    /**
     * 检查此书是否有信息
     * @param book 需要检查的书
     * @return 0为无信息，1为有基础信息，2为有完整信息
     */
    protected static int bookInfoState(Book book){
        if(book.getBookName()==null&&book.getAuthor()==null&&book.getPublisher()==null){
            return 0;
        }else if(book.getBookName()!=null&&book.getAuthor()!=null&&book.getPublisher()!=null&book.getISBN()==null){
            return 1;
        }else if(book.getBookName()!=null&&book.getAuthor()!=null&&book.getPublisher()!=null&&book.getISBN()!=null){
            return 2;
        }else{
            return 0;
        }
    }
    public static String getAllAuthor(Book book){
        if(book.getAuthor()==null){
            return "无作者";
        }
        StringBuilder authorSB = new StringBuilder();
        String[] author = book.getAuthor();
        for(int i = 0;i<book.author.length;i++){
            if(i<book.author.length-1){
                authorSB.append(author[i]).append("/");
            }else{
                authorSB.append(author[i]);
            }
        }
        return authorSB.toString();
    }
}
