import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Admin {

    public void styleButton(JButton b) {
        Font font = new Font("Arial", Font.BOLD, 16);
        b.setFont(font);

        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                b.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });
    }
    public void adminView() {

        Commons commons = new Commons();
        JFrame frame = (JFrame) commons.Frame();

        //-------------ADDUSERS---------------------
        JButton add = new JButton("ADD USERS");
        add.setBounds(150, 250, 300, 100);
        add.setFont(new Font("Rockwell", Font.BOLD, 25));
        styleButton(add);
        add.setBackground(Color.decode("#17c237"));
        frame.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUser user = new AddUser();
                try {
                    user.addView();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
        //------------------------------------------

        //--------------EXIT---------------------------
        JButton exit = new JButton("EXIT");
        exit.setBounds(150, 400, 300, 100);
        exit.setFont(new Font("Rockwell", Font.BOLD, 25));
        styleButton(exit);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.decode("#c22b17"));
        frame.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //---------------------------------------------
        frame.setVisible(true);
    }
}
