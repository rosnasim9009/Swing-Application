package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Registration {
	public static void main(String[] args) {
		JFrame f=new JFrame("Registration");
	    f.getContentPane().setBackground(Color.yellow);
		f.setSize(500,700);

	//Labels
		JLabel h,l1,l2,l3,l4,l5,l6,l7;
		h=new JLabel("Registration Form");
		h.setForeground(Color.red);
		h.setBounds(175,15,150,30);
		l1=new JLabel("First Name	:");
	    l1.setBounds(50,50, 100,30);  
	    l2=new JLabel("Last Name	:");
	    l2.setBounds(50,100, 100,30);  
	    l3=new JLabel("User Name	:");
	    l3.setBounds(50,150, 100,30);  
	    l4=new JLabel("Password	:");
	    l4.setBounds(50,200, 100,30);  
	    l5=new JLabel("Re-type Passwod	:");
	    l5.setBounds(50,250, 120,30);  
	    l6=new JLabel("Phone Number	:");
	    l6.setBounds(50,300, 100,30);  
	    l7=new JLabel("E-mail ID	:");
	    l7.setBounds(50,350, 100,30);  
		f.add(h);f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);
		
	//Textfields
		JTextField t1,t2,t3,t4,t5,t6,t7;  
	    t1=new JTextField();  
	    t1.setBounds(300,50, 100,30);  
	    t2=new JTextField();  
	    t2.setBounds(300,100, 100,30); 
	    t3=new JTextField();  
	    t3.setBounds(300,150, 100,30); 
	    t4=new JTextField();  
	    t4.setBounds(300,200, 100,30); 
	    t5=new JTextField();  
	    t5.setBounds(300,250, 100,30); 
	    t6=new JTextField();  
	    t6.setBounds(300,300, 100,30); 
	    t7=new JTextField();  
	    t7.setBounds(300,350, 100,30); 
	    f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);f.add(t7);
	    
	 //Button
	    JButton b=new JButton("SUBMIT");
	    b.setBackground(Color.cyan);
		f.add(b);
		b.setBounds(150,400,150,50);

	//displaying inputs
		JTextArea f1=new JTextArea();
		f1.setBackground(Color.pink);
	    f1.setBounds(125,500, 200,120);  
		b.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
	            f1.setText("  First Name	: "+t1.getText()+"\n  Last Name	: "+t2.getText()+"\n  Username	: "+t3.getText()+"\n  Password	: "+t4.getText()+
	            		"\n  Phone Number: "+t6.getText()+"\n  E-mail ID	: "+t7.getText());
	           
			}
		});
		f.add(f1);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
	}
}
