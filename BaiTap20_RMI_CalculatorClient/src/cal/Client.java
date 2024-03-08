/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
/**
 *
 * @author Desktop
 */
public class Client {
    public static void main(String[] args) {
        try {
            // Lấy thanh ghi dựa trên IP và Port của máy chủ
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Lấy ra Object
            CalculatorInterface calStub=(CalculatorInterface)registry.lookup("Calculator");
            
            // Thực thi
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Chọn phép tính: ");
                System.out.println("1. +");
                System.out.println("2. -");
                System.out.println("3. *");
                System.out.println("4. /");
                int ch = scanner.nextInt();
                System.out.println("Nhập a: ");
                double a = scanner.nextDouble();
                System.out.println("Nhập b: ");
                double b = scanner.nextDouble();
                
                double result = 0;
                
                switch (ch) {
                    case 1:
                            result = calStub.add(a, b);
                            break;
                    case 2:
                            result = calStub.subtract(a, b);
                            break;
                    case 3:
                            result = calStub.multiply(a, b);
                            break;
                    case 4:
                            result = calStub.divide(a, b);
                            break;
                    default:
                        throw new AssertionError();
                }
                
                System.out.println("Result: " + result);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
