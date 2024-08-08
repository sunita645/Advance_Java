import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LineBorder {
    public static void main(String[] args){
        JFrame frame = new JFrame("Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        JPanel panel =new JPanel();
        panel.setLayout(new Grid(2,3,10,10));
        JLabel lineLabel = new JLabel("Line Border");
        lineLabel.setBorder(new LineBorder(Color.yellow,7));
        panel.add(lineLabel);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
}
