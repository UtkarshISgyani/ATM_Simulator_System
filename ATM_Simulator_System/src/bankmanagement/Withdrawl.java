package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener  {
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
        Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the Amount to be Withdrawn:  ");
        text.setBounds(180,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount=new JTextField();
        amount.setBounds(180,350,320,25);
        amount.setFont(new Font("System",Font.BOLD,22));
        image.add(amount);
        
        withdraw =new JButton("WITHDRAW");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back =new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);
        
        }
        @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==withdraw){
                String number=amount.getText();
                Date date=new Date();
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter the amount");
                }
                try{
                    Conn c=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+number+" withdrawn Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        
        }
    public static void main(String [] args){
        new Withdrawl("");
    }
    
}

