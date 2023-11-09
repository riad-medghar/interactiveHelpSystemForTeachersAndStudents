import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    private static String USERNAME = "admin";
    private static String PASSWORD = "password";
    private static JTextField emailText;
    private static JFrame  registerFrame;
    private static JFrame loginFrame;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, JFrame frame) {

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JCheckBox rememberMe = new JCheckBox("Remember me");
        rememberMe.setBounds(100, 80, 165, 25);
        panel.add(rememberMe);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 110, 80, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("register");
        registerButton.setBounds(100, 110, 80, 25);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               USERNAME = userText.getText();
                PASSWORD = new String(passwordText.getPassword());
            
                
                if (USERNAME.equals(userText.getText()) && PASSWORD.equals(new String(passwordText.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Authentication successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Authentication failed!");
                }
              
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
                writer.write(USERNAME + "," + PASSWORD);
                writer.newLine();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Registration successful!");
            registerFrame.setVisible(false);
            loginFrame.setVisible(true);
        }

        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame = new JFrame("Register");
                registerFrame.setSize(400, 300);
                registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel registerPanel = new JPanel();
                registerFrame.add(registerPanel);
                placeRegisterComponents(registerPanel, frame, registerFrame);

                registerFrame.setVisible(true);
                frame.setVisible(false);
                
            }
        });
    }

    private static void placeRegisterComponents(JPanel panel, JFrame loginFrame, JFrame registerFrame) {

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