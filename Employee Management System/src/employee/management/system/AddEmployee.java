package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener  {
    Random ran = new Random();
    int num = ran.nextInt(999999);
    
    JTextField tfname , tffname , tfaddress , tfphone , tfemail , tfsalary , tfdesgn , tfaddhar;
    JLabel lblempId;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JButton Add , Back;
    
    AddEmployee()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel AddEmp =  new JLabel("ADD EMPLOYEE DETAIL");
        AddEmp.setBounds(250 , 25 , 700 , 30);
        AddEmp.setFont(new Font("SAN_SERIF" , Font.BOLD , 30));
        AddEmp.setForeground(Color.BLACK);
        add(AddEmp);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50 , 150, 150 , 30);
        labelname.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labelname);
        
        
        
        tfname = new JTextField();
        tfname.setBounds(200 , 150 , 150 , 30);
        add(tfname);
        
        
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
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200 ,200 ,150 , 30);
        add(dcdob);
        
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
        
        String courses[] = {"BTECH" , "BSC" , "BCA" ,"BBA" ,"BA" , "MTECH" , "MSC" , "MCA" ,"MBA", "MA","PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600 , 300 , 150 , 30);
        add(cbeducation);
        
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
        
        tfaddhar = new JTextField();
        tfaddhar.setBounds(600 , 350 , 150 , 30);
        add(tfaddhar);
       
        JLabel labelEmpid = new JLabel("Employee ID");
        labelEmpid.setBounds(50 , 400, 150 , 30);
        labelEmpid.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(labelEmpid);
        
        lblempId = new JLabel("" + num);
        lblempId.setBounds(200 , 400, 150 , 30);
        lblempId.setFont(new Font("SERIF" , Font.PLAIN , 20));
        add(lblempId);
        
        Add = new JButton("ADD DETAILS");
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String)cbeducation.getSelectedItem();
            String desgn = tfdesgn.getText();
            String aadhar = tfaddhar.getText();
            String empId = lblempId.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"' , '"+fname+"' , '"+dob+"' , '"+salary+"', '"+address+"' , '"+phone+"', '"+email+"' , '"+education+"' , '"+desgn+"' , '"+aadhar+"' , '"+empId+"'  )";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Sucessfully");
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
        new AddEmployee();
    }
}
