package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class login {
    public static String USERNAME = "admin";
    public static String PASSWORD = "password";
    public static JTextField emailText;
    public static JFrame  registerFrame;
    public static JFrame loginFrame;
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://localhost:5432/interactivehelpsystem";
        String user = "postgres";
        String password = "riad18hamada";
         Connection conn = null;
        try {
        conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
        System.out.println("Connection to PostgreSQL failed.");
        e.printStackTrace();
        }
        String sql = "SELECT * FROM \"user\";";
        Statement stmt = null;
        try {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();
for (int i = 1; i <= columnCount; i++) {
    System.out.println("Column Name: " + rsmd.getColumnName(i));
}

        while (rs.next()) {
            System.out.println(rs.getString("name") + ", " + rs.getString("password"));
        }
        } catch (SQLException e) {
        System.out.println("Failed to retrieve data from PostgreSQL database.");
        e.printStackTrace();
        } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }

         JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        PlaceComponents.placeComponents(panel, frame);

        frame.setVisible(true);
    }


   
}