package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends Registration {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/whatsapp","root","");  
		if(con!=null)
			System.out.println("Connected");
		else
			System.out.println("Not connected");
		
		Statement st=con.createStatement();

		JFrame f=new JFrame();
	    f.getContentPane().setBackground(Color.PINK);
		f.setSize(600,400);
		
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\user_2\\Downloads\\images.png"));
        background.setBounds(20, 100, 200, 150);
        f.add(background);

    //labels
		JLabel h,user,pwd,p;
		h=new JLabel("User Login");
	    Font fo = new Font("TimesRoman",Font.BOLD,35);
	    h.setFont(fo);
	    h.setForeground(Color.blue);
		h.setBounds(225,20,200,40);
		
	    p=new JLabel("Hai..Login to get Started!!");
	    Font f1=new Font("",Font.CENTER_BASELINE,15);
	    p.setFont(f1);
	    p.setForeground(Color.white);
	    p.setBounds(215, 60, 300, 30);
	    
		user=new JLabel("Username");
		user.setBounds(250, 125, 150, 30);
		pwd=new JLabel("Password");
		pwd.setBounds(250, 175, 100, 30);
		f.add(h);f.add(p);f.add(user);f.add(pwd);

	//textfields
		JTextField t1=new JTextField();  
	    t1.setBounds(350,125,150,30);  
	    JPasswordField t2=new JPasswordField();  
	    t2.setBounds(350,175,150,30);
	    f.add(t1);f.add(t2);

	//login button
	    JButton b1=new JButton("LOGIN");
	    b1.setBackground(Color.cyan);
		b1.setBounds(155,300,125,50);
		f.add(b1);
		
	//register button
	    JButton b2=new JButton("REGISTRATION");
	    b2.setBackground(Color.cyan);
		b2.setBounds(300,300,125,50);
		f.add(b2);

		
	//login action event
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String u=t1.getText();
				String p=String.copyValueOf(t2.getPassword());
				int count=0;
				try {
						ResultSet rs=st.executeQuery("select username,pwd from registration");
						while(rs.next())
						{
				
							if(rs.getString(1).equals(u) && rs.getString(2).equals(p)) 
							{
								JOptionPane.showMessageDialog(null,"Login Success");
								count++;
								break;
							}
				
						}
						if(count==0)
							JOptionPane.showMessageDialog(null,"Invalid Username or Password\nPlease try again!!");
					}
					catch (SQLException e1) {
						//e1.printStackTrace();
						System.out.println("Error in Checking");
					}
				}
		});
		
		
		//register action event
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Registration.main(args);
					} 
					catch (ClassNotFoundException | SQLException e1) 
					{
						e1.printStackTrace();
					}				
			}
		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
	}
}