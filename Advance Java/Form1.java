import java.awt.*;
import javax.swing.*;
public class Form1 extends JFrame {
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;

    Form1(){
                 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Registration Form" );
    setLayout(null);

    //setLayout(new BorderLayout(0,0));
        //add(l3,BorderLayout.NORTH);
        //add(t3,BorderLayout.NORTH);
        
    setSize(400,400);
    setBackground(Color.cyan);

   // l3 = new JLabel("User Login");
    l1 = new JLabel("User Name");
    l2 = new JLabel("Password");
    
    //t3=new JTextField(30);
    t1=new JTextField(30);
    t2=new JTextField(30);
    

    b1 = new JButton("Login");
    b2 = new JButton("New Registration");

    l1.setBounds(100,50,200,30);
    t1.setBounds(250,50,200,30);
    add(l1);
    add(t1);

    l2.setBounds(100,100,200,30);
    t2.setBounds(250,100,200,30);
    add(l2);
    add(t2);

    b1.setBounds(250,150,100,30);
    add(b1);
    
    b2.setBounds(380,150,150,30);
    add(b2);

    setVisible(true);
    }
    public static void main(String[] args) {
        new Form1();
    }
    
}
