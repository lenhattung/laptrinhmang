/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap8_producer_cosnumer;

/**
 *
 * @author Desktop
 */
public class BaiTap8_Producer_Cónumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Buffer buffer = new Buffer(5);
       Producer p1 = new Producer(1, buffer);
       Producer p2 = new Producer(2, buffer);
       Producer p3 = new Producer(3, buffer);
       
       Consumer c1 = new Consumer(1, buffer);
       Consumer c2 = new Consumer(2, buffer);
       Consumer c3 = new Consumer(3, buffer);
       Consumer c4 = new Consumer(4, buffer);
       Consumer c5 = new Consumer(5, buffer);
       // bắt đầu sản xuất
       p1.start();
       p2.start();
       p3.start();
       // bắt đầu mua hàng
       c1.start();
       c2.start();
       c3.start();
       c4.start();
       c5.start();
    }
    
}
