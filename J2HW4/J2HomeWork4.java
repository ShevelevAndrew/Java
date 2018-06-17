/**
 * J2HomeWork4
 *
 * @author Andrew Shevelev
 * @version Jun, 16 2018
 * @link https://github.com/ShevelevAndrew
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class J2HomeWork4 extends JFrame implements ActionListener {

    Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();

    JTextArea jta;
    JTextField jtField;

    public static void main(String[] args) {
        new J2HomeWork4();
    }
    J2HomeWork4() {
        setTitle("Client of the chat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(sizeScreen.width-350, sizeScreen.height - 600, 350, 550);

        jta = new JTextArea();
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
        jtField = new JTextField();
        jtField.addActionListener(this);
        JButton butSend = new JButton("Send message");
        butSend.addActionListener(this);

        jp.add(jtField);
        jp.add(butSend);

        add(BorderLayout.CENTER, jsp);
        add(BorderLayout.SOUTH, jp);
        setVisible(true);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                StringBuffer buffer = new StringBuffer();

                try (BufferedReader file = new BufferedReader (new FileReader("logChat.txt"))) {
                    while (file.ready())
                        buffer.append(file.readLine() + "\n");
                    jta.append(buffer.toString());
                    file.close();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try (FileWriter file = new FileWriter("logChat.txt")) {
                    file.write(jta.getText());
                    file.close();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (jtField.getText().trim().length() > 0) {
            jta.append(jtField.getText() + "\n");
        }
        jtField.setText("");
        jtField.requestFocusInWindow();
    }
}
