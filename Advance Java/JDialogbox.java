import java.awt.*;
import javax.swing.*;

public class JDialogbox extends JFrame {
    JLabel l;
    JTextField f;
    JDialog d;

    JDialogbox(){
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Parent Frame");

        l= new JLabel("Email");
        f=new JTextField(15);
        d=new JDialog(this,"Dialog Example",true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER));
        d.setSize(300,200);
        d.setLocation(50,50);
        d.setModal(true);

        d.add(l);
        d.add(f);
        setVisible(true);
        d.setVisible(true);
    }
    
    public static void main(String[] args) {
        JDialogbox db = new JDialogbox();
    }
}
