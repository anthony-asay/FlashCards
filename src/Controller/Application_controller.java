/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Anthony
 */
public class Application_controller {
    
    private JFrame main = new MainFrameView();
    
    public void getMainFrame()
    {
       main.setVisible(true);
       //main.setLayout(new BorderLayout());
       JPanel next = new PanelView();
       //main.add(next, BorderLayout.CENTER);
       main.setContentPane(next);
       main.pack();
    }
    
    public void getRegisterPanel(JPanel old)
    {
        System.out.println("hello");
        main.remove(old);
        JPanel next = new RegisterPanelView();
        //main.add(next, BorderLayout.CENTER);
        //main.repaint();
         main.setContentPane(next);
       main.pack();
       main.repaint();
       main.revalidate();
      
    }
}
