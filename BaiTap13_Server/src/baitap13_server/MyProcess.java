/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap13_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

/**
 *
 * @author Desktop
 */
public class MyProcess extends Thread{
    private Socket socket;

    public MyProcess(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                                          new InputStreamReader(
                                                  socket.getInputStream()
                                          )
                                      );
            
            PrintWriter writer = new PrintWriter(
                                        socket.getOutputStream()
                                    );
            
            Scanner sc = new Scanner(System.in);
            while(true){
                // Nhận tin nhắn
                String message;
                message=reader.readLine();
                System.out.println("Client: "+ message);
                
                // Gủi tin nhắn
                System.out.println("Server: ");
                message = sc.nextLine();
                writer.println(message);
                writer.flush();
            }
        } catch (Exception e) {
        }
    }
}
