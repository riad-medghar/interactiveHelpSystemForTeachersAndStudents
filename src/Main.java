package src;

import javax.swing.*;

import src.UserInterface.myapp.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        // Créez une nouvelle fenêtre
        JFrame frame = new JFrame("Aide IHM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Créez un panneau pour contenir les composants
        JPanel panel = new JPanel();
        frame.add(panel);
        UserInterface.placeComponents(panel);

        // Rendez la fenêtre visible
        frame.setVisible(true);
    }
}
