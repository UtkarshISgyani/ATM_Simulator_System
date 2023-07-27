package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Ministatement extends JFrame{
    String pinnumber;
    Ministatement(String pinnumber){
        this.pinnumber=pinnumber;
        
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini =new JLabel();
        mini.setBounds(20,140,400,200 );
        add(mini);
        
        JLabel bank=new JLabel("Utkarsh Finance Bank");
        bank.setBounds(120,20,200,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0, 4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12, 16));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn c=new Conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'"); 
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                       bal+=Integer.parseInt(rs.getString("amount"));
                   }
                else{
                      bal-=Integer.parseInt(rs.getString("amount"));     
                }
            }
            balance.setText("The avialable balance in your account is RS "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String [] args){
        new Ministatement("");
    }
}
