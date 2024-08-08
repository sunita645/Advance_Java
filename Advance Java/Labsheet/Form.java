import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Form extends JFrame implements ActionListener {

     Container container;
     JLabel userLabel;
     JLabel passwordLabel;
     JTextField userTextField;
     JPasswordField passwordField;
     JButton loginButton;
     JButton cancelButton;

    public Form() {
        setTitle("Login Form");
        setBounds(300, 90, 400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        userLabel = new JLabel("User ID");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        userLabel.setSize(100, 20);
        userLabel.setLocation(50, 30);
        container.add(userLabel);

        userTextField = new JTextField();
        userTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        userTextField.setSize(190, 20);
        userTextField.setLocation(150, 30);
        container.add(userTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordLabel.setSize(100, 20);
        passwordLabel.setLocation(50, 70);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(190, 20);
        passwordField.setLocation(150, 70);
        container.add(passwordField);

        loginButton = new JButton("OK");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
        loginButton.setBackground(Color.BLUE);
        loginButton.setSize(100, 20);
        loginButton.setLocation(50, 110);
        loginButton.addActionListener(this);
        container.add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 15));
        cancelButton.setBackground(Color.BLUE);
        cancelButton.setSize(100, 20);
        cancelButton.setLocation(200, 110);
        cancelButton.addActionListener(this);
        container.add(cancelButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = new String(passwordField.getPassword());
            // Perform login validation logic here
            JOptionPane.showMessageDialog(this, "User ID: " + userText + "\nPassword: " + pwdText);
        } else if (e.getSource() == cancelButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        new Form();
    }
}
