/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipproject.java;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author akhil
 */
 public class Utils {
    public static final String PORT = "3306";
    public static final String DB = "nrkdb";
    public static final String HOST = "localhost";
    public static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DB;
    public static final String USER = "akhil";
    public static final String PASSWORD = "cool stuff";
    public static final boolean DEBUG = false;
    
    /**
     * 
     * @param s String to be encrypted
     * @return Encrypted String
     * Based on the length an offset is chosen
     * and all chars in the String shifted by that offset
     * @deprecated 
     */
    public static String oldEncrypt(String s)
    {
        String n = s;
        s = "";
        int o = (int)Math.ceil(Math.random()*5);
        s = oldEncrypt(n,o);
        CreateAccountForm.offset = o;
        return s;
    }
    
    /**
     * 
     * @param s String to be encrypted
     * @param o offset to encrypt by
     * @return encrypted String
     * @deprecated 
     */
    public static String oldEncrypt(String s, int o)
    {
        String n = s;
        s = "";
        int offset = o*n.length();
        for (int i = 0;i<n.length();i++)
        {
            char c = n.charAt(i);
            c += offset;
            s += c;            
        }
        return s;
    }
    
    /**
     * 
     * @param s String to be decrypted
     * @param offset Integer containing value String is off original
     * @return String returned to its original value
     * @deprecated 
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
    
    public static String encrypt(String s)
    {
        String n = "";
        int l = s.length();
        for (int i=0;i<l;i++)
        {
            char c = s.charAt(i);
            int t = (int)c;
            t = t ^ l;
            c = (char)(t);
            n += c;
        }
        return n;
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
    
    /**
     * 
     * @param e Exception who's StackTrace/message is to be displayed
     */
    public static void displayError(Exception e)
    {
        if (DEBUG)
        {
            e.printStackTrace();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error Occurred: "+e.getMessage());
        }
    }
    
    public static void showPassword(JPasswordField pf, JCheckBox cb)
    {
        if (cb.isSelected())
        {
            pf.setEchoChar('\u0000');
        }
        else
        {
            pf.setEchoChar('*');
        }
    }
}
