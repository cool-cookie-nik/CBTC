import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener
{
    String[][] questions = new String[10][5];
    String[][] answers= new String[10][2];
    String[][] userans= new String[10][1];
    String name;
    JButton next,submit;
    JLabel qno,ques;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup options;
    public static int timer=20,ans_given=0,count=0,score=0;
    Quiz(String name)
    {
        this.name=name;
        setVisible(true);
        setBounds(200,25,1080,800);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        qno= new JLabel();
        qno.setBounds(40,30,50,25);
        qno.setFont(new Font("Times new ROman", Font.PLAIN,25));
        add(qno);

        ques= new JLabel();
        ques.setBounds(70,30,980,30);
        ques.setFont(new Font("Roboto Slab", Font.PLAIN,25));
        add(ques);
        questions[0][0] = "What is the capital of India?";
        questions[0][1] = "Mumbai";
        questions[0][2] = "Delhi";
        questions[0][3] = "Kolkata";
        questions[0][4] = "Chennai";

        questions[1][0] = "What is the national animal of India?";
        questions[1][1] = "Lion";
        questions[1][2] = "Elephant";
        questions[1][3] = "Tiger";
        questions[1][4] = "Rhinoceros";

        questions[2][0] = "What is the national flower of India?";
        questions[2][1] = "Lotus";
        questions[2][2] = "Rose";
        questions[2][3] = "Sunflower";
        questions[2][4] = "Tulip";

        questions[3][0] = "What is the national Epic of India?";
        questions[3][1] = "Bhagvad Gita";
        questions[3][2] = "Ramayana";
        questions[3][3] = "The Vedas";
        questions[3][4] = "Mahabharata";

        questions[4][0] = "Which other country has the same national flower as India?";
        questions[4][1] = "Thailand";
        questions[4][2] = "Malaysia";
        questions[4][3] = "The Netherlands";
        questions[4][4] = "Vietnam";

        questions[5][0] = "Which country has Ganesha printed on their national currency?";
        questions[5][1] = "Sri Lanka";
        questions[5][2] = "Indonesia";
        questions[5][3] = "Japan";
        questions[5][4] = "Myanmar";

        questions[6][0] = "Which is the largest country in the world?";
        questions[6][1] = "Brazil";
        questions[6][2] = "United States of America";
        questions[6][3] = "Russia";
        questions[6][4] = "India";

        questions[7][0] = "Which is the most populous country in the world?";
        questions[7][1] = "India";
        questions[7][2] = "China";
        questions[7][3] = "United States of America";
        questions[7][4] = "Japan";

        questions[8][0] = "Which significant latitude crosses through the centre of India?";
        questions[8][1] = "Equator";
        questions[8][2] = "Tropic of Cancer";
        questions[8][3] = "Tropic of Capricorn";
        questions[8][4] = "Prime Meridian";

        questions[9][0] = "Which country does not share border with India?";
        questions[9][1] = "Pakistan";
        questions[9][2] = "Japan";
        questions[9][3] = "Bangladesh";
        questions[9][4] = "Nepal";
        answers[0][1] = "Delhi";
        answers[1][1] = "Tiger";
        answers[2][1] = "Lotus";
        answers[3][1] = "Mahabharata";
        answers[4][1] = "Vietnam";
        answers[5][1] = "Indonesia";
        answers[6][1] = "Russia";
        answers[7][1] = "India";
        answers[8][1] = "Tropic of Cancer";
        answers[9][1] = "Japan";

        opt1= new JRadioButton("Option1");
        opt1.setBounds(70,100,700,50);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Roboto Slab", Font.PLAIN,25));
        add(opt1);
        opt2= new JRadioButton("Option2");
        opt2.setBounds(70,200,700,50);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Roboto Slab", Font.PLAIN,25));
        add(opt2);
        opt3= new JRadioButton("Option3");
        opt3.setBounds(70,300,700,50);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Roboto Slab", Font.PLAIN,25));
        add(opt3);
        opt4= new JRadioButton("Option4");
        opt4.setBounds(70,400,700,50);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Roboto Slab", Font.PLAIN,25));
        add(opt4);
        options= new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        next=new JButton("NEXT");
        next.setBounds(440,550,140,50);
        next.setFont(new Font("Roboto Slab", Font.BOLD,25));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit=new JButton("SUBMIT");
        submit.setBounds(770,550,140,50);
        submit.setFont(new Font("Roboto Slab", Font.BOLD,25));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        begin(count);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            repaint();
            ans_given=1;
            if(options.getSelection()==null)
            {
                userans[count][0]="";
            }
            else
            {
                userans[count][0]=options.getSelection().getActionCommand();
            }
            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            begin(count);
        }

        else if(ae.getSource()==submit)
        {
            ans_given=1;
            if(options.getSelection()==null)
            {
                userans[count][0]="";
            }
            else
            {
                userans[count][0]=options.getSelection().getActionCommand();
            }
            for(int i=0;i<userans.length;i++)
            {
                if(userans[i][0] == answers[i][1])
                {
                    score+=1;
                }
            }
            setVisible(false);
            new Score(name,score);
        }
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        String time="Time left: "+timer+" seconds";
        g.setColor((Color.RED));
        g.setFont(new Font("Roboto Slab",Font.BOLD,25));
        if(timer>0)
        {
            g.drawString(time,70,610);
        }
        else
        {
            g.drawString("Times UP!!",70,610);
        }
        --timer;
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        if(ans_given==1)
        {
            ans_given=0;
            timer=20;
        }
        else if(timer<0)
        {
            timer=20;
            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9)
            {
                if(options.getSelection()==null)
                {
                    userans[count][0]="";
                }
                else
                {
                    userans[count][0]=options.getSelection().getActionCommand();
                }
                for(int i=0;i<userans.length;i++)
                {
                    if(userans[i][0]==answers[i][1])
                    {
                        score+=1;
                    }
                }
                setVisible(false);
                new Score(name,score);
            }
            else
            {
                if(options.getSelection()==null)
                {
                    userans[count][0]="";
                }
                else
                {
                    userans[count][0]=options.getSelection().getActionCommand();
                }
                count++;
                begin(count);
            }
        }
    }
    public void begin(int count)
    {
        qno.setText(""+(count+1)+". ");
        ques.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        options.clearSelection();

    }
    public static void main(String[]args)
    {
        new Quiz("user");
    }
}
