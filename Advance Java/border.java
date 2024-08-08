import java.awt.*;
import javax.swing.*;

public class border extends JFrame {
    public JButton b1,b2,b3,b4,b5;

    public void createButton(){
         b1 = new JButton("button 1");
         b2 = new JButton("button 2");
         b3 = new JButton("button 3");
         b4 = new JButton("button 4");
         b5 = new JButton("button 5");
    }

    public border(){
        createButton();
        setLayout(new BorderLayout(30,10));
        
        add(b1,BorderLayout.WEST);
        add(b2,BorderLayout.NORTH);
        add(b3,BorderLayout.EAST);
        add(b4,BorderLayout.SOUTH);
        add(b5,BorderLayout.CENTER);

        b1.setBackground(Color.red);
        b2.setBackground(Color.green);
        b3.setBackground(Color.yellow);
        b4.setBackground(Color.magenta);
        b5.setBackground(Color.blue);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
          
    }  
    public static void main(String[]args){
        border b = new border();
    }
}
