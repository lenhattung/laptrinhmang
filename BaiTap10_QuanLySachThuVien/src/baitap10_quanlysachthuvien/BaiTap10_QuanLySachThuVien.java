/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap10_quanlysachthuvien;

/**
 *
 * @author Desktop
 */
public class BaiTap10_QuanLySachThuVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library lib = new Library();
        
        lib.addBook(new Book("Lập trình Java", "Lê Nhật Tùng"));
        lib.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        lib.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        lib.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        lib.addBook(new Book("Pride and Prejudice", "Jane Austen"));
        
        // print
        lib.displayBooks();
        
        // Mượn và trả sách
        // lib.borrowBook("Lập trình Java");
        // lib.borrowBook("Lập trình Java");
        // lib.borrowBook("Pride and Prejudice");
        // lib.returnBook("Lập trình Java");
        // lib.borrowBook("Lập trình Java");
        
        Thread st1 = new Student(1, lib, "Lập trình Java");
        Thread st2 = new Student(2, lib, "Lập trình Java");
        Thread st3 = new Student(3, lib, "Harry Potter and the Sorcerer's Stone");
        Thread st4 = new Student(4, lib, "Harry Potter and the Sorcerer's Stone");
        
        st1.start();
        st2.start();
        st3.start();
        st4.start();
        
        
    }
    
}
