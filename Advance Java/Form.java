import java.awt.*;
import javax.swing.*;
public class Form extends JFrame{
    JLabel l1,l2,l3,l4,lgen,lcon,lcmt,lblhobby;
    JTextField t1,t2,t3,t4;
    JRadioButton rbmale,rbfemale,rbother;
    JButton b1;
    ButtonGroup bg;
    JCheckBox chkplay,chkread,chkvisit,chktkt;
    
    Form(){
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("USER LOGIN");
        setLayout(null);
        setBackground(Color.cyan);
        setSize(800,800);

        l1 = new JLabel("Full Name");
        l2 = new JLabel("Address");
        l3 = new JLabel("E-mail");
        l4 = new JLabel("Contact");

        lgen = new JLabel("Gender");
        rbmale = new JRadioButton("Male",true);
        rbfemale = new JRadioButton("Female");
        rbother = new JRadioButton("others");
        bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        bg.add(rbother);

        lblhobby=new JLabel("Hobbies");
        

        lcon = new JLabel("Country");
        lcmt = new JLabel("Comment");
        

        TextArea txtaddress = new TextArea("",200,100);

        t1 = new JTextField("Enter your name",30);
        t2 = new JTextField(30); 
        t3 = new JTextField(30);
        t4 = new JTextField(30);
       
        b1 = new JButton("save");

        l1.setBounds(100,50,200,30);
        t1.setBounds(250,50,200,30);
        add(l1);
        add(t1);
        

        l2.setBounds(100,100,200,30);
        t2.setBounds(250,100,200,30);
        add(l2);
        add(t2);

        l3.setBounds(100,150,200,30);
        t3.setBounds(250,150,200,30);
        add(l3);
        add(t3);

        l4.setBounds(100,200,200,30);
        t4.setBounds(250,200,200,30);
        add(l4);
        add(t4);

       //creating and adding gender
        lgen.setBounds(100,250,200,30);
        add(lgen);
        rbmale.setBounds(250,250,200,30);
        rbfemale.setBounds(350,250,200,30);
        rbother.setBounds(450,250,200,30);
        add(rbmale);
       add(rbfemale);
       add(rbother);

       //Creating and Adding ckeckbox
		lblhobby=new JLabel("Hobbies");
		chkplay=new JCheckBox("Playing");
		chkread=new JCheckBox("Reading");
		chkvisit=new JCheckBox("Visiting");
		chktkt=new JCheckBox("Ticketing");
		lblhobby.setBounds(100,550,200,30);
		chkplay.setBounds(250,550,175,30);
		chkread.setBounds(425,550,175,30);
		chkvisit.setBounds(600,550,175,30);
		chktkt.setBounds(700,550,175,30);
		add(lblhobby);
		add(chkplay);
		add(chkread);
		add(chkvisit);
		add(chktkt);

       lcon.setBounds(100,300,200,30);
        add(lcon);
        Choice con = new Choice();
        con.add("Nepal");
        con.add("USA");
        con.add("Australia");
        con.add("India");
        con.add("UK");
        con.setBounds(300,300,100,30);
        add(con);

        lcmt.setBounds(100,350,200,30);
        add(lcmt);
        txtaddress.setBounds(300,350,350,150);
        add(txtaddress);

        b1.setBounds(300,600,100,30);
        add(b1);

        ImageIcon icon = new ImageIcon("logo1.png");
        setIconImage(icon.getImage());
        setVisible(true);
    }
    public static void main(String[]args){
        Form ff = new Form(); 
    }
    

}
