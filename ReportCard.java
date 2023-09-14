import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportCard extends JFrame {
    ImageIcon backg = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
    Image img = backg.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
    ImageIcon backg1 = new ImageIcon(img);
    private  JLabel all=new JLabel();
    private JLabel instructions=new JLabel("Input Student Name class and marks");
    private JLabel StudentName=new JLabel("Student Name:");
    private JTextField nameTextfield=new JTextField();
    private JLabel grade=new JLabel("Grade:");
   private JLabel geo=new JLabel("Geography:");
   private JTextField geo_tf=new JTextField();
    private JLabel history=new JLabel("History:");
    private JTextField his_tf=new JTextField();
    private JLabel english=new JLabel("English:");
    private JTextField eng_tf=new JTextField();
    private JLabel maths=new JLabel("Maths:");
    private JButton back=new JButton("Back");
    private JButton update=new JButton("Update");
    private JButton view=new JButton("View results");
    private JTextField maths_tf=new JTextField();
    private JLabel hpe=new JLabel("HPE:");
    private JTextField hpe_tf=new JTextField();
    private JLabel phy=new JLabel("Physics:");
    private JTextField phy_tf=new JTextField();
    private JLabel chem=new JLabel("Chemistry:");
    private JTextField chem_tf=new JTextField();
    private JLabel bio=new JLabel("Biology:");
    private JTextField bio_tf=new JTextField();
    private JLabel conduct=new JLabel("Conduct:");
    private String behavior[]={"A","B","C","D","Needs improvement"};
   private JComboBox condct=new JComboBox<>(behavior);
    private String gradeLvls[]={"1st Grade","2nd Grade","3rd Grade","4th Grade","5th Grade","6th Grade","7th Grade","8th Grade","9th Grade","10th Grade","11th Grade","12th Grade"};
    private JComboBox gradelvl=new JComboBox<>(gradeLvls);
    private JButton submit=new JButton("Submit");
    Font f1 = new Font("MV Boli",Font.PLAIN,30);

    Font f2 = new Font("Arial", Font.BOLD,35);
    public static double Average( int[] num) {
        double avg,sum=0;
        for(int i=0;i<num.length;i++){sum+=num[i];}
        avg=sum/8;
        return avg;
    }

    ReportCard(){
        buttons button=new buttons();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        all.setSize(1550,800);
        setSize(1550,800);
        all.setLayout(null);
        setVisible(true);
        instructions.setBounds(300,5,1200,60);
        StudentName.setBounds(150,120,300,35);
        nameTextfield.setBounds(450,120,250,35);
        grade.setBounds(300,170,200,35);
        gradelvl.setBounds(450,170,250,35);
        geo.setBounds(210,215,235,35);
        geo_tf.setBounds(450,215,250,35);
        history.setBounds(275,270,200,35);
        his_tf.setBounds(450,270,250,35);
        english.setBounds(275,320,200,35);
        eng_tf.setBounds(450,320,250,35);
        maths.setBounds(300,370,200,35);
        maths_tf.setBounds(450,370,250,35);
        phy.setBounds(275,420,200,35);
        phy_tf.setBounds(450,420,250,35);
        chem.setBounds(235,470,250,35);
        chem_tf.setBounds(450,470,250,35);
        bio.setBounds(275,520,200,35);
        bio_tf.setBounds(450,520,250,35);
        hpe.setBounds(335,570,200,35);
        hpe_tf.setBounds(450,570,250,35);
        conduct.setBounds(270,620,180,35);
        condct.setBounds(450,620,250,35);
        submit.setBounds(880,195,300,45);
        view.setBounds(880,295,300,45);
        update.setBounds(880,395,300,45);
        back.setBounds(880,495,300,45);
        update.setFont(f1);
        view.setFont(f1);
        back.setFont(f1);

        instructions.setFont(f2);
        StudentName.setFont(f2);
        nameTextfield.setFont(f1);
        gradelvl.setFont(f1);
        grade.setFont(f2);
        geo_tf.setFont(f1);
        geo.setFont(f2);
        his_tf.setFont(f1);
        history.setFont(f2);
        eng_tf.setFont(f1);
        english.setFont(f2);
        maths_tf.setFont(f1);
        maths.setFont(f2);
        phy_tf.setFont(f1);
        phy.setFont(f2);
        chem_tf.setFont(f1);
        chem.setFont(f2);
        bio_tf.setFont(f1);
        bio.setFont(f2);
        hpe_tf.setFont(f1);
        hpe.setFont(f2);
        condct.setFont(f2);
        conduct.setFont(f2);
        submit.setFont(f1);
        view.addActionListener(button);
        submit.addActionListener(button);
        update.addActionListener(button);
        back.addActionListener(button);

        all.add(instructions);
       all.add(StudentName);
        all.add(nameTextfield);
        all.add(grade);
        all.add(gradelvl);
        all.add(geo);
        all.add(geo_tf);
        all.add(history);
        all.add(his_tf);
        all.add(english);
        all.add(eng_tf);
        all.add(maths);
        all.add(maths_tf);
        all.add(phy);
       all.add(phy_tf);
        all.add(chem);
        all.add(chem_tf);
        all.add(bio);
        all.add(bio_tf);
        all.add(hpe);
        all.add(hpe_tf);
        all.add(conduct);
        all.add(condct);
        all.add(submit);
        all.add(view);
        all.add(update);
       all.add(back);
       all.setIcon(backg1);
       add(all);
    }

    public static void main(String[] args) {
        new ReportCard();
    }
    class buttons implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==submit){
                int marks[]={Integer.parseInt(geo_tf.getText()),Integer.parseInt(his_tf.getText()),Integer.parseInt(eng_tf.getText()),Integer.parseInt(maths_tf.getText()),Integer.parseInt(phy_tf.getText()),Integer.parseInt(chem_tf.getText()),Integer.parseInt(bio_tf.getText()),Integer.parseInt(hpe_tf.getText())};
                new DB_functions().execute("insert into results values("+"'"+nameTextfield.getText()+"'"+","+"'"+gradelvl.getSelectedItem()+"'"+","+Integer.parseInt(geo_tf.getText())+","+Integer.parseInt(his_tf.getText())+","+Integer.parseInt(eng_tf.getText())+","+Integer.parseInt(maths_tf.getText())+","+Integer.parseInt(phy_tf.getText())+","+Integer.parseInt(chem_tf.getText())+","+Integer.parseInt(bio_tf.getText())+","+Integer.parseInt(hpe_tf.getText())+","+"'"+condct.getSelectedItem()+"'"+","+Average(marks)+")");
                JOptionPane.showMessageDialog(null,nameTextfield.getText()+"'s marks were submitted successfully!");
            } else if (e.getSource()==view) {
                new DB_functions().displayResults("select * from results");
            } else if (e.getSource()==back) {
                new Welcome();
                dispose();
            } else if (e.getSource()==update) {
                new updateResult();
                dispose();
            }
        }
    }
}
