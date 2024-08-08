import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EventTest extends JFrame implements ActionListener {
    JTextField t1,t2,t3;
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4;
    
    public EventTest(){
        super("Handling action event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        l1=new JLabel("First Value");
        l2=new JLabel("Second Value");
        l3=new JLabel("Result:");

        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);

        b1=new JButton("Add");
        b2=new JButton("Subtract");
        b3=new JButton("Multiply");
        b4=new JButton("Divide");

        setLayout(new FlowLayout(FlowLayout.LEFT,130,10));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        int x,y,z;
        x=Integer.parseInt(t1.getText());
        y=Integer.parseInt(t2.getText());
        if(ae.getSource() == b1){
            z=x+y;
        }
            else if(ae.getSource()== b2){
                z=x-y;
            }
                
            else if(ae.getSource()== b3)
            {
                z=x*y;
            }
            
            else{
                z=x/y;
            }
    
            t3.setText(String.valueOf(z));
    }
    public static void main(String[] args) {
        new EventTest();
    }
    
}
