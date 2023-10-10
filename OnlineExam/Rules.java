import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener
{
    String name;
    JButton start,cname;
    Rules(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900,750);
        setLocation(350,50);
        setVisible(true);

        JLabel text=new JLabel("Welcome "+name+". Get ready to start the QUIZ!");
        text.setBounds(75,50,1000,40);
        text.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        add(text);

        JLabel points=new JLabel();
        points.setBounds(75,100,800,450);
        points.setFont(new Font("Tahoma",Font.PLAIN,25));
        points.setText(
                      "<html>"+
                              "" +
                              "1. There are 10 questions in this quiz."+"<br><br>"+
                              "2. Each question carries 1 mark."+"<br><br>"+
                              "3. There is no negative marking."+"<br><br>"+
                              "4. You get 20 seconds to solve each question"+"<br><br>"+
                              "5. Best of luck with the Quiz. "+"<br><br>"+
                      "<html>"
                );
        add(points);

        start= new JButton("START!");
        start.setBounds(650,575,150,50);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Sans Serif",Font.BOLD,20));
        start.addActionListener(this);
        add(start);

        cname= new JButton("CHANGE NAME");
        cname.setBounds(100,575,200,50);
        cname.setBackground(Color.BLACK);
        cname.setForeground(Color.WHITE);
        cname.setFont(new Font("Sans Serif",Font.BOLD,20));
        cname.addActionListener(this);
        add(cname);
    }
    public static void main(String[] args)
    {
        new Rules("USER");
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cname)
        {
            setVisible(false);
            new Login();
        }
        else if(ae.getSource()==start)
        {
            setVisible(false);
            new Quiz(name);
        }
    }
}
