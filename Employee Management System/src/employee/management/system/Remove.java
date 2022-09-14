
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Remove extends JFrame implements ActionListener {
    
    Choice cempId;
    JButton delete , back;
    
    Remove()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("empId");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        cempId = new Choice();
        cempId.setBounds(180, 50, 150, 30);
        add(cempId);
        
        try
        {
            Conn c = new Conn();
            String query = "select * from employee ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempId.add(rs.getString("empId"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        try
        {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText("name");
                lblphone.setText("phone");
                lblemail.setText("email");
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempId.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            try
        {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    });
        
        delete = new JButton("DELETE");
        delete.setBounds(80 , 300 , 100 , 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("BACK");
        back.setBounds(220 , 300 , 100 , 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 , 0 , 1000 , 400);
        add(image);
        
        setSize(1000 , 400);
        setLocation(150 , 80);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()== delete)
        {
            try
            {
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cempId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Information Deleted Sucessfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else 
        {
            setVisible(false);
            new Homepage();
        }
     }
    
    
    public static void main(String args[])
    {
        new Remove();
    }
}
