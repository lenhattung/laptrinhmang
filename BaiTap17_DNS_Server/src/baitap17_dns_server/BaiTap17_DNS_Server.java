/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap17_dns_server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Desktop
 */
public class BaiTap17_DNS_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            System.out.println("DNS Server is running ... ");
            
            // Giả lập một bảng định danh
            String [][] dnsTable = {
                {"www.example.com", "192.168.1.100"},
                {"www.google.com", "8.8.8.8"},
                {"www.titv.vn", "31.13.65.36"}                
            };
            
            while(true){
                // Tạo và nhận packet
                byte[] receiveData=new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                // Truy vấn IP từ domainName
                String domainName  = new String(receivePacket.getData(), 0, receivePacket.getLength());
                domainName = domainName.trim();
                domainName = domainName.toLowerCase();
                
                String response = "Not found";
                
                for (String[] entry : dnsTable) {
                    if(entry[0].equals(domainName)){
                        response = entry[1];
                        break;
                    }
                }
                
                // Phản hồi
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] responseData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
