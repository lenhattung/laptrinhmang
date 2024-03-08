/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap19_lightstick;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 *
 * @author Desktop
 */
public class LightControllerServer {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("230.0.0.3");
            MulticastSocket socket = new MulticastSocket();

            String[] colors = {"Red", "Green", "Blue"};
            int colorIndex = 0;

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Bạn muốn chọn màu nào:");
                System.out.println("0. Red");
                System.out.println("1. Green");
                System.out.println("2. Blue");
                
                colorIndex = scanner.nextInt();
               // scanner.nextLine();
                if(colorIndex>2 || colorIndex<0)
                    colorIndex=0;                
                
                String message = colors[colorIndex];
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, 9876);
                socket.send(sendPacket);

                Thread.sleep(5000); // Đợi một khoảng thời gian trước khi thay đổi màu đèn
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
