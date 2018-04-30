/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_one;
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
public class Factorial2 extends JFrame{
    Factorial2(String s){
 super(s);

setSize(250,200);

setDefaultCloseOperation(EXIT_ON_CLOSE);
 JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if(source instanceof JButton) {
                    JButton button = (JButton) e.getSource();
                    float align = button.getAlignmentX();
                    String title = "";
                    if(align == JComponent.LEFT_ALIGNMENT) {
                        align = JComponent.CENTER_ALIGNMENT;
                        title = "CENTER_ALIGNMENT";
                    } else if (align == JComponent.CENTER_ALIGNMENT) {
                        align = JComponent.RIGHT_ALIGNMENT;
                        title = "RIGHT_ALIGNMENT";
                    } else {
                        align = JComponent.LEFT_ALIGNMENT;
                        title = "LEFT_ALIGNMENT";
                    }
                    button.setAlignmentX(align);
                    button.setText(title);
                }                                               
            }           
        };
Font font = new Font("Verdana", Font.PLAIN, 11);
 
        JButton button1 = new JButton("LEFT_ALIGNMENT");
        panel.add(button1);
        button1.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        button1.setMaximumSize(new Dimension(160, 100));
        button1.addActionListener(listener);
        button1.setFocusable(false);
        button1.setFont(font);
 
        JButton button2 = new JButton("LEFT_ALIGNMENT");
        panel.add(button2);
        button2.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        button2.setMaximumSize(new Dimension(200, 100));
        button2.addActionListener(listener);
        button2.setFocusable(false);
        button2.setFont(font);
 
        JButton button3 = new JButton("LEFT_ALIGNMENT");
        panel.add(button3);
        button3.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        button3.setMaximumSize(new Dimension(250, 100));
        button3.addActionListener(listener);
        button3.setFocusable(false);
        button3.setFont(font);
         
      getContentPane().add(panel);
setVisible(true);
    }
//    public static void main(String args[]){
//    SwingUtilities.invokeLater(new Runnable(){
//    public void run(){
//    new Factorial2("My program");
//    
//    }
//    });
// }
}
    
    

