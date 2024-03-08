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
public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorInterface calculator = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculator", calculator);
            while(true){
                System.out.println("Server is running ... ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
