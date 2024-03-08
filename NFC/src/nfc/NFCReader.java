/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfc;

import java.util.List;
import javax.smartcardio.*;

public class NFCReader {

    public static void main(String[] args) {
        TerminalFactory terminalFactory = TerminalFactory.getDefault();
        try {
            CardTerminals cardTerminals = terminalFactory.terminals();
            List<CardTerminal> terminals = cardTerminals.list();
            if (terminals.isEmpty()) {
                System.out.println("Không tìm thấy thiết bị NFC.");
                return;
            }
            System.out.println("Danh sách thiết bị NFC có sẵn:");
            for (int i = 0; i < terminals.size(); i++) {
                System.out.println((i + 1) + ": " + terminals.get(i).getName());
            }
            CardTerminal terminal = terminals.get(0); // Chọn thiết bị đầu tiên trong danh sách
            Card card = terminal.connect("*");
            System.out.println("Đã kết nối với thiết bị: " + terminal.getName());
            CardChannel channel = card.getBasicChannel();

            // Đọc dữ liệu từ NFC
//            CommandAPDU command = new CommandAPDU(new byte[]{0xFF, 0xCA, 0x00, 0x00, 0x00});
//            ResponseAPDU response = channel.transmit(command);
//            byte[] data = response.getData();
//
//            // Xử lý dữ liệu đọc được
//            System.out.println("Dữ liệu từ NFC: " + bytesToHex(data));

            card.disconnect(true);
        } catch (CardException e) {
            e.printStackTrace();
        }
    }

    // Chuyển đổi mảng byte thành chuỗi hex để hiển thị
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
}