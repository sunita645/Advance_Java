import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Poloygon extends JPanel {
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 100, 100 );
    }
    
public static void main(String[]args){
   JFrame frame = new JFrame("Custom JPanel DEmo");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(400,300);

   Poloygon pl = new Poloygon();
   frame.add(pl);
   frame.setVisible(true);
}
}

