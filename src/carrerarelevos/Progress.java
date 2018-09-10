/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carrerarelevos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 


/**
 *
 * @author Eduardo
 */
public class Progress extends JFrame{
    JProgressBar current;
    JTextArea out;
    JButton find;
    Thread runner;
    int num = 0;
    
    public Progress() {
        super("Progress");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        pane.add(current);
        setContentPane(pane);
    }
    //Le agregamos un parametro para poder controlar los incrementos
    //Originalmente iba de 95 en 95
    public void iterate(int var, double incremento) {
        while (num < var) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            
            num += incremento; 
        }
    }
    
    public JProgressBar getBarra(){
        return this.current;
    }
}
