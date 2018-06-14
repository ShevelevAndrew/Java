import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BouncingBall extends JFrame{

        final String TITLE_OF_PROGRAM = "Bouncing Ball";
        final int WINDOW_SIZE = 330;
        final int WINDOW_DX = 7;
        final int WINDOW_DY = 55;
        final int FIELD_SIZE = 3;
        final int CELL_SIZE = WINDOW_SIZE / FIELD_SIZE;
        //final String BTN_INIT = "New game";
        //final String BTN_EXIT = "Exit";

        Panel panel = new Panel();
        GraficsBall graficsBall  = new GraficsBall (FIELD_SIZE, CELL_SIZE);
        //Human human = new Human(field.getHumanDot());

        public static void main(String args[]) {
            new BouncingBall();
        }

        BouncingBall() {
            setTitle(TITLE_OF_PROGRAM);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(WINDOW_SIZE + WINDOW_DX, WINDOW_SIZE + WINDOW_DY);
            setLocationRelativeTo(null); // to the center
            setResizable(false);

            panel.setBackground(Color.white);

            JPanel panelBtn = new JPanel();
            panelBtn.setLayout(new GridLayout()); // for panel of buttons


            setLayout(new BorderLayout()); // for main window
            //add(panelBtn, BorderLayout.SOUTH);
            add(panel, BorderLayout.CENTER);
            setVisible(true);
        }
        class Panel extends JPanel { // for painting
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            graficsBall.paint(g);
        }
    }


}
