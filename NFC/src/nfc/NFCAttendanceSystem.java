/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NFCAttendanceSystem extends JFrame {
    private JButton recordButton;
    private JTextArea logTextArea;

    public NFCAttendanceSystem() {
        super("NFC Attendance System");

        // Tạo giao diện Swing
        recordButton = new JButton("Record");
        logTextArea = new JTextArea(10, 30);
        logTextArea.setEditable(false);

        setLayout(new FlowLayout());
        add(recordButton);
        add(new JScrollPane(logTextArea));

        // Đăng ký sự kiện khi nhấn nút ghi
        recordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordAttendance();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void recordAttendance() {
        // Mô phỏng việc đọc dữ liệu từ thẻ NFC
        String nfcData = simulateReadNFC();

        // Ghi dữ liệu xuống file
        if (nfcData != null && !nfcData.isEmpty()) {
            String logEntry = generateLogEntry(nfcData);
            appendLogToFile(logEntry);
            logTextArea.append(logEntry + "\n");
        }
    }

    private String simulateReadNFC() {
        // Mô phỏng việc đọc dữ liệu từ thẻ NFC
        // Thay thế phần này với việc thực tế đọc thẻ NFC
        return "User123";
    }

    private String generateLogEntry(String nfcData) {
        // Tạo một mục log mới dựa trên dữ liệu từ thẻ NFC
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        return "[" + timestamp + "] NFC Tag: " + nfcData;
    }

    private void appendLogToFile(String logEntry) {
        // Ghi mục log vào file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("attendance.log", true));
            writer.write(logEntry);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NFCAttendanceSystem();
            }
        });
    }
}
