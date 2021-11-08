package pl.lab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Main extends JFrame{

    private static JLabel userLabel;
    private static JTextField usernameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton cancelButton;
    private static JLabel success;
    private static JPanel panel;

    public static void main(String[] args) {
        System.out.println("Program konsolowy");
        SwingUtilities.invokeLater(() -> {
            try {
                Main window = new Main();
                window.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() throws HeadlessException {
        this("Undefined");
    }
    public Main(String title) throws HeadlessException {
        super(title);
        buildFrame();
    }
    protected void buildFrame(){
        panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(450,340);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(40,20,80,20);
        panel.add(userLabel);

        usernameText = new JTextField();
        usernameText.setBounds(120,20,150,20);
        panel.add(usernameText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40,50,80,20);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(120,50,150,20);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(60,90,90,30);
        loginButton.addActionListener(e -> actionPerformed());
        panel.add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180,90,90,30);
        cancelButton.addActionListener(e -> cancelButtonPress());
        panel.add(cancelButton);

        success = new JLabel("");
        success.setBounds(20,150,50,50);
        panel.add(success);

        frame.setVisible(true);
    }

    private static void actionPerformed() {
        Login loginData = new Login("Marek", "haslo1");
        Login loginData2 = new Login("Jarek", "haslo2");
        HashMap<String, Login> login = new HashMap<>();
        login.put("Marek",loginData);
        login.put("Jarek",loginData2);

        String user=usernameText.getText();
        String  pass=String.valueOf(passwordText.getPassword());

        if (login.containsKey(user)){
            if (login.get(user).getHaslo().equals(pass)){
                panel.setBackground(Color.green);
            }
            else
                panel.setBackground(Color.red);
        }
        else
            panel.setBackground(Color.red);
    }

    private static void cancelButtonPress() {
        System.exit(0);
    }

}
