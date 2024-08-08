import javax.swing.*;

class Mnemonic extends JFrame{
    JMenuBar mb;
    JMenu sm,am,em,tm,hm;                               
    JMenuItem miname,migrade,micont,miaddr;
    JMenuItem mifee,midue;
    JMenuItem misem,miyear;
    JMenuItem misearch;
    JMenuItem misupp;

     Mnemonic() {
     setVisible(true);
     setLocation(200,200);
    setSize(700, 0x1f4);
    setTitle("Student Information Management System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

ImageIcon icon = new ImageIcon("school.png");
setIconImage(icon.getImage());
//frame.setResizable(false);

mb = new JMenuBar();

sm=new JMenu("Student");
am = new JMenu("Account");
em= new JMenu("Examination");
tm= new JMenu("Tools");
hm=new JMenu("Help");

//setting Mnemonic
sm.setMnemonic('S');
am.setMnemonic('A');
em.setMnemonic('E');
tm.setMnemonic('T');
hm.setMnemonic('H');

mb.add(sm);
mb.add(am);
mb.add(em);
mb.add(tm);
mb.add(hm);

//menuitem for student
miname= new JMenuItem("Name",'n');
migrade=new JMenuItem("Grade",'g');
micont =new JMenuItem("Contact",'c');
miaddr =new JMenuItem("Address",'a');
sm.add(miname);
sm.add(migrade);
sm.add(micont);
sm.add(miaddr);

//menuitem for Account
mifee=new JMenuItem("Fee",'f');
midue=new JMenuItem("Due",'d');
am.add(mifee);
am.add(midue);

//menuitem for Examination
misem=new JMenuItem("Semester",'s');
miyear=new JMenuItem("Year",'y');
em.add(misem);
em.add(miyear);

//menuitem for Tools
misearch = new JMenuItem("Search",'s');
tm.add(misearch);

//menuitem for Help
misupp = new JMenuItem("Support",'s');
hm.add(misupp);

setJMenuBar(mb);

    }
    
public static void main(String args[]){
Mnemonic f = new Mnemonic();

}
}