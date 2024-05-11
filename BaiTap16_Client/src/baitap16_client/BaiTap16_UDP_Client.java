/*
 * Chương trình này triển khai một client UDP đơn giản để gửi tin nhắn tới server UDP.
 */
package baitap16_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BaiTap16_UDP_Client {

    /**
     * Phương thức main là điểm bắt đầu của chương trình.
     * @param args Đối số dòng lệnh (không được sử dụng trong chương trình này).
     */
    public static void main(String[] args) {
         try {
            // Tạo một socket UDP
            DatagramSocket socket = new DatagramSocket();
            // Xác định địa chỉ và cổng của server
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9877;
            
            int i = 0;
            while(true){
                // Tạo message
                String message = "Hello, UDP Server + " +i ;
                // Chuyển message thành dạng mảng byte
                byte[] senData = message.getBytes();

                // Tạo DatagramPacket để gửi dữ liệu tới server
                DatagramPacket sendPacket = new DatagramPacket(senData, senData.length, serverAddress, serverPort);
                // Gửi gói tin đi
                socket.send(sendPacket);
                
                // Tăng biến đếm
                i++;
            }
            // Đóng socket nếu cần thiết
            //socket.close();
        } catch (Exception e) {
            // In ra lỗi nếu có exception xảy ra
            e.printStackTrace();;
        }
    }
    
}
