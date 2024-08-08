import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ConnectJDBC extends JFrame implements ActionListener {
    // Components of the form
    private JTextField rollNumberField, nameField, levelField, ageField;
    private JButton addButton, deleteButton, findButton, modifyButton;

    // Database connection
    private Connection connection;

    public ConnectJDBC() {
        // Initialize the components
        rollNumberField = new JTextField(20);
        nameField = new JTextField(20);
        levelField = new JTextField(20);
        ageField = new JTextField(20);

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        findButton = new JButton("Find");
        modifyButton = new JButton("Modify");

        // Set the layout
        setLayout(new GridLayout(6, 2));

        // Add components to the form
        add(new JLabel("Roll Number:"));
        add(rollNumberField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Level:"));
        add(levelField);
        add(new JLabel("Age:"));
        add(ageField);
        add(addButton);
        add(deleteButton);
        add(findButton);
        add(modifyButton);

        // Set up action listeners
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        findButton.addActionListener(this);
        modifyButton.addActionListener(this);

        // Set up the frame
        setTitle("Student Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                
                e.printStackTrace();
            }
            String url = "jdbc:mysql://localhost:3306/java_db";
            String username="root";
            String password="";
            Connection con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement();
 
            String sql = "CREATE TABLE IF NOT EXISTS students " +
                         "(roll_number TEXT PRIMARY KEY NOT NULL, " +
                         " name TEXT NOT NULL, " + 
                         " level TEXT NOT NULL, " + 
                         " age INTEGER NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addStudent();
        } else if (e.getSource() == deleteButton) {
            deleteStudent();
        } else if (e.getSource() == findButton) {
            findStudent();
        } else if (e.getSource() == modifyButton) {
            modifyStudent();
        }
    }

    private void addStudent() {
        try {
            String sql = "INSERT INTO students (roll_number, name, level, age) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, rollNumberField.getText());
            pstmt.setString(2, nameField.getText());
            pstmt.setString(3, levelField.getText());
            pstmt.setInt(4, Integer.parseInt(ageField.getText()));
            pstmt.executeUpdate();
            pstmt.close();
            JOptionPane.showMessageDialog(this, "Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding student!");
        }
    }

    private void deleteStudent() {
        try {
            String sql = "DELETE FROM students WHERE roll_number = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, rollNumberField.getText());
            pstmt.executeUpdate();
            pstmt.close();
            JOptionPane.showMessageDialog(this, "Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting student!");
        }
    }

    private void findStudent() {
        try {
            String sql = "SELECT * FROM students WHERE roll_number = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, rollNumberField.getText());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nameField.setText(rs.getString("name"));
                levelField.setText(rs.getString("level"));
                ageField.setText(rs.getString("age"));
                JOptionPane.showMessageDialog(this, "Student found!");
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error finding student!");
        }
    }

    private void modifyStudent() {
        try {
            String sql = "UPDATE students SET name = ?, level = ?, age = ? WHERE roll_number = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, nameField.getText());
            pstmt.setString(2, levelField.getText());
            pstmt.setInt(3, Integer.parseInt(ageField.getText()));
            pstmt.setString(4, rollNumberField.getText());
            pstmt.executeUpdate();
            pstmt.close();
            JOptionPane.showMessageDialog(this, "Student modified successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error modifying student!");
        }
    }
    public static void main(String[] args) {
        new ConnectJDBC();
    }
}
