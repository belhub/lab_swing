package pl.lab;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Main extends JFrame {

    private JButton button = null;
    private JButton cancel = null;
    private Random r = new Random();

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
        RunningButton();
    }

    public void  RunningButton(){
        JPanel panel = new JPanel();

        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);

        panel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(panel);
        panel.setLayout(null);
        setTitle("Uciekający przycisk");

        button = new JButton("Button");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(e.getX() <= button.getX() + button.getWidth()-10 && (getMousePosition().y >= button.getY() ||
                        getMousePosition().y <= button.getY() + button.getHeight())) {
                    button.setLocation(r.nextInt(panel.getWidth()-button.getWidth()), r.nextInt(panel.getHeight()-button.getHeight()));
                }
            }
        });

        panel.add(button);
        button.setBounds(100,100,100,40);

        cancel = new JButton("Cancel");
        cancel.setBounds(300,100,100,40);
        cancel.addActionListener(e->button.setBounds(100,100,100,40));
        add(cancel);

    }
}
