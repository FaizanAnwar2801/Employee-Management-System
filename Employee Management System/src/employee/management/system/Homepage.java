
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Homepage extends JFrame implements ActionListener{
    JButton Add ,Update , View ,Remove;
    public Homepage()
    {
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1080, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 , 0 , 1080 , 650);
        add(image);
        
        JLabel homepage =  new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        homepage.setBounds(75 , 25 , 700 , 30);
        homepage.setFont(new Font("TAHOMA" , Font.BOLD , 30));
        homepage.setForeground(Color.BLACK);
        image.add(homepage);
        
        Add = new JButton("ADD EMPLOYEE");
        Add.setBounds(75 , 80 ,200 , 100 );
        Add.setBackground(Color.LIGHT_GRAY);
        Add.addActionListener(this);
        add(Add);
        
        View = new JButton("VIEW EMPLOYEES");
        View.setBounds(75 ,210 ,200 , 100 );
        View.setBackground(Color.LIGHT_GRAY);
        View.addActionListener(this);
        add(View);
        
        Update = new JButton("UPADTE EMPLOYEE");
        Update.setBounds(75 , 340  ,200 , 100 );
        Update.setBackground(Color.LIGHT_GRAY);
        Update.addActionListener(this);
        add(Update);
        
        Remove = new JButton("REMOVE EMPLOYEE");
        Remove.setBounds(75 , 470 ,200 , 100 );
        Remove.setBackground(Color.LIGHT_GRAY);
        Remove.addActionListener(this);
        add(Remove);
        
        setSize(1080 , 650);
        setLocation(120 , 20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== Add)
        {
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource()== View)
        {
            setVisible(false);
            new ViewEmp();
        }
        else if(ae.getSource()== Update)
        {
            setVisible(false);
            new ViewEmp();
        }
        else
        {
            setVisible(false);
            new Remove();
        }

    }
    
    public static void main(String args[])
    {
        new Homepage();
    }
}
