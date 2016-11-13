/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipproject.java;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akhil
 */
 public class Utils {
    public static String URL = "jdbc:mysql://127.0.0.1:3306/ipproject";
    public static String USER = "akhil";
    public static String PASSWORD = "cool stuff";
 
    
    /**
     * 
     * @param s : String to be encrypted
     * @return Encrypted String
     * Based on the length an offset is chosen
     * and all chars in the String shifted by that offset
     */
    public static String encrypt(String s)
    {
        String n = s;
        s = "";
        int o = (int)Math.ceil(Math.random()*5);
        int offset = o*n.length();
        for (int i = 0;i<n.length();i++)
        {
            char c = n.charAt(i);
            c += offset;
            s += c;            
        }
        CreateAccountForm.offset = o;
        return s;
    }
    
    /**
     * 
     * @param s String to be decrypted
     * @param offset Integer containing value String is off original
     * @return String returned to its original value
     */
    public static String decrypt(String s,int offset)
    {
        String n = s;
        s = "";
        int o = offset*n.length();
        for (int i = 0;i<n.length();i++)
        {
            char c = n.charAt(i);
            c -= o;
            s += c;
        }
        return s;
    }
    
    /**
     * 
     * @param table The JTable who's contents are to be cleared
     */
    public static void clearTable(JTable table)
    {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        while (tableModel.getRowCount()>0)
        {
            tableModel.removeRow(0);
        }
    }
}
