package bankmanagement;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton signIN,clear,signUP;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    public Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image i5=i4.getImage().getScaledInstance(800, 480,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0,0,800,480);
        add(image);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png" ));
        Image i2= i1.getImage().getScaledInstance(100,100,   Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel label=new JLabel(i3 );
        label.setBounds(600, 40, 100, 100);
        image.add(label);
        
        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        image.add(text);
        
        JLabel cardNo=new JLabel("CARD NO:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        image.add(cardNo); 
        cardTextField =new JTextField();
        cardTextField.setBounds(300, 150,250, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14)); 
        image.add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        image.add(pin);  
        pinTextField =new JPasswordField();
        pinTextField.setBounds(300, 220 ,250, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14)); 
        image.add(pinTextField);
        
        
        signIN=new JButton("SIGN IN");
        signIN.setBounds(300, 300, 100, 30);
        signIN.setBackground(Color.black);
        signIN.setForeground(Color.white);
        signIN.addActionListener(this); 
        image.add(signIN);
        
        clear=new JButton("CLEAR");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this); 
        image.add(clear); 
        
        signUP=new JButton("SIGN UP");
        signUP.setBounds(300, 350, 250, 30);
        signUP.setBackground(Color.black);
        signUP.setForeground(Color.white);
        signUP .addActionListener(this); 
        image.add(signUP); 
        
        
        //getContentPane().setBackground(Color.white); 
        //add(label);   
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
   
    @Override
    public void actionPerformed(ActionEvent  ae){
        if(ae.getSource()== clear){
         cardTextField.setText("");
         pinTextField.setText("");
        }
        else if(ae.getSource()==signIN){
            Conn c=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardNumber ='"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or pin");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signUP){
            setVisible(false);
            new Signup1().setVisible(true);
        }
        
    }
   public static void main(String [] args){
        new Login();
}
    
}
