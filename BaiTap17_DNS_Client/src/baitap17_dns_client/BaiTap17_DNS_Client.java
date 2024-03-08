/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap17_dns_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Desktop
 */
public class BaiTap17_DNS_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPost = 9876;
            
            Scanner scanner = new Scanner(System.in);
            
            while(true){
                System.out.println("Nhập vào tên miền cần tìm IP:");
                String domainName = scanner.nextLine();
                
                // Gửi truy vấn
                byte[] sendData = domainName.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPost);
                socket.send(sendPacket);
                
                // Nhận phản hồi
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                
                // Xuất kết quả
                String ip = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("IP: " + ip);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
