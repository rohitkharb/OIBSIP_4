package Online_Examination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class welcome extends JFrame implements ActionListener{
    
    JButton start, back, updateprofile;
    String userId,password,name;
    
    welcome(String userId,String password) {

        this.userId = userId;
        this.password = password;

        JLabel label = new JLabel("LET'S TRY");
        label.setBounds(180,20,200,40);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        add(label);
        
        JLabel heading = new JLabel("JAVA MCQ WIZARD");
        heading.setBounds(130, 65, 400, 40);
        heading.setFont(new Font("Ink Free", Font.BOLD, 26));
        add(heading);

        JLabel label2= new JLabel("Guidelines:");
        label2.setBounds(65,120,100,40);
        label2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        add(label2);
        
        JLabel rules = new JLabel();
        rules.setBounds(90, 150, 600, 120);
        rules.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        rules.setText(
            "<html>"+ 
                "-> Java MCQ Wizard contains 10 Questions." + "<br>" +
                "-> You have 4 options for each question" + "<br>" +
                "-> All the questions are compulsory" + "<br>" +
                "-> Each Quwstion contains 10 marks" + "<br>" +
                "-> You have 30 seconds for each question" + "<br>" +
            "<html>"
        );
        add(rules);

        JLabel Name = new JLabel("");
        Name.setBounds(130, 275, 150, 30);
        Name.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        add(Name);

        JLabel previousScore = new JLabel("");
        previousScore.setBounds(130, 300, 150, 30);
        previousScore.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        add(previousScore);


        conn c = new conn();
        try 
        {
            String query = "Select * from score where Password = '"+password+"'and User_Id = '"+userId+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next())
            {
                name = rs.getString("Name");
                Name.setText("Name: " + name);

                String score = rs.getString("Score");
                previousScore.setText("Previous Score: "+ score);
            }

            
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

        start = new JButton("Start");
        start.setBounds(185, 360, 150, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        start.addActionListener(this);
        add(start);

        updateprofile = new JButton("Update Profile");
        updateprofile.setBounds(20, 360, 150, 30);
        updateprofile.setBackground(new Color(30, 144, 254));
        updateprofile.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        updateprofile.addActionListener(this);
        add(updateprofile);
        
        back = new JButton("Back");
        back.setBounds(350, 360, 150, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);
        
        setSize(520, 420);
        setLocation(350, 40);
        setUndecorated(rootPaneCheckingEnabled);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == start)
        {
            setVisible(false);
            new quiz(userId,password,name).setVisible(true);
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new login().setVisible(true);
        }
        else if(ae.getSource() == updateprofile)
        {
            setVisible(false);
            new Info(userId,password,"Old User").setVisible(true);
        }
    }
    public static void main(String[] args) {
        new welcome("","");
    }
}
