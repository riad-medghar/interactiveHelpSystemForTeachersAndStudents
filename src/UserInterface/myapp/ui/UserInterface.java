package src.UserInterface.myapp.ui;

import javax.swing.*;

public class UserInterface {
    public static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Créez un champ de texte
        JLabel userLabel = new JLabel("Utilisateur :");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Créez un bouton
        JButton loginButton = new JButton("Envoyer");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }
}
