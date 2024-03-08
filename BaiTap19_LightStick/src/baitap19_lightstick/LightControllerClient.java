/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap19_lightstick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Desktop
 */
public class LightControllerClient {
     public static void main(String[] args) {
            LightControllerGUI gui = new LightControllerGUI();
            gui.createAndShowGUI();
    }
}

class LightControllerGUI {
    private JLabel lightLabel;
    private JPanel mainPanel;
    
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Light Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        lightLabel = new JLabel("Light Status: ");
        lightLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(lightLabel, BorderLayout.CENTER);
        
        frame.setMinimumSize(new Dimension(200, 100));
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        
        startListening();
    }
    
    private void startListening() {
        try {
            InetAddress group = InetAddress.getByName("230.0.0.3");
            MulticastSocket socket = new MulticastSocket(9876);
            socket.joinGroup(group);
            
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(receivedMessage);
                updateLightStatus(receivedMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void updateLightStatus(String color) {
        if (color.equals("Red")) {
            mainPanel.setBackground(Color.RED);
            System.out.println("OK1");
        } else if (color.equals("Green")) {
            mainPanel.setBackground(Color.GREEN);
            System.out.println("OK2");
        } else if (color.equals("Blue")) {
            mainPanel.setBackground(Color.BLUE);
            System.out.println("OK3");
        }
        lightLabel.setText("Light Status: " + color);
        mainPanel.revalidate(); // Cập nhật lại giao diện panel
    }
}