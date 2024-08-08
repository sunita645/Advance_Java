import javax.swing.*;
public class HelloFrame extends JFrame 
{
	JLabel l;
	JTextField t;
	HelloFrame() 
	{	
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GUI Test");
		setLayout(null);
		l=new JLabel("Your Name");
		t=new JTextField(15);
		l.setBounds(150,100,100,30);
		add(l);
		t.setBounds(275,100,100,30);
		add(t);		
		setVisible(true);	
	}
	public static void main(String args[]) 
	{
		HelloFrame hf=new HelloFrame();		
	}
}
