package Online_Examination;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class quiz extends JFrame implements ActionListener{

    String userId,password,name;
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][1];
    String userAnswers[][] = new String[10][1];

    JLabel qno,question;
    JRadioButton op1,op2,op3,op4;
    ButtonGroup group;
    JButton next,submit;

    public static int Timer = 30;
    public static int ansGiven = 0;
    public static int count = 0;
    public static int score = 0;

    public quiz(String userId,String password,String name)
    {
        this.userId = userId;
        this.password = password;
        this.name = name;

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 900, 150);
        p1.setLayout(null);
        p1.setBackground(new Color(32,156,238));
        add(p1);

        JLabel label = new JLabel("JAVA MCQ WIZARD");
        label.setBounds(280,10,200,40);
        label.setFont(new Font("Tohoma", Font.BOLD, 20));
        label.setForeground(Color.white);
        p1.add(label);

        JLabel l1 = new JLabel();
        l1.setBounds(10, 60, 300, 70);
        l1.setFont(new Font("Tohoma", Font.BOLD, 22));
        l1.setForeground(Color.WHITE);
        l1.setText("<html>" + "Name: " + name + "<br>" + "ID: " + userId + "<html>");
        p1.add(l1);

        qno = new JLabel();
        qno.setBounds(20,170,40,40);
        add(qno);

        question = new JLabel();
        question.setBounds(40,170,700,40);
        add(question);


        questions[0][0] = "Which keyword is used to declare a variable that holds a constant value?";
        questions[0][1] = "static";
        questions[0][2] = "final";
        questions[0][3] = "constant";
        questions[0][4] = "const";

        questions[1][0] = "Which of the following is NOT a valid access modifier in Java?";
        questions[1][1] = "private";
        questions[1][2] = "protected";
        questions[1][3] = "internal";
        questions[1][4] = "public";

        questions[2][0] = "Which data structure in Java stores elements in a sorted order?";
        questions[2][1] = "ArrayList";
        questions[2][2] = "LinkedList";
        questions[2][3] = "HashSet";
        questions[2][4] = "TreeMap";

        questions[3][0] = "What is the default value of an instance variable in Java if it is not explicitly initialized?";
        questions[3][1] = "0";
        questions[3][2] = "null";
        questions[3][3] = "false";
        questions[3][4] = "Depends on the data types";

        questions[4][0] = "Which of the following statements is true about method overriding in Java?";
        questions[4][1] = "The method signature must be the same in the superclass and the subclass.";
        questions[4][2] = "The method in the subclass must have a higher access modifier than the superclass.";
        questions[4][3] = "The method in the subclass can throw any checked or unchecked exception.";
        questions[4][4] = "The final method in the superclass can be overridden.";

        questions[5][0] = "What is the purpose of the finally block in a try-catch-finally statement?";
        questions[5][1] = "It is executed when an exception occurs.";
        questions[5][2] = "It is executed regardless of whether an exception occurs or not.";
        questions[5][3] = "It is executed only when an exception occurs.";
        questions[5][4] = "It is used to catch and handle exceptions.";

        questions[6][0] = "Which keyword is used to create an object in Java?";
        questions[6][1] = "new";
        questions[6][2] = "object";
        questions[6][3] = "create";
        questions[6][4] = "instance";

        questions[7][0] = "Which keyword is used to prevent a class from being inherited in Java?";
        questions[7][1] = "final";
        questions[7][2] = "private";
        questions[7][3] = "static";
        questions[7][4] = "abstract";

        questions[8][0] = "What is the purpose of the super keyword in Java?";
        questions[8][1] = "It is used to call the superclass constructor.";
        questions[8][2] = "It is used to access the superclass methods and variables.";
        questions[8][3] = "It is used to create an instance of the superclass.";
        questions[8][4] = "It is used to implement multiple inheritance.";

        questions[9][0] = "Which of the following collections in Java does not allow duplicate elements?";
        questions[9][1] = "ArrayList";
        questions[9][2] = "LinkedList";
        questions[9][3] = "HashSet";
        questions[9][4] = "TreeMap";


        answers[0][0] = "final";
        answers[1][0] = "internal";
        answers[2][0] = "TreeMap";
        answers[3][0] = "Depends on the data types";
        answers[4][0] = "The method signature must be the same in the superclass and the subclass.";
        answers[5][0] = "It is executed regardless of whether an exception occurs or not.";
        answers[6][0] = "new";
        answers[7][0] = "final";
        answers[8][0] = "It is used to access the superclass methods and variables.";
        answers[9][0] = "HashSet";

        op1 = new JRadioButton();
        op1.setBounds(20,205,550,40);
        add(op1); 

        op2 = new JRadioButton();
        op2.setBounds(20,235,550,40);
        add(op2); 

        op3 = new JRadioButton();
        op3.setBounds(20,265,550,40);
        add(op3); 

        op4 = new JRadioButton();
        op4.setBounds(20,295,550,40);
        add(op4); 

        group = new ButtonGroup();
        group.add(op1);
        group.add(op2);
        group.add(op3);
        group.add(op4);

        JLabel timeLeft = new JLabel("Time Left - ");
        timeLeft.setFont(new Font("Tohoma",Font.BOLD,20));
        timeLeft.setForeground(Color.RED);
        timeLeft.setBounds(600, 60, 150,40);
        p1.add(timeLeft);

        next = new JButton("Save & Next");
        next.setBounds(600,200,120,30);
        next.setFont(new Font("Tohoma",Font.BOLD,14));
        next.setBackground(new Color(32,156,238));
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(600,240,120,30);
        submit.setFont(new Font("Tohoma",Font.BOLD,14));
        submit.setBackground(new Color(32,156,238));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        quizStart(count);

        setSize(750, 350);
        setUndecorated(true);
        setLayout(null);
        setLocation(250, 50);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        String time = "" + Timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tohoma", Font.BOLD, 20));

        if(Timer>0)
        {
            g.drawString(time, 600, 120);
        }

        Timer--;

        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        if(ansGiven == 1)
        {
            ansGiven = 0;
            Timer = 30;
        }
        else if(Timer<=0)
        {
            Timer = 30;
            if(count == 8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9)
            {
                if(group.getSelection() == null)
                {
                    userAnswers[count][0] = "";
                }
                else
                {
                    userAnswers[count][0] = group.getSelection().getActionCommand();
                }

                for(int i = 0;i<userAnswers.length;i++)
                {
                    if(userAnswers[i][0].equals(answers[i][0]))
                    {
                        score += 10;
                    }
                }

                setVisible(false);
                new score(userId,password,name,score).setVisible(true);
            }
            else
            {
                if(group.getSelection() == null)
                {
                    userAnswers[count][0] = "";
                }
                else
                {
                    userAnswers[count][0] = group.getSelection().getActionCommand();
                }
            }
            count++;
            quizStart(count);
        }

    }


    public void quizStart(int Count)
    {
        qno.setText(""+(Count+1)+".  ");
        question.setText(questions[Count][0]);
        op1.setText(questions[Count][1]);
        op1.setActionCommand(questions[Count][1]);

        op2.setText(questions[Count][2]);
        op2.setActionCommand(questions[Count][2]);

        op3.setText(questions[Count][3]);
        op3.setActionCommand(questions[Count][3]);

        op4.setText(questions[Count][4]);
        op4.setActionCommand(questions[Count][4]);

        group.clearSelection();

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == next)
        {
            repaint();
            ansGiven = 1;
            if(group.getSelection() == null)
            {
                userAnswers[count][0] = "";
            }
            else
            {
                userAnswers[count][0] = group.getSelection().getActionCommand();
            }

            if(count == 8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            quizStart(count);
        }
        else if(ae.getSource() == submit)
        {
            ansGiven = 1;

            if(group.getSelection() == null)
            {
                userAnswers[count][0] = "";
            }
            else
            {
                userAnswers[count][0] = group.getSelection().getActionCommand();
            }

            for(int i = 0;i<userAnswers.length;i++)
            {
                if(userAnswers[i][0].equals(answers[i][0]))
                {
                    score += 10;
                }
            }

            setVisible(false);
            new score(userId,password,name,score).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new quiz("","","");
    }
}
