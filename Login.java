import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
    JButton start,update;
    JTextField namein;
    Login()
    {
        setSize(1000,600);
        setVisible(true);
        setLocation(287,82);
        setTitle("QUIZ APPLICATION");
        setLayout(null);
        //Adding image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/download.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,220,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(75,10,200,190);
        add(label);//Image added
        //Adding intro text next to image
        JLabel text=new JLabel("QUIZ TIME!");
        text.setBounds(425,100,400,40);
        text.setFont(new Font("Viner Hand ITC",Font.BOLD,35));
        add(text);//Intro text added
        //Name input
        JLabel namedis=new JLabel("YOUR NAME: ");
        namedis.setBounds(250,200,200,35);
        namedis.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(namedis);
        namein= new JTextField();
        namein.setBounds(425,200,300,35);
        namein.setFont(new Font("Arial",Font.PLAIN,17));
        add(namein);//Name input end

        //create start button
        start= new JButton("START");
        start.setBounds(300,275,150,50);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Sans Serif",Font.BOLD,20));
        start.addActionListener(this);
        add(start);
        //create update button
        update= new JButton("UPDATE");
        update.setBounds(500,275,150,50);
        update.setFont(new Font("Sans Serif",Font.BOLD,20));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[]args)
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
            String name=namein.getText();
            setVisible(false);
            new Rules(name);
        }
        else if(ae.getSource()==update)
        {

        }
    }
}
