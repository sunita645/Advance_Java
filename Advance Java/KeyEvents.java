import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyEvents extends JFrame implements KeyListener {
     JTextField t1,t2,t3;
     JLabel l1,l2,l3;
     JButton b;
     public KeyEvents(){
        super("Handling Key Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1=new JLabel("First Value");
        l2=new JLabel("Second Value");
        l3=new JLabel("Result");

        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        b=new JButton("Calculate");
        b.addKeyListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT,100,10));
        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
        add(b);
        setSize(400,400);
        setVisible(true);
     }
     public void keyPressed(KeyEvent ke){
        int x,y,z;
        x=Integer.parseInt(t1.getText());
        y=Integer.parseInt(t2.getText());
        if(ke.getKeyChar() == 'a')
        z=x+y;
        else if(ke.getKeyChar()=='s')
        z=x-y;
        
        else{
            t3.setText("press a or s");
            return;
        }
        t3.setText(String.valueOf(z));
     }
     public void keyTyped(KeyEvent ke){

     }
     public void keyReleased(KeyEvent ke){}

     public static void main(String[] args) {
         new KeyEvents();
     }
}
