package bankmanagement;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Signup1 extends JFrame implements ActionListener {
    long random;
    JTextField nametextfield,fnametextfield,emailtextfield,addresstextfield,statetextfield,citytextfield,pincodetextfield;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JLabel formno,personalDetails,name,fname,dob,gender,address,city,state,pincode,marital,email;
    JDateChooser date;
     Signup1(){
         setLayout(null);
         setTitle("NEW ACCOUNT APPLICATION FORM - PAGE1");
         Random ran=new Random();
         random=Math.abs((ran.nextLong()%9000L)+1000L);
         
        formno= new JLabel("Application form no. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(150, 20, 600,40);
        add(formno);
        personalDetails= new JLabel("Page 1 : Personal Details ");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(250, 80, 350,30);
        add(personalDetails);
        
        name= new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100, 140, 100,30);
        add(name);
        nametextfield=new JTextField();
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);
        
        fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100, 190, 200,30);
        add(fname);
        fnametextfield=new JTextField();
        fnametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        fnametextfield.setBounds(300,190,400,30);
        add(fnametextfield);
        
        dob= new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100, 240, 200,30);
        add(dob);
        date=new JDateChooser();
        date.setBounds(300,240,400,30);
        date.setForeground(new Color(105,105,105));
        add(date);
        
        gender= new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100, 290, 200,30);
        add(gender);
        male=new JRadioButton("MALE");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.lightGray);
        add(male);
        female=new JRadioButton("FEMALE");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.lightGray);
        add(female);
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        email= new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100, 340, 200,30);
        add(email);
        emailtextfield=new JTextField();
        emailtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        emailtextfield.setBounds(300,340,400,30);
        add(emailtextfield);
        
        //marital Status
        marital= new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100, 390, 200,30);
        add(marital);
        married=new JRadioButton("MARRIED");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.lightGray);
        add(married);
        unmarried=new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.lightGray);
        add(unmarried);
        others=new JRadioButton("OTHER");
        others.setBounds(630,390,100,30);
        others.setBackground(Color.lightGray);
        add(others);
        ButtonGroup marraigegroup=new ButtonGroup();
        marraigegroup.add(married);
        marraigegroup.add(unmarried);
         marraigegroup.add(others);
         
        //address
        address= new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100, 440, 200,30);
        add(address);
        addresstextfield=new JTextField();
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);
        
        city= new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100, 490, 200,30);
        add(city);
        citytextfield=new JTextField();
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);
        
        state= new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100, 540, 200,30);
        add(state);
        statetextfield=new JTextField();
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);
        
        pincode= new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100, 590, 200,30);
        add(pincode);
        pincodetextfield=new JTextField();
        pincodetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pincodetextfield.setBounds(300,590,400,30);
        add(pincodetextfield);
        
        next=new JButton("NEXT");
        next.setBounds(620, 630, 80,30 );
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.lightGray);
         setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
     public void actionPerformed(ActionEvent ae){
         String formno=""+random;
         String name=nametextfield.getText();
         String fname=fnametextfield.getText();
         String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
         String gender=null;
         if(male.isSelected()){
             gender="Male";
         }
         else if(female.isSelected()){
             gender="Female";
         }
         String email=emailtextfield.getText();
         String marital=null;
         if(married.isSelected()){
             marital="Married";
         }
         else if(unmarried.isSelected()){
             marital="Unmarried";
         }
         else if(others.isSelected()){
             marital="Others";
         }
        String address=addresstextfield.getText();
         String state=statetextfield.getText();
         String city=citytextfield.getText();
         String pincode=pincodetextfield.getText();
         
         try{
             if(name.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Name is required");
             }
             else if(fname.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Father's Name is required");
             }
             else if(state.isEmpty()){
                 JOptionPane.showMessageDialog(null,"State is required");
             }
             else if(city.isEmpty()){
                 JOptionPane.showMessageDialog(null,"City is required");
             }
             else if(pincode.isEmpty()){
                 JOptionPane.showMessageDialog(null,"PIN CODE is required");
             }
             else if(address.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Address is required");
             }
             else if(address.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Address is required");
             }
             else{
                 Conn c=new Conn();
                 String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new Signup2(formno).setVisible(true);
             }
         }catch(Exception e){
             System.out.println(e);
         }
     }
    public static void main(String [] args){
        new Signup1();
    }
}
