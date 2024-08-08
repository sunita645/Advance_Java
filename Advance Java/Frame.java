import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
public class Frame {
    public static void main(String[]args){
        JFrame frame = new JFrame("JPanel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JButton("Button1"));
        panel.add(new JButton("Button2"));
        panel.add(new JButton("Button3"));

        frame.add(panel);

        frame.setVisible(true);

        //border with 10px and set color 
        //draw circle inside panel
        Border border = new LineBorder(Color.BLACK, 100);
        JButton button = new JButton("12 Pixel");
        button.setBorder(border);
    }
}
