package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    JPasswordField newpintext,repintext;
    JButton change,back;
    String pinnumber;
    Pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel newpin=new JLabel("NEW PIN: ");
        newpin.setBounds(165,320,180,25);
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("System",Font.BOLD,16));
        image.add(newpin);
        newpintext =new JPasswordField();
        newpintext.setBounds(330,320,180,25);
        newpintext.setFont(new Font("",Font.BOLD,16));
        image.add(newpintext);
        
        JLabel repin=new JLabel("CONFIRM PIN: ");
        repin.setBounds(165,360,180,25);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("System",Font.BOLD,16));
        image.add(repin);
        repintext =new JPasswordField();
        repintext.setBounds(330,360,180,25);
        repintext.setFont(new Font("",Font.BOLD,16));
        image.add(repintext);
        
        back=new JButton("BACK");
        back.setBounds(165,485,150,30);
        back.addActionListener(this);
        image.add(back);
        
        change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String npin=newpintext.getText();
                String rpin=repintext.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"New pin and Confirm pin does not match");
                    return;
                }
                if(npin.equals("") || rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the pin");
                    return;
                }
               Conn c=new Conn();
               String query1="update bank set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
               String query2="update login set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
               String query3="update signup3 set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               c.s.executeUpdate(query3);
               JOptionPane.showMessageDialog(null,"PIN changed Successfully!");
               setVisible(false);
               new Transactions(rpin).setVisible(true);
               
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String [] args){
        new Pinchange("").setVisible(true);
    }
}
