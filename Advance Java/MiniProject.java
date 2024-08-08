import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class MiniProject implements ActionListener {
    JTextField tf1;
    JLabel l1,l2,l3;
    JPasswordField tf2;
    JButton b1;
    JDialog d;
    Connection con = null;
    Statement stmt = null;
    MiniProject() throws ClassNotFoundException, SQLException{
        d=new JDialog();
        d.setTitle("Login");
        d.setSize(400,250);
        d.setLayout(null);
        d.setModal(true);
        d.setLocation(200,100);
        d.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/book_shop";
            String username="root";
            String password="";
            Connection con = DriverManager.getConnection(url,username,password);
        stmt=con.createStatement();
        Font f1 = new Font("Lucida Handwriting",Font.ITALIC,18);
        l3=new JLabel("Book Shop");
        l3.setBounds(100,10,300,40);
        l3.setFont(f1);
        d.add(l3);
        l1=new JLabel("User Name");
        l1.setBounds(50,70,100,25);
        d.add(l1);
        tf1=new JTextField();
        tf1.setBounds(160,70,100,25);
        d.add(tf1);
        l2=new JLabel("Password");
        l2.setBounds(50,100,100,25);
        d.add(l2);
        tf2=new JPasswordField();
        tf2.setBounds(160,100,100,25);
        d.add(tf2);
        b1=new JButton("Login");
        b1.setBounds(150,140,100,25);
        d.add(b1);
        b1.addActionListener(this);
        d.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String s1 = tf1.getText();
        String s2 = tf2.getText();
        if(ae.getActionCommand()=="Login"){
            try {
                ResultSet rs = stmt.executeQuery("Select * from login");
                while(rs.next()){
                    String s3 = rs.getString(1);
                    String s4 = rs.getString(2);
                    if(s3.equals(s1)&&s4.equals(s2)){
                        d.hide();
                    }
                }
                tf1.setText("");
                tf2.setText("");
                tf1.requestFocus();
            } 
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
      }
    
      class Start implements ActionListener{
        JButton b1,b2,b3,b4,b5;
        JFrame jf;
        JPanel p1,p2,p3;
        JLabel l,l1,l2,l3,l4,nl;
        JTextField tf1,tf2,tf3,tf4,nt;
        JButton next,prev,first,last,insert,update_name,update_cell,update_email,update_res;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs;
        Start() throws ClassNotFoundException, SQLException{
            jf=new JFrame();
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(750,400);
            jf.setTitle("My Address Book");
            jf.setLocation(100,100);
            jf.setResizable(false);
            p1=new JPanel();
            p2=new JPanel();
            p3=new JPanel();
            p3.setBorder(BorderFactory.createLineBorder(Color.blue));
            jf.add(p1,BorderLayout.NORTH);
            jf.add(p2,BorderLayout.SOUTH);
            jf.add(p3,BorderLayout.CENTER);

            Font f1 = new Font("Mistral",Font.BOLD,24);
            l=new JLabel("Book Shop");
            l.setFont(f1);
            p1.add(l);

            b1=new JButton("View");
            b2=new JButton("Add");
            b3=new JButton("Delete");
            b4=new JButton("Udate");
            b5=new JButton("Search");

            p2.add(b1);
            p2.add(b2);
            p2.add(b3);
            p2.add(b4);
            p2.add(b5);

            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            jf.setVisible(true);
            new MiniProject();
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand()=="View"){
                JPanel sp1=new JPanel();
                JPanel sp2=new JPanel();

                p3.removeAll();
                p3.setLayout(new BorderLayout());
                l1=new JLabel("Name");
                l2=new JLabel("Cell Number");
                l3=new JLabel("Email");
                l4=new JLabel("Residence");

                tf1=new JTextField(15);
                tf2=new JTextField(15);
                tf3=new JTextField(15);
                tf4=new JTextField(15);

                first=new JButton("<<");
                last=new JButton(">>");
                next=new JButton(">");
                prev=new JButton("<");

                first.setToolTipText("First Record");
                last.setToolTipText("Last Record");
                next.setToolTipText("Next Record");
                prev.setToolTipText("Previous Record");

                first.addActionListener(this);
                last.addActionListener(this);
                next.addActionListener(this);
                prev.addActionListener(this);

                sp1.add(first);
                sp1.add(last);
                sp1.add(next);
                sp1.add(prev);

                sp2.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
                sp1.setBorder(BorderFactory.createRaisedBevelBorder());
                sp2.setBorder(BorderFactory.createLoweredBevelBorder());
                sp2.add(l1);
                sp2.add(tf1);
                sp2.add(l2);
                sp2.add(tf2);
                sp2.add(l3);
                sp2.add(tf3);
                sp2.add(l4);
                sp2.add(tf4);
                p3.add(sp1,BorderLayout.SOUTH);
                p3.add(sp2,BorderLayout.CENTER);
                jf.setVisible(true);

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/book_shop";
                    String username="root";
                    String password="";
                    Connection con = DriverManager.getConnection(url,username,password);
                stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=stmt.executeQuery("Select * from AddressBook");
                rs.next();
                tf1.setText(rs.getString(1));
                tf2.setText(rs.getString(2));
                tf3.setText(rs.getString(3));
                tf4.setText(rs.getString(4));
                } 
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if(ae.getActionCommand()==">"){
                try {
                    rs.next();
                    tf1.setText(rs.getString(1));
                    tf2.setText(rs.getString(2));
                    tf3.setText(rs.getString(3));
                    tf4.setText(rs.getString(4));

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if(ae.getActionCommand()=="<"){
                try {
                    rs.previous();
                    tf1.setText(rs.getString(1));
                    tf2.setText(rs.getString(2));
                    tf3.setText(rs.getString(3));
                    tf4.setText(rs.getString(4));

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if(ae.getActionCommand()==">>"){
                try {
                    rs.last();
                    tf1.setText(rs.getString(1));
                    tf2.setText(rs.getString(2));
                    tf3.setText(rs.getString(3));
                    tf4.setText(rs.getString(4));

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if(ae.getActionCommand()=="<<"){
                try {
                    rs.first();
                    tf1.setText(rs.getString(1));
                    tf2.setText(rs.getString(2));
                    tf3.setText(rs.getString(3));
                    tf4.setText(rs.getString(4));

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if(ae.getActionCommand()=="Add"){
                p3.removeAll();
                JPanel sp1=new JPanel();
                JPanel sp2=new JPanel();
                insert=new JButton("Insert");
                p3.setLayout(new BorderLayout());
                l1=new JLabel("Name");
                l2=new JLabel("Cell Number");
                l3=new JLabel("Email");
                l4=new JLabel("Residence");

                tf1=new JTextField(15);
                tf2=new JTextField(15);
                tf3=new JTextField(15);
                tf4=new JTextField(15);

                sp1.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
                sp2.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
                sp1.setBorder(BorderFactory.createLoweredBevelBorder());
                sp2.setBorder(BorderFactory.createRaisedBevelBorder());
                sp1.add(l1);
                sp1.add(tf1);
                sp1.add(l2);
                sp1.add(tf2);
                sp1.add(l3);
                sp1.add(tf3);
                sp1.add(l4);
                sp1.add(tf4);
                sp2.add(insert);
                insert.addActionListener(this);

                p3.add(sp1,BorderLayout.CENTER);
                p3.add(sp2,BorderLayout.SOUTH);
                jf.setVisible(true);
        }

        if(ae.getActionCommand()=="Insert"){
            String n,c,e,r;
            n=tf1.getText();
            c=tf2.getText();
            e=tf3.getText();
            r=tf4.getText();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/book_shop";
                    String username="root";
                    String password="";
                    Connection con = DriverManager.getConnection(url,username,password);
                    stmt=con.createStatement();
                    stmt.executeUpdate("Insert into addressbook values('"+n+"','"+c+"','"+e+"','"+r+"')");
                    con.close();
                    JOptionPane.showMessageDialog(jf,"Record Insert Successfully","Insertion Complete",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception se) {
                System.out.println("se");
            }
        }
        if(ae.getActionCommand()=="Update"){
            p3.removeAll();
            JPanel sp1 = new JPanel();
            JPanel sp2 = new JPanel();
            JPanel sp3 = new JPanel();
            JPanel sp21 = new JPanel();
            JPanel sp22 = new JPanel();
            JPanel sp23 = new JPanel();
            JPanel sp24 = new JPanel();
            update_name=new JButton("Update Name");
            update_cell=new JButton("Update Cell");
            update_email=new JButton("Update Email");
            update_res=new JButton("Update Residence");
            p3.setLayout(new BorderLayout());
            nl=new JLabel("Name of Person");
            l1=new JLabel("New Name");
            l2=new JLabel("New Cell Number");
            l3=new JLabel("New Email");
            l4=new JLabel("New Residence");
            nt=new JTextField(15);
            tf1=new JTextField(15);
            tf2=new JTextField(15);
            tf3=new JTextField(15);
            tf4=new JTextField(15);

            sp1.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
            sp2.setLayout(new GridLayout(1,4));
            sp21.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
            sp22.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
            sp23.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
            sp24.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));

            sp1.setBorder(BorderFactory.createRaisedBevelBorder());
            sp2.setBorder(BorderFactory.createLoweredBevelBorder());
            sp21.setBorder(BorderFactory.createLineBorder(Color.red));
            sp22.setBorder(BorderFactory.createLineBorder(Color.red));
            sp23.setBorder(BorderFactory.createLineBorder(Color.red));
            sp24.setBorder(BorderFactory.createLineBorder(Color.red));

            sp1.add(nl);
            sp1.add(nt);

            sp21.add(l1);
            sp21.add(tf1);
            sp21.add(update_name);
            sp22.add(l2);
            sp22.add(tf2);
            sp22.add(update_cell);
            sp23.add(l3);
            sp23.add(tf3);
            sp23.add(update_email);
            sp24.add(l4);
            sp24.add(tf4);
            sp24.add(update_res);
            update_name.addActionListener(this);
            update_cell.addActionListener(this);
            update_email.addActionListener(this);
            update_res.addActionListener(this);

            Font f1=new Font("Lucida Handwriting",Font.ITALIC,12);
            JLabel x= new JLabel("You are updating by name");
            x.setFont(f1);  
            x.setForeground(Color.blue);
            sp2.add(sp21);
            sp2.add(sp22);
            sp2.add(sp23);
            sp2.add(sp24);
            sp3.add(x);
            p3.add(sp1,BorderLayout.NORTH);
            p3.add(sp2,BorderLayout.CENTER);
            p3.add(sp3,BorderLayout.SOUTH);
            jf.setVisible(true);
        }
        if(ae.getActionCommand()=="Update Name"){
            String n= nt.getText();
            String nn=tf1.getText();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/book_shop";
                    String username="root";
                    String password="";
                    Connection con = DriverManager.getConnection(url,username,password);
                    stmt=con.createStatement();
                    stmt.executeUpdate("Update addressbook set Name='"+nn+"'WHERE Name='"+n+"'");
                    con.close();
                    JOptionPane.showMessageDialog(jf,"Record Updated Successfully","Update Complete",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception se) {
                System.out.println("se");
            }
        }

        if(ae.getActionCommand()=="Update Cell"){
            String n= nt.getText();
            String nc=tf2.getText();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/book_shop";
                    String username="root";
                    String password="";
                    Connection con = DriverManager.getConnection(url,username,password);
                    stmt=con.createStatement();
                    stmt.executeUpdate("Update addressbook set cell_no='"+nc+"'WHERE Name='"+n+"'");
                    con.close();
                    JOptionPane.showMessageDialog(jf,"Record Updated Successfully","Update Complete",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception se) {
                System.out.println("se");
            }
        }

        if(ae.getActionCommand()=="Update Email"){
            String n= nt.getText();
            String ne=tf3.getText();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/book_shop";
                    String username="root";
                    String password="";
                    Connection con = DriverManager.getConnection(url,username,password);
                    stmt=con.createStatement();
                    stmt.executeUpdate("Update addressbook set Email='"+ne+"'WHERE Name='"+n+"'");
                    con.close();
                    JOptionPane.showMessageDialog(jf,"Record Updated Successfully","Update Complete",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception se) {
                System.out.println("se");
            }
        }

        if(ae.getActionCommand()=="Update Residence"){
            String n= nt.getText();
            String nr=tf4.getText();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/book_shop";
                    String username="root";
                    String password="";
                    Connection con = DriverManager.getConnection(url,username,password);
                    stmt=con.createStatement();
                    stmt.executeUpdate("Update addressbook set cell_no='"+nr+"'WHERE Name='"+n+"'");
                    con.close();
                    JOptionPane.showMessageDialog(jf,"Record Updated Successfully","Update Complete",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception se) {
                System.out.println("se");
            }
        }

        if(ae.getActionCommand()=="Delete"){
            String n= JOptionPane.showInputDialog("Enter name of Person");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/book_shop";
                    String username="root";
                    String password="";
                    Connection con = DriverManager.getConnection(url,username,password);
                    stmt=con.createStatement();
                    stmt.executeUpdate("Delete FROM addressbook WHERE Name='"+n+"'");
                    con.close();
                    JOptionPane.showMessageDialog(jf,"Record Deleted Successfully","Deletion Complete",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception se) {
                System.out.println("se");
            }
        }
        if(ae.getActionCommand()=="Search"){
            p3.removeAll();
            JPanel sp1 = new JPanel();
            JPanel sp2 = new JPanel();
            l1=new JLabel("Name");
            l2=new JLabel("Cell Number");
            l3=new JLabel("Email");
            l4=new JLabel("Residence");

            tf1=new JTextField(15);
            tf2=new JTextField(15);
            tf3=new JTextField(15);
            tf4=new JTextField(15);

            Font f1= new Font("Lucida Handwriting",Font.ITALIC,12);
            JLabel x= new JLabel("Your Search Result");
            x.setFont(f1);
            x.setForeground(Color.blue);

            p3.setLayout(new BorderLayout());
            sp1.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
            sp2.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));

            sp1.setBorder(BorderFactory.createLoweredBevelBorder());
            sp2.setBorder(BorderFactory.createRaisedBevelBorder());

            sp1.add(l1);
            sp1.add(tf1);
            sp1.add(l2);
            sp1.add(tf2);
            sp1.add(l3);
            sp1.add(tf3);
            sp1.add(l4);
            sp1.add(tf4);
            sp2.add(x);
            p3.add(sp1,BorderLayout.CENTER);
            p3.add(sp2,BorderLayout.NORTH);
            jf.setVisible(true);
            String n = JOptionPane.showInputDialog("Enter Name of Person");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/book_shop";
                String username="root";
                String password="";
                Connection con = DriverManager.getConnection(url,username,password);
                stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
               rs = stmt.executeQuery("SELECT * FROM addressbook WHERE Name='"+n+"'");
               rs.next();
               tf1.setText(rs.getString(1));
               tf2.setText(rs.getString(2));
               tf3.setText(rs.getString(3));
               tf4.setText(rs.getString(4));
                con.close();
            } catch (Exception e) {
                System.out.println("se");
            }
        }

      }
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        new MiniProject();
    }
}   
}
