package src;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PlaceComponents extends login {
      public static void placeComponents(JPanel panel, JFrame frame) {

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
                PlaceRegisterComponents.placeRegisterComponents(registerPanel, frame, registerFrame);

                registerFrame.setVisible(true);
                frame.setVisible(false);
                
            }
        });
    }
}
