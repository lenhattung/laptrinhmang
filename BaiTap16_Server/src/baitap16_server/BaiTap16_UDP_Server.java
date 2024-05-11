/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap16_server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * Chương trình này triển khai một máy chủ UDP đơn giản.
 */
package baitap16_server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BaiTap16_UDP_Server {

    /**
     * Phương thức main là điểm bắt đầu của chương trình.
     * @param args Đối số dòng lệnh (không được sử dụng trong chương trình này).
     */
    public static void main(String[] args) {
        try {
            // Tạo một socket UDP lắng nghe trên cổng 9877
            DatagramSocket socket = new DatagramSocket(9877);
            
            byte[] receiveData = new byte[1024];
            
            while(true){
                // Tạo một DatagramPacket để nhận dữ liệu
                DatagramPacket recivePacket = new DatagramPacket(receiveData, receiveData.length);
                // Nhận một gói tin
                socket.receive(recivePacket);
                
                // Chuyển dữ liệu nhận được thành chuỗi và in ra màn hình
                String receiveMessage = new String(recivePacket.getData(), 0, recivePacket.getLength());
                
                // Kiểm tra xem có dữ liệu nhận được không trước khi in ra
                if(receiveMessage.trim().length()>0)
                    System.out.println("receiveMessage: " + receiveMessage);
            }
            // Đóng socket nếu cần thiết
            //socket.close();
        } catch (Exception e) {
            // In ra lỗi nếu có exception xảy ra
            e.printStackTrace();;
        }
    }
    
}
