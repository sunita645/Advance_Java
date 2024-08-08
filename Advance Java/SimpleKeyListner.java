import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class SimpleKeyListner extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;  
	JButton b1,b2,b3;
	
	SimpleKeyListner()
	{
		setSize(300,300);
		setTitle("Simple Interest Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER,50,10));

		l1=new JLabel("Principal");
		l2=new JLabel("Time");
		l3=new JLabel("Rate");
		l4=new JLabel("Result");

		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);

		b1=new JButton("Simple Interest");
		b2=new JButton("Amount");
		b3=new JButton("Clear");

		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b1);
		add(b2);
		add(b3);

		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		float p,t,r,res,a;
		p=Float.parseFloat(t1.getText());
		t=Float.parseFloat(t2.getText());
		r=Float.parseFloat(t3.getText());

		if(e.getSource()==b1)
		{
		res=(p*t*r)/100;
		t4.setText(String.valueOf(res));
		}
		else if(e.getSource()==b2)
		{
			res=p+(p*t*r)/100;
			t4.setText(String.valueOf(res));
		}
		else
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}


	}
	public static void main(String args[])
		{
			new SimpleKeyListner();
		}
}