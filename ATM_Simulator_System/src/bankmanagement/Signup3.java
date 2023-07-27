package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton savings,current,fixed,recurring;
    JCheckBox atm,mbanking,ebanking ,alerts,cheque,estatement,declaration;
    JButton submit,cancel;
    String formno;
    Signup3(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        // Account selection
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
         savings=new JRadioButton("Savings Account");
         savings.setBounds(100,180,200,20);
         savings.setFont(new Font("Raleway",Font.BOLD,16));
         savings.setBackground(Color.lightGray);
         add(savings);
         current=new JRadioButton("Current Account");
         current.setBounds(350,180,200,20);
         current.setFont(new Font("Raleway",Font.BOLD,16));
         current.setBackground(Color.lightGray);
         add(current);
         fixed=new JRadioButton("Fixed Deposit Account");
         fixed.setBounds(100,220,200,20);
         fixed.setFont(new Font("Raleway",Font.BOLD,16));
         fixed.setBackground(Color.lightGray);
         add(fixed);
         recurring=new JRadioButton("Recurring Deposit Account");
         recurring.setBounds(350,220,250,20);
         recurring.setFont(new Font("Raleway",Font.BOLD,16));
         recurring.setBackground(Color.lightGray);
         add(recurring);
         ButtonGroup r=new ButtonGroup();
         r.add(fixed);
         r.add(savings);
         r.add(current);
         r.add(recurring);
        // 
        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4546");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(350,300,300,30);
        add(number);
        JLabel cardDetail=new JLabel("Your 16 digit card number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100,330,200,20);
        add(cardDetail);
        
        JLabel pin=new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pinnumber=new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(350,370,200,30);
        add(pinnumber);
        JLabel pindetail=new JLabel("Your 4 digit PIN");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,200,20);
        add(pindetail);
        
        //service reqirement
        
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,300,30);
        add(services);
        atm =new JCheckBox("ATM");
        atm.setBounds(100, 500, 200,30);
        atm.setFont(new Font("Raleway",Font.BOLD,16));
        atm.setBackground(Color.lightGray);
        add(atm);
        ebanking =new JCheckBox("Internet Banking");
        ebanking .setBounds(350, 500, 200,30);
        ebanking .setFont(new Font("Raleway",Font.BOLD,16));
        ebanking .setBackground(Color.lightGray);
        add(ebanking );
        mbanking =new JCheckBox("Mobile Banking");
        mbanking .setBounds(100, 550, 200,30);
        mbanking.setFont(new Font("Raleway",Font.BOLD,16));
        mbanking.setBackground(Color.lightGray);
        add(mbanking);
        alerts =new JCheckBox("Email & SMS alerts");
        alerts.setBounds(350, 550, 200,30);
        alerts.setFont(new Font("Raleway",Font.BOLD,16));
        alerts.setBackground(Color.lightGray);
        add(alerts);
        cheque =new JCheckBox("Cheque BOOK");
        cheque.setBounds(100, 600, 200,30);
        cheque.setFont(new Font("Raleway",Font.BOLD,16));
        cheque.setBackground(Color.lightGray);
        add(cheque);
        estatement =new JCheckBox("e-Statement");
        estatement.setBounds(350, 600, 200,30);
        estatement.setFont(new Font("Raleway",Font.BOLD,16));
        estatement.setBackground(Color.lightGray);
        add(estatement);
        declaration =new JCheckBox("I hereby declare that all the information provided are correct to the best of my Knowledge.");
        declaration.setBounds(100, 660, 700,30);
        declaration.setFont(new Font("Raleway",Font.BOLD,12));
        declaration.setBackground(Color.lightGray);
        add(declaration); 
        //
        
        submit =new JButton("SUBMIT");
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.white);
        submit.setBounds(220,700,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);
        cancel =new JButton("CANCEL");
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.white);
        cancel.setBounds(460,700,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.lightGray);
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType="";
            if(savings.isSelected()){
                accountType="Savings Account";
            }
            else if(fixed.isSelected()){
                accountType="Fixed Deposit Account";
            }
            else if(recurring.isSelected()){
                accountType="Recurring Deposit Account";
            }
            else if(current.isSelected()){
                accountType="Current Account";
            }
            Random random=new Random();
            String cardnumber="" + Math.abs((random.nextLong()%90000000L) + 5040936000000000L);
            String pinnumber="" + Math.abs((random.nextLong()%9000L)+ 1000L);
            
            String facility="";
            if(atm.isSelected()){
                facility=facility + "ATM Card";
            }
            if(mbanking.isSelected()){
                facility=facility + "Mobile Banking";
            }
             if(ebanking.isSelected()){
                facility=facility + "Internet Banking";
            }
             if(alerts.isSelected()){
                facility=facility + "Email and SMS Alerts";
            }
             if(estatement.isSelected()){
                facility=facility + "e-Statement";
            }
             if(cheque.isSelected()){
                facility=facility + "Cheque Book";
            }
             String declare="";
             if(declaration.isSelected()){
                 declare="Selected";
             }
            try{
                if(accountType.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Select account type!");
                }
                else if(declare.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Declaration is required");
                }
                else{
                    Conn c=new Conn();
                    String query1="insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card No: "+cardnumber+"\n PIN: "+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }  
            
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String [] args){
        new Signup3("");
    }
}
