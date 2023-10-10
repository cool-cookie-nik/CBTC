import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener
{
    JButton replay,exit;
    Score(String name, int score)
    {
        setBounds(300,50,1000,750);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("SCORE!");
        heading.setBounds(400,50,200,50);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        add(heading);
        JLabel greeting = new JLabel("Thank you "+name+" for taking the test. Your result is shown below. ");
        greeting.setBounds(60,150,1000,50);
        greeting.setFont(new Font("Viner Hand ITC",Font.PLAIN,30));
        add(greeting);
        JLabel newscore = new JLabel(score+"/10");
        newscore.setBounds(425,300,200,80);
        newscore.setFont(new Font("Viner Hand ITC",Font.BOLD,60));
        add(newscore);
        exit= new JButton("EXIT");
        exit.setBounds(200,450,250,50);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Sans Serif",Font.BOLD,25));
        exit.addActionListener(this);
        add(exit);
        replay= new JButton("START AGAIN!");
        replay.setBounds(550,450,250,50);
        replay.setBackground(Color.BLACK);
        replay.setForeground(Color.WHITE);
        replay.setFont(new Font("Sans Serif",Font.BOLD,25));
        replay.addActionListener(this);
        add(replay);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
        }
        else if(ae.getSource()==replay)
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[]args)
    {
        new Score("user",0);
    }
}
