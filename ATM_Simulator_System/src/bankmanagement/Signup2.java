package bankmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup2 extends JFrame implements ActionListener {
    JTextField aadharfield,pannotextfield;
    JButton next;
    JRadioButton accYes,accNo,sNo,sYes;
    JLabel additionalDetails,religion,category,income,education,occupation,aadhar,senior,existingAcc,panno,qualification;
    JComboBox selectIncome,selectReligion,selectCategory,selectQualification,selectOccupation;
    String formno;
     Signup2(String formno){
         this.formno=formno;
         setLayout(null);
         setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2");
         
        additionalDetails= new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(250, 80, 350,30);
        add(additionalDetails);
        
        religion= new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100, 140, 200,30);
        add(religion);
        String [] valReligion={"Hindu","Muslim","Sikh","Christian","Others"};
        selectReligion=new JComboBox(valReligion);
        selectReligion.setBounds(300,140,400,30);
        selectReligion.setBackground(Color.white);
        add(selectReligion);
        
        category= new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100, 190, 200,30);
        add(category);
        String [] valCategory={"General","OBC","SC","ST","OTHERS"};
        selectCategory=new JComboBox(valCategory);
        selectCategory.setBounds(300,190,400,30);
        selectCategory.setBackground(Color.white);
        add(selectCategory);
        
        income= new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100, 240, 200,30);
        add(income);
        String [] valIncome={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        selectIncome=new JComboBox(valIncome);
        selectIncome.setBounds(300,240,400,30);
        selectIncome.setBackground(Color.white);
        add(selectIncome);
        
        
        education= new JLabel("Education ");
        education.setFont(new Font("Raleway",Font.BOLD,22));
        education.setBounds(100, 290, 200,30);
        add(education);
        
        qualification= new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100, 315, 200,30);
        add(qualification);
        String [] valQualification={"Non-Graduate","Graduate","Post Graduation","Doctorate","Others"};
        selectQualification=new JComboBox(valQualification);
        selectQualification.setBounds(300,315,400,30);
        selectQualification.setBackground(Color.white);
        add(selectQualification);
        
        
        //Occupational Status
        occupation= new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100, 390, 200,30);
        add(occupation);
        String [] valOccupation={"Salaried","Self Employed","Business","Student","Retired","Others"};
        selectOccupation=new JComboBox(valOccupation);
        selectOccupation.setBounds(300,390,400,30);
        selectOccupation.setBackground(Color.white);
        add(selectOccupation);
       
         
        panno= new JLabel("PAN No: ");
        panno.setFont(new Font("Raleway",Font.BOLD,22));
        panno.setBounds(100, 440, 200,30);
        add(panno);
        pannotextfield=new JTextField();
        pannotextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pannotextfield.setBounds(300,440,400,30);
        add(pannotextfield);
        
        aadhar= new JLabel("Aadhaar No: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        aadhar.setBounds(100, 490, 200,30);
        add(aadhar);
        aadharfield=new JTextField();
        aadharfield.setFont(new Font("Raleway",Font.BOLD,14));
        aadharfield.setBounds(300,490,400,30);
        add(aadharfield);
        
        senior= new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Raleway",Font.BOLD,22));
        senior.setBounds(100, 540, 200,30);
        add(senior);
        sYes=new JRadioButton("YES");
        sYes.setBounds(300,540,100,30);
        sYes.setBackground(Color.lightGray);
        add(sYes);
        sNo=new JRadioButton("NO");
        sNo.setBounds(450,540,100,30);
        sNo.setBackground(Color.lightGray);
        add(sNo);
        ButtonGroup seniorgroup=new ButtonGroup();
        seniorgroup.add(sYes);
        seniorgroup.add(sNo);
         
        
        existingAcc= new JLabel("Existing Account: ");
        existingAcc.setFont(new Font("Raleway",Font.BOLD,22));
        existingAcc.setBounds(100, 590, 200,30);
        add(existingAcc);
        accYes=new JRadioButton("YES");
        accYes.setBounds(300,590,100,30);
        accYes.setBackground(Color.lightGray);
        add(accYes);
        accNo=new JRadioButton("NO");
        accNo.setBounds(450,590,100,30);
        accNo.setBackground(Color.lightGray);
        add(accNo);
        ButtonGroup existinggroup=new ButtonGroup();
        existinggroup.add(accYes);
        existinggroup.add(accNo);
        
        
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
         String sreligion= (String)selectReligion.getSelectedItem();
         String scategory=(String)selectCategory.getSelectedItem();
         String sincome=(String)selectIncome.getSelectedItem();
         String squalification=(String)selectQualification.getSelectedItem();
         String soccupation=(String)selectOccupation.getSelectedItem();
         String seniorcitizen=null;
         if(sYes.isSelected()){
             seniorcitizen="YES";
         }
         else if(sNo.isSelected()){
             seniorcitizen="NO";
         }
         String existingaccount=null;
         if(accYes.isSelected()){
             existingaccount="YES";
         }
         else if(accNo.isSelected()){
             existingaccount="NO";
         }
        String span=pannotextfield.getText();
         String saadhar=aadharfield.getText();
         
         try{
                 Conn c=new Conn();
                 String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+seniorcitizen+"','"+existingaccount+"','"+span+"','"+saadhar+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new Signup3(formno).setVisible(true);
             
         }catch(Exception e){
             System.out.println(e);
         }
     }
    public static void main(String [] args){
        new Signup2("");
    }
}

