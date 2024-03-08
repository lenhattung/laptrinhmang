/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap9;

/**
 *
 * @author Desktop
 */
public class Counter {
    
    // Đồng bộ: tại một thời điểm, chỉ có 1 thread được tương tác với giá trị
    
    private int count = 0;
    
    // synchronized: đồng bộ, tại một thời điểm chỉ có 1 thread gọi
    public synchronized void increament(){
        count++;
    }

    public int getCount() {
        return count;
    }
    
    
}
