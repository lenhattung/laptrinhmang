/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap10_quanlysachthuvien;

/**
 *
 * @author Desktop
 */
public class Student extends Thread{
    private long id;
    private Library lib;
    private String title;

    public Student(long id, Library lib, String title) {
        this.id = id;
        this.lib = lib;
        this.title = title;
    }

    @Override
    public void run() {
        try {
            for(int i=0; i<5; i++){
                lib.borrowBook(id, title);
                sleep((long)(Math.random()*1000));
                lib.returnBook(id, title);
            }
        } catch (Exception e) {
        }
    }
    
    
}
