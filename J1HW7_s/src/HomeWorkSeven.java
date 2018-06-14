import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;

public class HomeWorkSeven extends JPanel {
    public void paint(Graphics g) {
        g.drawLine(25, 25, 120, 120);

    }


    public static void main(String[] args) {



        JFrame frame = new JFrame();

        frame.getContentPane().add(new HomeWorkSeven());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);

        frame.setVisible(true);

        MyWindow myWindow = new MyWindow();
    }

}
class MyWindow extends JFrame {
    public MyWindow() {
        setBounds(500, 500, 400, 300);
        setTitle("Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel pan = new JPanel();
        add(pan);
        pan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("MousePos: " + e.getX() + " " + e.getY());
            }
        });


        setVisible(true);
    }


}

