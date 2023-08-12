package Online_Examination;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class score extends JFrame implements ActionListener{

    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;

    String userId,password,name;

    score(String userId,String password,String name ,int Score)
    {
        this.userId = userId;
        this.password = password;
        this.name = name;

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 500, 50);
        p1.setLayout(null);
        p1.setBackground(new Color(32,156,238));
        add(p1);

        JLabel l1 = new JLabel("Score Card");
        l1.setFont(new Font("Tohoma", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        l1.setBounds(10,10,200,40);
        p1.add(l1);
        

        JLabel l2 = new JLabel("Well Done " + name);
        l2.setFont(new Font("Ink Free", Font.BOLD, 20));
        l2.setBounds(50,85,300,40);
        add(l2);

        JLabel l3 = new JLabel("Score: " + Score );
        l3.setFont(new Font("Tohoma", Font.BOLD, 14));
        l3.setBounds(70,110,100,40);
        add(l3);

        b1 = new JButton("Try Again");
        b1.setFont(new Font("Tohoma", Font.BOLD, 12));
        b1.setBackground(new Color(32,156,238));
        b1.setBounds(310,75,150,25);
        b1.addActionListener(this);
        add(b1);

        b3 = new JButton("Login");
        b3.setFont(new Font("Tohoma", Font.BOLD, 12));
        b3.setBackground(new Color(32,156,238));
        b3.setBounds(310,115,150,25);
        b3.addActionListener(this);
        add(b3);

        b2 = new JButton("Logout");
        b2.setFont(new Font("Tohoma", Font.BOLD, 12));
        b2.setBackground(new Color(32,156,238));
        b2.setBounds(310,155,150,25);
        b2.addActionListener(this);
        add(b2);

        try {
            conn c = new conn();
            String  queryScore = "update score set Score = '"+Score+"' where User_Id = '"+userId+"'";
            c.s.executeUpdate(queryScore);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


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
            setVisible(false);
            new quiz(userId,password,name).setVisible(true);
        }
        else if(ae.getSource() == b2)
        {
            System.exit(0);
        }
        else if(ae.getSource() == b3)
        {
            setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new score("","","",0);
    }
}

