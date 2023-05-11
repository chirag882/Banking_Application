import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pin {

    public void styleButton(JButton b) {
        Color bgColor = Color.decode("#59043f");
        Color hoverColor = Color.decode("#c40a8b");
        Color pressColor = new Color(153, 153, 153);
        Font font = new Font("Arial", Font.BOLD, 16);

        b.setForeground(Color.WHITE);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setOpaque(true);
        b.setBackground(bgColor);
        b.setForeground(Color.WHITE);
        b.setFont(font);

        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b.setBackground(hoverColor);
                b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                b.setBackground(bgColor);
                b.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                b.setForeground(Color.WHITE);

            }

            public void mousePressed(MouseEvent e) {
                b.setBackground(pressColor);
            }

            public void mouseReleased(MouseEvent e) {
                b.setBackground(hoverColor);
            }
        });
    }

    public void pinView(String cardNum) {
        Commons common = new Commons();
        JFrame frame = (JFrame) common.Frame();
        Font txt = new Font("", Font.BOLD, 15);
        Home home = new Home();
        Admin admin = new Admin();

        //---------------PASSWORD----------------
        JLabel pswd = new JLabel("ENTER YOUR PIN");
        pswd.setBounds(50, 270, 250, 20);
        pswd.setFont(txt);
        JPasswordField pswdField = new JPasswordField();
        pswdField.setBounds(50, 300, 500, 35);
        pswdField.setFont(txt);
        frame.add(pswdField);
        frame.add(pswd);
        //-----------------------------------------

        //-----------------BUTTON-----------------
        JButton cont = new JButton("COUNTINUE");
        cont.setBounds(200, 400, 200, 50);
        cont.setFont(new Font("Rockwell", Font.BOLD, 25));
        styleButton(cont);
        frame.add(cont);
        cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SQLManage man = new SQLManage();
                    ResultSet rst = man.check(cardNum, pswdField.getText());
                    if (rst.next()) {
                        if (rst.getString("card").equals("admin")) {
                            admin.adminView();
                            frame.dispose();
                        } else {
                            home.homeView(rst.getInt("id"));
                            frame.dispose();
                        }
                    } else {
                        Fail fail = new Fail();
                        fail.failView("WRONG PIN!!!");
                        frame.dispose();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });
        //----------------------------------------
        frame.setVisible(true);
    }
}
