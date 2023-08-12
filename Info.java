package Online_Examination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Info extends JFrame implements ActionListener{

    JButton submit,back;
    JTextField t1,t2,t3,t4,t5;
    JLabel userIdType;
    String userId ,password;

    Info(String userId,String password,String user)
    {

        this.userId = userId;
        this.password = password;
        Random random = new Random();

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 450, 50);
        p1.setLayout(null);
        p1.setBackground(new Color(32,156,238));
        add(p1);

        JLabel heading = new JLabel("--- Candidate Details ---");
        heading.setBounds(120, 07, 400, 40);
        heading.setFont(new Font("Tohoma", Font.BOLD, 20));
        p1.add(heading);

        JLabel name= new JLabel("Name:");
        name.setBounds(50,75,100,40);
        name.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(name);


        t1 = new JTextField();
        t1.setBounds(150,75,250,35);
        add(t1);

        JLabel age = new JLabel("Age: ");
        age.setFont(new Font("Tohoma", Font.BOLD, 14));
        age.setBounds(50,115,100,40);
        add(age);

        t2 = new JTextField();
        t2.setBounds(150,115,250,35);
        add(t2);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Tohoma", Font.BOLD, 14));
        gender.setBounds(50,155,100,40);
        add(gender);

        t4 = new JTextField();
        t4.setBounds(150,155,250,35);
        add(t4);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Tohoma", Font.BOLD, 14));
        qualification.setBounds(50,195,100,40);
        add(qualification);

        t3 = new JTextField();
        t3.setBounds(150,195,250,35);
        add(t3);


        JLabel userIdJLabel = new JLabel("User Id:");
        userIdJLabel.setFont(new Font("Tohoma", Font.PLAIN, 20));
        userIdJLabel.setBounds(50,245,100,40);
        add(userIdJLabel);

        userIdType = new JLabel("");
        userIdType.setFont(new Font("Raleway", Font.PLAIN, 16));
        userIdType.setBounds(130,245,220,40);
        add(userIdType);

        JLabel passwordJLabel = new JLabel("Password:");
        passwordJLabel.setFont(new Font("Tohoma", Font.BOLD, 14));
        passwordJLabel.setBounds(50,300,100,40);
        add(passwordJLabel);

        t5 = new JTextField();
        t5.setBounds(150,300,250,35);
        add(t5);

        if(user.equals("New User"))
        {
            long generateUserId = Math.abs(random.nextLong() % 90000000L) + 1234567891000000L;
            long generatePassword = Math.abs(random.nextLong() % 9000L) + 1000L;
            userIdType.setText(""+generateUserId);
            t5.setText(""+generatePassword);
        }
        else
        {
            userIdType.setText(userId);
            t5.setText(password);
        }
    
        submit = new JButton("Submit");
        submit.setBounds(160,350,150,30);
        submit.setFont(new Font("Tohoma", Font.BOLD, 14));
        submit.setBackground(new Color(32,156,238));
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(160,385,150,30);
        back.setFont(new Font("Tohoma", Font.BOLD, 14));
        back.setBackground(new Color(32,156,238));
        back.addActionListener(this);
        add(back);

        setSize(450, 450);
        setLocation(350, 40);
        setUndecorated(rootPaneCheckingEnabled);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String Name = t1.getText();
            String Age = t2.getText();
            String gender = t4.getText();
            String qualification = t3.getText();
            String userIdLabel = userIdType.getText();
            String passwordTF = t5.getText(); 
            int score = 0;

            try 
            {
                conn c = new conn();
                String queryInformation = "insert into information values('"+userIdLabel+"','"+passwordTF+"','"+Name+"','"+Age+"','"+qualification+"','"+gender+"')";
                c.s.executeUpdate(queryInformation);

                String  queryScore = "insert into score values('"+userIdLabel+"','"+passwordTF+"','"+Name+"','"+score+"')";
                c.s.executeUpdate(queryScore);
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }

            setVisible(false);
            new welcome(userIdLabel, passwordTF).setVisible(true);
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Info("","","");
    }
}
