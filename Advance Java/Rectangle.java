import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends JPanel {
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 100, 100);
    }
    
public static void main(String[]args){
   JFrame frame = new JFrame("Custom JPanel DEmo");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(400,300);

   Rectangle rec = new Rectangle();
   frame.add(rec);
   frame.setVisible(true);
}
}

