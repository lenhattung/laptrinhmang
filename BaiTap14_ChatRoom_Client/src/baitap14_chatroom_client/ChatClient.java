/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap14_chatroom_client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Desktop
 */
public class ChatClient {
    private static final String URL = "localhost";
    private static final int PORT = 5000;
    
    
    public void startClient(){
        try {
            Socket socket = new Socket(URL, PORT );
            System.out.println("Connected to server");
            
            // Liên tục đọc dữ liệu từ server
            ClientListener client = new ClientListener(socket);
            new Thread(client).start();
            
            // Liên tục đọc dữ liệu từ scanner
            OutputStream output= socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            while(true){
                String message = sc.nextLine();
                output.write(message.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
}
