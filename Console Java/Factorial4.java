/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_one;
import java.awt.BorderLayout;
import java.math.BigInteger; // импортируются пакеты math.Biginteger и пакеты
//java.util.*
import java.util.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
/**
 *
 * @author Ivan
 */
public class Factorial4 extends JFrame{
Factorial4(String s){
 super(s);

setSize(500,500);
setDefaultCloseOperation(EXIT_ON_CLOSE);
 JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());
 getContentPane().add(panel);
JButton mybtn = new JButton("My button");
panel.add(mybtn, BorderLayout.PAGE_START);
JButton southButton = new JButton("SOUTH (PAGE_END)");
          panel.add(southButton, BorderLayout.SOUTH);
          JButton eastButton = new JButton("EAST (LINE_START)");
          panel.add(eastButton, BorderLayout.EAST);
          JButton westButton = new JButton("WEST (LINE_END)");
          panel.add(westButton, BorderLayout.WEST);
setVisible(true);
}
//public static void main(String args[])
//{
//    SwingUtilities.invokeLater(new Runnable(){
//    public void run(){
//    new Factorial4("My program");
//    }
//    });
//  
//}
}
