/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap11;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Desktop
 */
public class ViduUrl2 {
    public static void main(String[] args) {
        String[] websites = {
            "https://titv.vn",
            "https://google.com",
            "https://vnexpress1.net"
        };
        
        for (String website : websites) {
            checkWebsite(website);
        }
    }
    
    public static void checkWebsite(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // http code: 200, 401, 403, 500, 404
            int responseCode = conn.getResponseCode();
            
            if(responseCode==200){
                System.out.println(urlString+": trang web hoạt động!");
            }else{
                System.out.println(urlString+": không hoạt động, mã code: " +responseCode);
            }
        } catch (Exception e) {
            System.out.println(urlString +": không thể kết nối !");
        }
    }
}
