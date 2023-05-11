import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends Commons{

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
    public void loginView() {
        Commons common = new Commons();
        JFrame frame = (JFrame)common.Frame();
        Font txt = new Font("", Font.BOLD, 15);
        Pin pin = new Pin();

        //---------------CARDNUMBER----------------
        JLabel card = new JLabel("ENTER YOUR CARD NUMBER");
        card.setBounds(50, 270, 250, 20);
        card.setFont(txt);
        JTextField cardNumber = new JTextField();
        cardNumber.setBounds(50, 300, 500, 35);
        cardNumber.setFont(txt);
        frame.add(cardNumber);
        frame.add(card);
        //-----------------------------------------

        //----------------ADMIN--------------------
        JLabel admin = new JLabel("ADMIN LOGIN >");
        admin.setBounds(0, 500, 570, 30);
        admin.setHorizontalAlignment(JLabel.RIGHT);
        admin.setFont(txt);
        frame.add(admin);
        admin.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pin.pinView("admin");
                frame.dispose();
            }
        });
        //------------------------------------------

        //-----------------BUTTON-----------------
        JButton cont = new JButton("COUNTINUE");
        cont.setBounds(200, 400, 200, 50);
        cont.setFont(new Font("Rockwell", Font.BOLD, 25));
        styleButton(cont);
        frame.add(cont);
        cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cardNumber.getText().length() == 16) {
                    pin.pinView(cardNumber.getText());
                    frame.dispose();
                }
                else {
                    Fail fail = new Fail();
                    fail.failView("WRONG CARD NUMBER!!!");
                    frame.dispose();
                }
            }

        });
        //----------------------------------------
        frame.setVisible(true);
    }
}