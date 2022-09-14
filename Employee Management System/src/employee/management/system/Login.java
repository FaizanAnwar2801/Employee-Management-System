
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername , tfpassword;
    
    Login(){
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setBounds(40, 20 ,100 , 30);
        add(lblUsername);
        
        tfusername =  new JTextField();
        tfusername.setBounds(150 , 20 , 150 , 30);
        add(tfusername);
        
        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setBounds(40, 70 ,100 , 30);
        add(lblPassword);
        
        tfpassword =  new JTextField();
        tfpassword.setBounds(150 , 70 , 150 , 30);
        add(tfpassword);
        
        JButton B2 = new JButton("LOGIN");
        B2.setBounds(150 , 140 ,150 , 30 );
        B2.setBackground(Color.LIGHT_GRAY);
        B2.addActionListener(this);
        add(B2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350 , 0 , 200 , 200);
        add(image);
        
        setSize(600 , 300);
        setLocation(350 , 200);
        setVisible(true);
    
}
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            
            String query = "select * from login where username ='"+username+"'and password = '"+password+"' ";
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Homepage();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}
