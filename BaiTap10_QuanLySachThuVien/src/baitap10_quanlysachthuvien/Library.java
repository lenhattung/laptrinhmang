/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap10_quanlysachthuvien;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desktop
 */
public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }
    
    public  /* synchronized */ void addBook(Book book){
        books.add(book);
        System.out.println("*** Đã thêm quyển sách: "  + book.getTitle());
    }
    
    public synchronized void borrowBook(long id, String title){
        for (Book book : books) {
            if(book.getTitle().equals(title)){
                if(book.isAvailable()){
                    book.setAvailable(false);
                    System.out.println(id+" : " + "<<< Đã cho mượn sách :" + title);
                    return;
                }
            }
        }
        System.out.println("--- Không thể cho mượn sách :" + title);
    }
    
    
    public synchronized void returnBook(long id, String title){
        for (Book book : books) {
            if(book.getTitle().equals(title)){
                if(!book.isAvailable()){
                    book.setAvailable(true);
                    System.out.println(id+" : " +">>> Đã trả sách :" + title);
                    return;
                }
            }
        }
        System.out.println("--- Không thể trả sách :" + title);
    }
    
    public /* synchronized */ void displayBooks(){
        System.out.println("Library books: ");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
