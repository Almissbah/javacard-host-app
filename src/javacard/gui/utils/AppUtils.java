/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacard.gui.utils;

/**
 *
 * @author mohamed
 */
public class AppUtils {
    
     public static String atrToHex(byte atCode) {
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String str2 = "";
        int num = atCode & 0xff;
        int rem;
        while (num > 0) {
            rem = num % 16;
            str2 = hex[rem] + str2;
            num = num / 16;
        }
        if (!"".equals(str2)) {
            return str2;
        } else {
            return "0";
        }
    }
    
}
