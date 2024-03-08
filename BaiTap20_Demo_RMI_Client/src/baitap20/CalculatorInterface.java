/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap20;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Desktop
 */
public interface CalculatorInterface extends Remote {
    public double add(double a, double b) throws RemoteException;
    public double subtract(double a, double b) throws RemoteException;
    public double multiply(double a, double b) throws RemoteException;
    public double divide(double a, double b) throws RemoteException;
}
