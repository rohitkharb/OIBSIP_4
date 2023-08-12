package Online_Examination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class login extends JFrame implements ActionListener{

    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;

    login()
    {
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 500, 50);
        p1.setLayout(null);
        p1.setBackground(new Color(32,156,238));
        add(p1);

        JLabel l1 = new JLabel("Java MCQ Wizard");
        l1.setFont(new Font("Ink Free", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        l1.setBounds(10,10,200,40);
        p1.add(l1);
        

        JLabel l2 = new JLabel("Id: ");
        l2.setFont(new Font("Kristen ITC", Font.BOLD, 14));
        l2.setBounds(50,85,40,40);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(130,85,150,35);
        add(t1);

        JLabel l3 = new JLabel("Password: ");
        l3.setFont(new Font("Kristen ITC", Font.BOLD, 14));
        l3.setBounds(50,125,100,40);
        add(l3);

        t2 = new JPasswordField();
        t2.setBounds(130,125,150,35);
        add(t2);

        b1 = new JButton("Login");
        b1.setFont(new Font("Kristen ITC", Font.BOLD, 12));
        b1.setBackground(new Color(32,156,238));
        b1.setBounds(310,75,150,25);
        b1.addActionListener(this);
        add(b1);

        b3 = new JButton("New Candidate");
        b3.setFont(new Font("Kristen ITC", Font.BOLD, 12));
        b3.setBackground(new Color(32,156,238));
        b3.setBounds(310,115,150,25);
        b3.addActionListener(this);
        add(b3);

        b2 = new JButton("Quit");
        b2.setFont(new Font("Kristen ITC", Font.BOLD, 12));
        b2.setBackground(new Color(32,156,238));
        b2.setBounds(310,155,150,25);
        b2.addActionListener(this);
        add(b2);



        setSize(500,200);
        setLocation(450, 90);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String userId = t1.getText();
            String password = t2.getText();

            conn c = new conn();
            try 
            {
                String query = "select * from information where Password = '"+password+"'and User_Id = '"+userId+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new welcome(userId, password).setVisible(true);
                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"Invalid Candidate");
                }
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b2)
        {
            System.exit(0);
        }
        else if(ae.getSource() == b3)
        {
            setVisible(false);
            new Info("","","New User").setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}
