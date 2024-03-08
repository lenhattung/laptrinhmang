/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap20;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author Desktop
 */
public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            CalculatorInterface cal = (CalculatorInterface)registry.lookup("Calculator");
            double result = cal.multiply(5, 10);
            System.out.println("Result: "+result);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
