package pl.lab;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{

    public static void main(String[] args) {
        System.out.println("Program konsolowy");
        SwingUtilities.invokeLater(() -> {
            try {
                Main window = new Main();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        });
        apkMain();
        System.exit(0);
    }

    public Main() throws HeadlessException{
        this("undefined");
    }

    public Main(String title) throws HeadlessException{
        super(title);
        buildWindow();
    }

    public void buildWindow(){
        setBounds(100,100,450,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void apkMain(){
        Login login1 = new Login("Marek", "haslo1");
        Login login2 = new Login("Jarek", "haslo2");

        ArrayList<Object> logins = new ArrayList<>();
        logins.add(login1);
        logins.add(login2);
    }
}
