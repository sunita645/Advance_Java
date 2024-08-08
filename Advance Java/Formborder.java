// import java.awt.*;
// import javax.swing.*;

// public class Formborder extends JFrame {

//    JLabel l1,l2,l3;
//    JTextField t1,t2;
//    JButton b1,b2;

//    public Formborder(){
//     l1= new JLabel("USER Login");
//     l2 =new JLabel("User Id");
//     l3 = new JLabel("Password");

//     t1 = new JTextField(0);
//     t2 = new JTextField(0);

//     b1= new JButton("OK");
//     b2 = new JButton("Cancel");
   
//     setLayout(new BorderLayout(0,0));
//     add(l1,BorderLayout.NORTH);

//     add(l2,BorderLayout.CENTER);
//     add(t1,BorderLayout.SOUTH);

//     add (l3,BorderLayout.CENTER);
//     add(t2,BorderLayout.SOUTH);

//     add(b1,BorderLayout.WEST);
//     add(b2,BorderLayout.WEST);

//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(500,500);
//         setVisible(true);
//    }

//    public static void main(String[] args) {
//        Formborder fb = new Formborder();
//    }
// }

import java.awt.*;
import javax.swing.*;

public class Formborder extends JFrame {
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2;

    public Formborder(){
        l1 = new JLabel("User Login");
        l2 = new JLabel("User Name");
        l3 = new JLabel("Password");

        t1 = new JTextField("your name");
        t2 = new JTextField();

         b1 = new JButton("Ok");
         b2 = new JButton("Cancel");
         
        setLayout(new BorderLayout(0,0));
        
        add(l1,BorderLayout.NORTH);
        add(l2,BorderLayout.CENTER);
        add(l3,BorderLayout.CENTER);

        add(t1,BorderLayout.EAST);
        add(t2,BorderLayout.EAST);

        add(b1,BorderLayout.SOUTH);
        add(b2,BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setVisible(true);
          
    }  
    public static void main(String[]args){
        Formborder fb = new Formborder();
    }
}

