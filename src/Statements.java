import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Statements {

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
    public void stateView(int id) throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        Commons commons = new Commons();
        Home home = new Home();
        JFrame frame = (JFrame)commons.Frame();
        SQLManage manage = new SQLManage();

        //----------------LABEL-----------------------
        JLabel label = new JLabel("MINI STATEMENTS");
        label.setBounds(0, 200, 575, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Rockwell", Font.BOLD, 25));
        frame.add(label);
        //--------------------------------------------

        //---------------TABLE--------------------
        JTable table=new JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        model = (DefaultTableModel)table.getModel();
        model.addColumn("ID");
        model.addColumn("DEPOSIT");
        model.addColumn("WITHDRAW");
        model.addColumn("BALANCE");
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        JScrollPane sc = new JScrollPane(table);
        sc.setBounds(50, 250, 500, 200);
        frame.add(sc);
        //-----------------------------------------------

        //--------------------TABLEDATA------------------------
        ResultSet rst = manage.stmt(id);
        int i=0;
        while(rst.next()) {
            model.addRow(new Object[0]);
            model.setValueAt(rst.getInt("transid"), i, 0);
            if(rst.getString("stat").equals("dep")) {
                model.setValueAt(rst.getString("amount"), i, 1);
                model.setValueAt("-", i, 2);
            }
            else {
                model.setValueAt("-", i, 1);
                model.setValueAt(rst.getString("amount"), i, 2);
            }
            model.setValueAt(rst.getInt("bal"), i, 3);
            i++;
        }
        //-----------------------------------------------------
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
        frame.setVisible(true);
    }
}
