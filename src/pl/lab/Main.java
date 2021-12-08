package pl.lab;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame implements MouseInputListener {

    private JButton button = null;
    int keyCode;
    int x,y;
    private final Random r = new Random();
    ArrayList<Point> points = new ArrayList<>();

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
        runningButton();
        kanwa();
    }

    public void  runningButton(){
        JPanel panel = new JPanel();

        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(panel);
        panel.setLayout(null);
        setTitle("Uciekający przycisk");

        button = new JButton("Button");

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(getMousePosition().getX() <= (button.getX()+button.getWidth()-10) && (getMousePosition().y >= button.getY() ||
                        getMousePosition().y <= button.getY() + button.getHeight())) {
                    button.setLocation(r.nextInt(panel.getWidth()-button.getWidth()), r.nextInt(panel.getHeight()-button.getHeight()));
                }
            }
        });
        button.setBounds(150,10,90,30);
        panel.add(button);

        JButton cancel;
        cancel = new JButton("Cancel");
        cancel.setBounds(560,10,90,30);
        cancel.addActionListener(e->button.setBounds(150,10,90,30));
        add(cancel);
    }

    public void kanwa(){
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                keyCode=e.getKeyCode();
            }
        });
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        x=e.getX();
        y=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Graphics g = getGraphics();
        if (keyCode==KeyEvent.VK_K){
                g.setColor(Color.blue);
                g.fillRect(x, y, 40, 60);
                points.add(new Point(x, y));
        }
        else if (keyCode==KeyEvent.VK_O) {
                g.setColor(Color.red);
                g.fillOval(x, y, 40, 40);
                points.add(new Point(x, y));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

}