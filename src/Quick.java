import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Quick {

    public void styleButton(JButton b) {
        Font font = new Font("Arial", Font.BOLD, 16);
        b.setFont(font);
    }
    public void quickView(int id) throws SQLException {

        Operations oper = new Operations();
        Home home = new Home();
        Font txt = new Font("", Font.BOLD, 25);
        Commons commons = new Commons();
        JFrame frame = (JFrame)commons.Frame();
        //----------------LABEL-----------------------
        JLabel hlabel = new JLabel("QUICK CASH");
        hlabel.setBounds(0, 200, 575, 30);
        hlabel.setHorizontalAlignment(JLabel.CENTER);
        hlabel.setFont(new Font("Rockwell", Font.BOLD, 25));
        frame.add(hlabel);
        JButton two = new JButton("< 200");
        two.setBounds(30, 250, 200, 30);
        two.setFont(txt);
        styleButton(two);
        JButton five = new JButton("500 >");
        five.setBounds(350, 250, 200, 30);
        five.setHorizontalAlignment(JLabel.RIGHT);
        five.setFont(txt);
        styleButton(five);
        JButton ten = new JButton("< 1000");
        ten.setBounds(30, 350, 200, 30);
        ten.setFont(txt);
        styleButton(ten);
        JButton twenty = new JButton("2000 >");
        twenty.setBounds(350, 350, 200, 30);
        twenty.setHorizontalAlignment(JLabel.RIGHT);
        twenty.setFont(txt);
        styleButton(twenty);
        JButton fifty = new JButton("< 5000");
        fifty.setBounds(30, 450, 200, 30);
        fifty.setFont(txt);
        styleButton(fifty);
        JButton hundred = new JButton("10000 >");
        hundred.setBounds(350, 450, 200, 30);
        hundred.setHorizontalAlignment(JLabel.RIGHT);
        hundred.setFont(txt);
        styleButton(hundred);
        frame.add(two);
        frame.add(five);
        frame.add(ten);
        frame.add(twenty);
        frame.add(fifty);
        frame.add(hundred);
        frame.setVisible(true);

        two.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oper.withdrawal(200, id);
                frame.dispose();
            }
        });
        five.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oper.withdrawal(500, id);
                frame.dispose();
            }
        });
        ten.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oper.withdrawal(1000, id);
                frame.dispose();
            }
        });
        twenty.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oper.withdrawal(2000, id);
                frame.dispose();
            }
        });
        fifty.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oper.withdrawal(5000, id);
                frame.dispose();
            }
        });
        hundred.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oper.withdrawal(10000, id);
                frame.dispose();
            }
        });
        //------------------BACK-----------------------
        JButton bk = new JButton("BACK");
        bk.setBounds(200,500,200,50);
        bk.setFont(new Font("Rockwell", Font.BOLD, 25));
        styleButton(bk);
        bk.setForeground(Color.WHITE);
        bk.setBackground(Color.decode("#c22b17"));
        frame.add(bk);
        bk.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try{
                    home.homeView(id);
                    frame.dispose();
                }catch (SQLException e1){
                    e1.printStackTrace();
                }

            }
        });
    }
}