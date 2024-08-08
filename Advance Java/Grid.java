import java.awt.*;
import javax.swing.*;
public class Grid extends JFrame {
    JButton b1,b2,b3,b4,b5;

    public Grid() {
        setSize(400,200);
        setTitle("GridLayout Demo");
        setLayout(new GridLayout(2,3));

        b1= new JButton("Button 1");
        b2= new JButton("This is long Button 2");
        b3= new JButton("Button 3");
        b4= new JButton("Button 4");
        b5= new JButton("5");

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Grid();
    }
    
}
