import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import static javax.swing.text.StyleConstants.setBackground;

public class Home {

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


    public void homeView(int id) throws SQLException {
        Operations operations = new Operations();
        Font txt = new Font("", Font.BOLD, 25);
        Commons commons = new Commons();
        JFrame frame = (JFrame) commons.Frame();
        JButton quick = new JButton("< Quick Cash");
        quick.setBounds(30, 250, 225, 30);
        quick.setFont(txt);
        JButton withdraw = new JButton("Withdraw >");
        withdraw.setBounds(350, 250, 225, 30);
//        withdraw.setHorizontalAlignment(JLabel.RIGHT);
        withdraw.setFont(txt);
        JButton deposit = new JButton("< Deposit");
        deposit.setBounds(30, 350, 225, 30);
        deposit.setFont(txt);
        JButton sts = new JButton("Mini Statement >");
        sts.setBounds(350, 350, 225, 30);
//        sts.setHorizontalAlignment(JLabel.RIGHT);
        sts.setFont(txt);
        JButton bal = new JButton("< Balance Enquiry");
        bal.setBounds(30, 450, 225, 30);
        bal.setFont(txt);
        JButton pinchange = new JButton("Change Pin >");
        pinchange.setBounds(350, 450, 225, 30);
//        pinchange.setHorizontalAlignment(JLabel.RIGHT);
        pinchange.setFont(txt);
        JButton transfermoney = new JButton("< Transfer Money");
        transfermoney.setBounds(30, 550, 225, 30);
        transfermoney.setFont(txt);

        styleButton(quick);
        styleButton(withdraw);
        styleButton(deposit);
        styleButton(sts);
        styleButton(bal);
        styleButton(pinchange);
        styleButton(transfermoney);

        frame.add(quick);
        frame.add(withdraw);
        frame.add(deposit);
        frame.add(sts);
        frame.add(bal);
        frame.add(pinchange);
        frame.add(transfermoney);
        frame.setVisible(true);

        quick.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Quick qk = new Quick();
                try {
                    qk.quickView(id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
        withdraw.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView("Withdraw Amount", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
        deposit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView("Deposit Amount", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
        sts.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Statements state = new Statements();
                try {
                    state.stateView(id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
        bal.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView("Balance", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
        pinchange.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView("New PIN", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
        transfermoney.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView2("Transfer", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
    }
}