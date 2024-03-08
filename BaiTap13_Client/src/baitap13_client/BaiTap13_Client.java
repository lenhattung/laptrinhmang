/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap13_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Desktop
 */
public class BaiTap13_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Kết nối tới server
            int port = 99;
            Socket socket = new Socket("localhost", port);
             BufferedReader reader = new BufferedReader(
                                          new InputStreamReader(
                                                  socket.getInputStream()
                                          )
                                      );
            
            PrintWriter writer = new PrintWriter(
                                        socket.getOutputStream()
                                    );
            
            Scanner sc = new Scanner(System.in);
            
            String message;
            // Chat
            while(true){
                 // Gủi tin nhắn
                System.out.println("Client: ");
                message = sc.nextLine();
                writer.println(message);
                writer.flush();
                // Nhận tin nhắn
                message=reader.readLine();
                System.out.println("Server: "+ message);
            }
            
        } catch (Exception e) {
            System.out.println("Không thể kết nối đến server");
        }
    }
    
}
