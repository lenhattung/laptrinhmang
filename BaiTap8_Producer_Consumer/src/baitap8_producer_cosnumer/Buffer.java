/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap8_producer_cosnumer;

import java.util.ArrayList;

/**
 *
 * @author Desktop
 */
public class Buffer {
    // Khả năng chứa tối đa    
    private int capacity;
    // Danh sách sản phẩm
    private ArrayList<Integer> products = new ArrayList<>();

    public Buffer(int capacity) {
        this.capacity = capacity;
        products = new ArrayList<>();
    }
    
    public void addProduct(int product, int producerId){
        System.out.println(">>>>--------------------------------------------------------");
        System.out.println("Nhà sản xuất " + producerId + " đã thêm sản phẩm "+product);
        products.add(product);
        System.out.println("Số lượng tồn kho: " + products.size());
    }
    
    
    public void removeProduct(int consumerId){
        System.out.println("<<<<-------------------------------------------------------");
        System.out.println("Khác hàng " + consumerId +" đã mua sản phẩm "+products.get(0));
        products.remove(0);
        System.out.println("Số lượng tồn kho: " + products.size());
    }
    
    public int getSize(){
        return this.products.size();
    }

    public int getCapacity() {
        return capacity;
    }
    
    
}
