package src;
import javax.swing.*;


public class login {
    public static String USERNAME = "admin";
    public static String PASSWORD = "password";
    public static JTextField emailText;
    public static JFrame  registerFrame;
    public static JFrame loginFrame;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        PlaceComponents.placeComponents(panel, frame);

        frame.setVisible(true);
    }


   
}