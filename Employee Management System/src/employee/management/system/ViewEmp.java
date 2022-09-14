
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmp extends JFrame implements ActionListener{
    
    JTable table;
    Choice cempId;
    JButton search, print, update, back;
    
    ViewEmp()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        table = new JTable();
        
        JLabel searchlbl = new JLabel("SEARCH ");
        searchlbl.setBounds(20 ,20 ,150 ,20);
        add(searchlbl);
        
        cempId = new Choice();
        cempId.setBounds(180, 20, 150, 20);
        add(cempId);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next())
            {
                cempId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,500);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20 ,70, 80 ,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120 ,70, 80 ,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220 ,70, 80 ,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320 ,70, 80 ,20);
        back.addActionListener(this);
        add(back);
        
        setSize(900 , 600);
        setLocation(180 , 20);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()== search)
        {
            String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e )
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== print)
        {
            try
            {
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== update)
        {
            setVisible(false);
            new Update(cempId.getSelectedItem());
        }
        else
        {
            setVisible(false);
            new Homepage();
        }
     }
    
    public static void main(String args[])
    {
        new ViewEmp();
    }
    
}
