package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Registration {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");  
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/whatsapp","root","");  
		
		if (con != null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("Not Connected");
		}
		Statement statement=con.createStatement();
	
		//public void regForm() {
		
		JFrame f=new JFrame("Registration");
	    f.getContentPane().setBackground(Color.orange);
		f.setSize(500,500);

	//Labels
		JLabel h,l1,l2,l3,l4,l5,l6,l7;
		h=new JLabel("Registration Form");
	    Font fo = new Font("TimesRoman",Font.BOLD,20);
	    h.setFont(fo);
		h.setForeground(Color.DARK_GRAY);
		h.setBounds(175,15,250,30);
		l1=new JLabel("First Name	:");
	    l1.setBounds(50,50, 100,30);  
	    l2=new JLabel("Last Name	:");
	    l2.setBounds(50,100, 100,30);  
	    l3=new JLabel("User Name	:");
	    l3.setBounds(50,150, 100,30);  
	    l4=new JLabel("Password	:");
	    l4.setBounds(50,200, 100,30);  
	    l5=new JLabel("Confirm Password	:");
	    l5.setBounds(50,250, 120,30);  
	    l6=new JLabel("Phone Number	:");
	    l6.setBounds(50,300, 100,30);  
	    l7=new JLabel("E-mail ID	:");
	    l7.setBounds(50,350, 100,30);  
		f.add(h);f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);
		
	//Textfields for inputs
		JTextField t1,t2,t3,t6,t7;  
	    t1=new JTextField();  
	    t1.setBounds(300,50, 150,30);  
	    t2=new JTextField();  
	    t2.setBounds(300,100, 150,30); 
	    t3=new JTextField();  
	    t3.setBounds(300,150, 150,30); 
	    JPasswordField t4=new JPasswordField();	//password
	    JPasswordField t5=new JPasswordField(); 
	    t4.setBounds(300,200, 150,30); 
	    t5.setBounds(300,250, 150,30); 
	    t6=new JTextField();  
	    t6.setBounds(300,300, 150,30); 
	    t7=new JTextField();  
	    t7.setBounds(300,350, 150,30); 
	    f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);f.add(t7);
	    
	 //Button
	    JButton b=new JButton("REGISTER");
	    b.setBackground(Color.cyan);
		b.setBounds(150,400,150,50);
		f.add(b);

	//action listener of register button
		b.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				    String s1=t1.getText();
				    String s2=t2.getText();
				    String s3=t3.getText();
				    String s4=t4.getText();
				    String s5=t5.getText();
				    String s6=t6.getText();
				    String s7=t7.getText();
				    if(s4.equals(s5))
				    {
				
				    	try {

				    			statement.executeUpdate("insert into registration(`fname`, `lname`, `username`, `pwd`, `repwd`, `phone`, `mail`) values('"
									+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')");
						
				    			JOptionPane.showMessageDialog(null,"Registered Successfully");
				    		} 
				    	catch (SQLException e1) {
				
				    			System.out.println("Error in updation");
				    	}
				    }
				    else
				    	JOptionPane.showMessageDialog(null,"Please try again..\nPassword doesn't match");

			}	    
		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
		}
	}

