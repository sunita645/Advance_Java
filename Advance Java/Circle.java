import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Circle extends JFrame {

    public Circle(){
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
       setVisible(true);
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.drawOval(30,40,80,80); 
    }
public static void main(String[]args){
   Circle g = new Circle();
   g.paint(null);
}
}
