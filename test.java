/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author karanraj
 */
public class test {
    public static void main(String[] args) {
        
        String timeStamp = new SimpleDateFormat("dd_MM_YYYY").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }
    
}
