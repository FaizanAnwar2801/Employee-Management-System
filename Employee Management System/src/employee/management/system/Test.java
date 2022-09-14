package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame implements ActionListener{
    
    Test(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel title =  new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        title.setBounds(300 , 25 , 1200 , 60);
        title.setFont(new Font("Times New Roman" , Font.BOLD , 30));
        title.setForeground(Color.WHITE);
        add(title);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1080, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 , 0 , 1050 , 600);
        add(image);
        
        JButton B1 = new JButton("START");
        B1.setBounds(450 , 500 ,200 , 50 );
        B1.setBackground(Color.LIGHT_GRAY);
        B1.addActionListener(this);
        add(B1);
        
        setSize(1080 , 650);
        setLocation(120 , 20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[])
    {
        new Test();
    }
    
}
