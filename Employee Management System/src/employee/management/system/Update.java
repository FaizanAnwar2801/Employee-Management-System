package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;

public class Update extends JFrame implements ActionListener  {
  
    
    JTextField tfeducation , tffname , tfaddress , tfphone , tfemail , tfsalary , tfdesgn , tfaddhar;
    JLabel lblempId;
    JButton Add , Back;
    String empId;
    
    Update(String empId)
    {
        this.empId = empId;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel AddEmp =  new JLabel("UPDATE EMPLOYEE DETAIL");
        AddEmp.setBounds(250 , 25 , 700 , 30);
        AddEmp.setFont(new Font("SAN_SERIF" , Font.BOLD , 30));
        AddEmp.setForeground(Color.BLACK);
        add(AddEmp);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50 , 150, 150 , 30);
        labelname.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labelname);
        
        
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200 , 150 , 150 , 30);
        add(lblname);
        
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400 , 150, 150 , 30);
        labelfname.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600 , 150 , 150 , 30);
        add(tffname);
        
        
        JLabel labeldob = new JLabel("D.O.B");
        labeldob.setBounds(50 , 200, 150 , 30);
        labeldob.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob .setBounds(200 ,200 ,150 , 30);
        add(lbldob );
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400 , 200, 150 , 30);
        labelsalary.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600 , 200 , 150 , 30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50 , 250, 150 , 30);
        labeladdress.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200 , 250 , 150 , 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400 , 250, 150 , 30);
        labelphone.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600 , 250 , 150 , 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("E-Mail");
        labelemail.setBounds(50 , 300, 150 , 30);
        labelemail.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200 , 300 , 150 , 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Qualification");
        labeleducation.setBounds(400 , 300, 150 , 30);
        labeleducation.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600 , 300 , 150 , 30);
        add(tfeducation);
        
        JLabel labeldesg = new JLabel("Desgn");
        labeldesg.setBounds(50 , 350, 150 , 30);
        labeldesg.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labeldesg);
        
        tfdesgn = new JTextField();
        tfdesgn.setBounds(200 , 350 , 150 , 30);
        add(tfdesgn);
        
        JLabel labeladdno = new JLabel("Aadhar");
        labeladdno.setBounds(400 , 350, 150 , 30);
        labeladdno.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labeladdno);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600 , 350 , 150 , 30);
        add(lblaadhar);
       
        JLabel labelEmpid = new JLabel("Employee ID");
        labelEmpid.setBounds(50 , 400, 150 , 30);
        labelEmpid.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labelEmpid);
        
        lblempId = new JLabel();
        lblempId.setBounds(200 , 400, 150 , 30);
        lblempId.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(lblempId);
        
        try
        {
            Conn c = new Conn();
            String query = "Select * from employee where empId ='"+empId+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesgn.setText(rs.getString("designation"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        Add = new JButton("UPDATE DETAILS");
        Add.setBounds(250 , 500 ,150 , 40);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.addActionListener(this);
        add(Add);
        
        Back = new JButton("BACK");
        Back.setBounds(450 , 500 ,150 , 40 );
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        setSize(900 , 600);
        setLocation(180 , 20);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== Add)
        {
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String desgn = tfdesgn.getText();
   
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"' ,  salary = '"+salary+"', address = '"+address+"' , phone = '"+phone+"', email = '"+email+"' , education = '"+education+"' , designation = '"+desgn+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Sucessfully");
                setVisible(false);
                new Homepage();
            }catch(Exception e){
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
        new Update("");
    }
}