import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Bevelborder {
    public static void main(String[] args){
        JFrame frame = new JFrame("Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        JPanel panel =new JPanel();
        panel.setLayout(new Grid(2,3,10,10));

        JLabel bevelLabel = new JLabel("Bevel Border");
        bevelLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        panel.add(bevelLabel);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
}

