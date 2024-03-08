/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap13_server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Desktop
 */
public class BaiTap13_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Tạo server socket và lắng nghe
            int port = 99;
            ServerSocket serverSocket = new ServerSocket(port);
            
            // Chấp nhận nhiều kết nối
            while(true){
                // Chấp nhận kết nối từ 1 Client
                Socket clientSocket = serverSocket.accept();
                MyProcess mp = new MyProcess(clientSocket);
                mp.start();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
