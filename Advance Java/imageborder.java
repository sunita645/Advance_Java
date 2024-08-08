import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class imageborder {
    public static void main(String[] args){
        JFrame frame = new JFrame("Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        JPanel panel =new JPanel();
        panel.setLayout(new Grid(2,3,10,10));

        JLabel imageLabel = new JLabel("image matte Border");
        ImageIcon icon = new ImageIcon("logo2.png");
        MatteBorder imageBorder = new MatteBorder(10,10,10,10,icon);
        panel.add(imageLabel);
        imageLabel.setBorder(imageBorder);
        frame.add(panel);
        frame.setVisible(true);
    }
}


