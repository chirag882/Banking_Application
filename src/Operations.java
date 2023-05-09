import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operations {

    SQLManage manage;
    Fail fail;
    Success success;
    Home home = new Home();

    Operations() throws SQLException {
        manage = new SQLManage();
        fail = new Fail();
        success = new Success();
    }

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
    public void opView2(String str, int id) throws SQLException {
        Commons commons = new Commons();
        JFrame frame = (JFrame) commons.Frame();
        Font txt = new Font("", Font.BOLD, 15);

        //----------------LABEL-----------------------
        JLabel hlabel = new JLabel("TRANSACTION");
        hlabel.setBounds(0, 200, 575, 30);
        hlabel.setHorizontalAlignment(JLabel.CENTER);
        hlabel.setFont(new Font("Rockwell", Font.BOLD, 25));
        frame.add(hlabel);

        //-----------------AMOUNT/PIN------------------
        JLabel label = new JLabel("Enter the card number: ");
        label.setBounds(50, 270, 250, 20);
        label.setFont(txt);
        JTextField card = new JTextField();
        card.setBounds(50, 300, 500, 35);
        card.setFont(txt);
        frame.add(label);
        frame.add(card);
        //----------------------------------------------
        //------------------BACK-----------------------
        JButton bk = new JButton("BACK");
        bk.setBounds(200,475,200,50);
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
        //------------------SUBMIT------------------------
        JButton sbt = new JButton("SUBMIT");
        sbt.setBounds(200, 420, 200, 50);
        sbt.setFont(new Font("Rockwell", Font.BOLD, 25));
        styleButton(sbt);
        sbt.setBackground(Color.decode("#17c237"));

        frame.add(sbt);
        sbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (str.equals("Transfer")) {
                    try {
                        int check = manage.accValidate(card.getText());
                        if(check == 1){
                            opView3(card.getText(),str,id);
                        }else{
                            fail.failView("INVALID USER");
                        }

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        frame.setVisible(true);
    }

    public void opView3(String card,String str, int id) throws SQLException {
        Commons commons = new Commons();
        JFrame frame = (JFrame) commons.Frame();
        Font txt = new Font("", Font.BOLD, 15);





        //-----------------AMOUNT/PIN------------------
        JLabel label = new JLabel("Enter the amonut: " );
        label.setBounds(50, 270, 250, 20);
        label.setFont(txt);
        JTextField amt = new JTextField();
        amt.setBounds(50, 300, 500, 35);
        amt.setFont(txt);
        frame.add(label);
        frame.add(amt);
        //----------------------------------------------
        //------------------BACK-----------------------
        JButton bk = new JButton("BACK");
        bk.setBounds(200,475,200,50);
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
        //------------------SUBMIT------------------------
        JButton sbt = new JButton("SUBMIT");
        sbt.setBounds(200, 420, 200, 50);
        sbt.setFont(new Font("Rockwell", Font.BOLD, 25));
        styleButton(sbt);
        sbt.setBackground(Color.decode("#17c237"));
        frame.add(sbt);
        sbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (str.equals("Transfer")) {
                    try {
                        transfermoney(card,Integer.parseInt(amt.getText()), id);
                        success.successView(id);
                        frame.dispose();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }

        });
        frame.setVisible(true);
    }

    public void opView(String str, int id) throws SQLException {
        Commons commons = new Commons();
        JFrame frame = (JFrame)commons.Frame();
        Font txt = new Font("", Font.BOLD, 15);

        //----------------LABEL-----------------------
        JLabel hlabel = new JLabel();
        if(str.equals("Withdraw Amount")) {
            hlabel = new JLabel("WITHDRAW");
        }else if(str.equals("Deposit Amount")){
            hlabel = new JLabel("DEPOSIT");
        }else if(str.equals("New PIN")){
            hlabel = new JLabel("PIN");
        }else if(str.equals("Balance")){
            hlabel = new JLabel("BALANCE");
        }
        hlabel.setBounds(0, 200, 575, 30);
        hlabel.setHorizontalAlignment(JLabel.CENTER);
        hlabel.setFont(new Font("Rockwell", Font.BOLD, 25));
        frame.add(hlabel);

        //-----------------AMOUNT/PIN------------------
        JLabel label = new JLabel("Enter the " + str);
        label.setBounds(50, 270, 250, 20);
        label.setFont(txt);
        JTextField amt = new JTextField();
        amt.setBounds(50, 300, 500, 35);
        amt.setFont(txt);
        frame.add(label);
        frame.add(amt);
        //----------------------------------------------
        //------------------BACK-----------------------
        JButton bk = new JButton("BACK");
        bk.setBounds(200,475,200,50);
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
        //------------------SUBMIT------------------------
        JButton sbt = new JButton("SUBMIT");
        sbt.setBounds(200, 420, 200, 50);
        sbt.setFont(new Font("Rockwell", Font.BOLD, 25));
        styleButton(sbt);
        sbt.setBackground(Color.decode("#17c237"));
        frame.add(sbt);
        sbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(str.equals("Withdraw Amount")) {
                    withdrawal(Integer.parseInt(amt.getText()), id);
                    frame.dispose();
                }
                else if(str.equals("Deposit Amount")) {
                    try {
                        manage.deposit(Integer.parseInt(amt.getText()), id);
                        success.successView(id);
                        frame.dispose();
                    }
                    catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if(str.equals("New PIN")){
                    try {
                        manage.pinchange(amt.getText(), id);
                        success.successView(id);
                        frame.dispose();
                    }
                    catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }

        });


        //------------------------------------------------

        if (str.equals("Balance")){
            amt.setVisible(false);
            sbt.setVisible(false);
            label.setText("Your Balance is : ");
            JLabel bal;
            try {
                bal = new JLabel(manage.balCheck(id)+"");
                bal.setBounds(0, 325, 600, 20);
                bal.setHorizontalAlignment(JLabel.CENTER);
                bal.setFont(new Font("", Font.BOLD, 25));
                frame.add(bal);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        frame.setVisible(true);
    }

    public void transfermoney(String card,int amount,int id) throws SQLException {
        int check = manage.transfermoney(card,amount,id);
        if(check==1) {
            success.successView(id);
        }
        else {
            fail.failView("INSUFFICIENT BALANCE!!!");
        }
    }

    public void withdrawal(int amount, int id) {
        try {
            int check = manage.withdraw(amount, id);
            if(check==1) {
                success.successView(id);
            }
            else {
                fail.failView("INSUFFICIENT BALANCE!!!");
            }
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}