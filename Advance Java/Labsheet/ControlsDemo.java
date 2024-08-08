import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControlsDemo extends JFrame implements ActionListener {

     Container container;
     JLabel userLabel;
     JLabel passwordLabel,sexLabel, hobbiesLabel,countryLabel,commentsLabel;
     JTextField userTextField;
     JPasswordField passwordField;
     JRadioButton maleRadioButton;
     JRadioButton femaleRadioButton;
     JCheckBox playingCheckBox,readingCheckBox,visitingCheckBox,ticketingCheckBox;
     JComboBox<String> countryComboBox;
     JTextArea commentsTextArea;
     JButton okButton;
     JButton cancelButton;
     ButtonGroup sexGroup;

    public ControlsDemo() {
        setTitle("Controls Demo");
        setBounds(300, 90, 500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        // Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.ORANGE);
        leftPanel.setBounds(0, 0, 200, 400);
        leftPanel.setLayout(null);
        container.add(leftPanel);

        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.CYAN);
        rightPanel.setBounds(200, 0, 300, 400);
        rightPanel.setLayout(null);
        container.add(rightPanel);

        userLabel = new JLabel("User Name");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        userLabel.setSize(100, 20);
        userLabel.setLocation(30, 30);
        leftPanel.add(userLabel);

        userTextField = new JTextField();
        userTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        userTextField.setSize(150, 20);
        userTextField.setLocation(30, 30);
        rightPanel.add(userTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordLabel.setSize(100, 20);
        passwordLabel.setLocation(30, 70);
        leftPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(150, 20);
        passwordField.setLocation(30, 70);
        rightPanel.add(passwordField);

        sexLabel = new JLabel("Sex");
        sexLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        sexLabel.setSize(100, 20);
        sexLabel.setLocation(30, 110);
        leftPanel.add(sexLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("Arial", Font.PLAIN, 15));
        maleRadioButton.setBackground(Color.CYAN);
        maleRadioButton.setSize(75, 20);
        maleRadioButton.setLocation(30, 110);
        rightPanel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("Arial", Font.PLAIN, 15));
        femaleRadioButton.setBackground(Color.CYAN);
        femaleRadioButton.setSize(80, 20);
        femaleRadioButton.setLocation(105, 110);
        rightPanel.add(femaleRadioButton);

        sexGroup = new ButtonGroup();
        sexGroup.add(maleRadioButton);
        sexGroup.add(femaleRadioButton);

        hobbiesLabel = new JLabel("Hobbies");
        hobbiesLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        hobbiesLabel.setSize(100, 20);
        hobbiesLabel.setLocation(30, 150);
        leftPanel.add(hobbiesLabel);

        playingCheckBox = new JCheckBox("Playing");
        playingCheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        playingCheckBox.setBackground(Color.CYAN);
        playingCheckBox.setSize(100, 20);
        playingCheckBox.setLocation(30, 150);
        rightPanel.add(playingCheckBox);

        readingCheckBox = new JCheckBox("Reading");
        readingCheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        readingCheckBox.setBackground(Color.CYAN);
        readingCheckBox.setSize(100, 20);
        readingCheckBox.setLocation(130, 150);
        rightPanel.add(readingCheckBox);

        visitingCheckBox = new JCheckBox("Visiting");
        visitingCheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        visitingCheckBox.setBackground(Color.CYAN);
        visitingCheckBox.setSize(100, 20);
        visitingCheckBox.setLocation(30, 180);
        rightPanel.add(visitingCheckBox);

        ticketingCheckBox = new JCheckBox("Ticketing");
        ticketingCheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        ticketingCheckBox.setBackground(Color.CYAN);
        ticketingCheckBox.setSize(100, 20);
        ticketingCheckBox.setLocation(130, 180);
        rightPanel.add(ticketingCheckBox);

        countryLabel = new JLabel("Select Country");
        countryLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        countryLabel.setSize(100, 20);
        countryLabel.setLocation(30, 220);
        leftPanel.add(countryLabel);

        String[] countries = {"Select Country", "USA", "India", "Australia", "Canada"};
        countryComboBox = new JComboBox<>(countries);
        countryComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        countryComboBox.setSize(150, 20);
        countryComboBox.setLocation(30, 220);
        rightPanel.add(countryComboBox);

        commentsLabel = new JLabel("Comments");
        commentsLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        commentsLabel.setSize(100, 20);
        commentsLabel.setLocation(30, 260);
        leftPanel.add(commentsLabel);

        commentsTextArea = new JTextArea();
        commentsTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        commentsTextArea.setSize(150, 50);
        commentsTextArea.setLocation(30, 260);
        rightPanel.add(commentsTextArea);

        okButton = new JButton("Ok");
        okButton.setFont(new Font("Arial", Font.PLAIN, 15));
        okButton.setSize(70, 20);
        okButton.setLocation(30, 330);
        okButton.addActionListener(this);
        rightPanel.add(okButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 15));
        cancelButton.setSize(90, 20);
        cancelButton.setLocation(110, 330);
        cancelButton.addActionListener(this);
        rightPanel.add(cancelButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            // Add logic for Ok button here
            JOptionPane.showMessageDialog(this, "Ok button clicked");
        } else if (e.getSource() == cancelButton) {
            // Add logic for Cancel button here
            userTextField.setText("");
            passwordField.setText("");
            sexGroup.clearSelection();
            playingCheckBox.setSelected(false);
            readingCheckBox.setSelected(false);
            visitingCheckBox.setSelected(false);
            ticketingCheckBox.setSelected(false);
            countryComboBox.setSelectedIndex(0);
            commentsTextArea.setText("");
        }
    }

    public static void main(String[] args) {
        new ControlsDemo();
    }
}
