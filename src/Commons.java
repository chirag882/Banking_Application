import javax.swing.*;
import java.awt.*;

public class Commons {
    public Component Frame() {
        JFrame frame = new JFrame();
        frame.setSize(600, 650);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.decode("#9BA2A2"));

        //------------------LOGO----------------------------------
        JLabel atm = new JLabel("ATM");
        atm.setBounds(0, 0, 600, 100);
        atm.setHorizontalAlignment(JLabel.CENTER);
        atm.setFont(new Font("Monospaced", Font.BOLD, 120));
        atm.setForeground(Color.WHITE);
        atm.setOpaque(true);
        atm.setBackground(Color.decode("#310022"));
        JLabel man = new JLabel("MANAGEMENT SYSTEM");
        man.setBounds(0, 100, 600, 30);
        man.setHorizontalAlignment(JLabel.CENTER);
        man.setFont(new Font("Monospaced", Font.BOLD, 20));
        man.setOpaque(true);
        man.setBackground(Color.decode("#310022"));
        man.setForeground(Color.WHITE);
        frame.add(man);
        frame.add(atm);
        //-----------------------------------------------
        return frame;
    }
}
