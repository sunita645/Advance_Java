import java.awt.FlowLayout;
import javax.swing.*;

public class Flow extends JFrame {
    JButton b1,b2,b3,b4,b5,b6,b7;
	Flow() {
        setSize(400,150);
        setTitle("FlowLayout");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        b1=new JButton("Button 1");
        b2=new JButton("Button 2");
        b3=new JButton("Button 3");
        b4=new JButton(" This is a Button 4");
        b5=new JButton("Button 5");
        b6=new JButton("6");
        b7=new JButton("Button 7");
         
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Flow();
    }
}
