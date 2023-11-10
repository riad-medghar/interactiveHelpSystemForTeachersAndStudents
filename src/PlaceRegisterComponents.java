package src;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaceRegisterComponents extends login{
     public static void placeRegisterComponents(JPanel panel, JFrame loginFrame, JFrame registerFrame) {

        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 50, 80, 25);
        panel.add(emailLabel);

        emailText = new JTextField(20);
        emailText.setBounds(100, 50, 165, 25);
        panel.add(emailText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        JLabel rePasswordLabel = new JLabel("Re-Password");
        rePasswordLabel.setBounds(10, 110, 80, 25);
        panel.add(rePasswordLabel);

        JPasswordField rePasswordText = new JPasswordField(20);
        rePasswordText.setBounds(100, 110, 165, 25);
        panel.add(rePasswordText);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(10, 140, 80, 25);
        panel.add(genderLabel);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(100, 140, 80, 25);
        panel.add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(180, 140, 80, 25);
        panel.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 170, 80, 25);
        panel.add(registerButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 170, 80, 25);
        panel.add(backButton);

        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add validation for the fields here
                USERNAME = emailText.getText();
                PASSWORD = new String(passwordText.getPassword());
                JOptionPane.showMessageDialog(null, "Registration successful!");
                registerFrame.setVisible(false);
                loginFrame.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(true);
                registerFrame.setVisible(false);
            }
        });
    }
}
