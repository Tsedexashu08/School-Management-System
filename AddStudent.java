import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddStudent extends JFrame {
    private JLabel full_name;
    private JLabel Age;
    private JLabel gender;
    private JLabel person_responsible;
    private JLabel relation;
    private JLabel phone_no;
    private JLabel gradelvl;
    private JLabel Adress;
    private JLabel Back;
    private JLabel StudReg;
    private JLabel all;
    private JTextField fname_textfeild;
    private JTextField age_textfield;
    private JComboBox gender_choices;
    private JTextField P_responsible_textfield;
    private JComboBox relation_choices;
    private JTextField phone_textfeild;
    private JComboBox gradelvl_choice;
    private JTextField adressT;
    private JButton sub;

    Font f1 = new Font("MV Boli",Font.BOLD,44);
    Font f2 = new Font("Arial", Font.BOLD,25);

    AddStudent() {

    setSize(1550, 800);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLayout(null);

            ImageIcon backg = new ImageIcon(ClassLoader.getSystemResource("AddStudent Background.png"));
            Image img = backg.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
            ImageIcon backg1 = new ImageIcon(img);

            all = new JLabel();
            all.setLayout(null);
            all.setSize(1550, 800);

            StudReg = new JLabel("Student's Registration");
            StudReg.setFont(f1);
            StudReg.setBounds(600, 40, 2400, 65);

            full_name = new JLabel("Full Name:");
            full_name.setFont(f2);
            full_name.setBounds(470, 200, 150, 30);

            fname_textfeild = new JTextField();
            fname_textfeild.setBounds(600, 200, 300, 30);
            fname_textfeild.setFont(f2);

            Age = new JLabel("Age:");
            Age.setFont(f2);
            Age.setBounds(540, 250, 100, 30);

            age_textfield = new JTextField();
            age_textfield.setBounds(600, 250, 300, 30);
            age_textfield.setFont(f2);

            gender = new JLabel("Sex:");
            gender.setFont(f2);
            gender.setBounds(540, 300, 250, 30);

            String genders[]={"Choose gender","Male","Female"};
            gender_choices = new JComboBox(genders);
            gender_choices.setBounds(600, 300, 300, 30);
            gender_choices.setFont(f2);

            person_responsible = new JLabel("Person Responsible:");
            person_responsible.setFont(f2);
            person_responsible.setBounds(350, 350, 250, 30);

            P_responsible_textfield = new JTextField();
            P_responsible_textfield.setBounds(600, 350, 300, 30);
            P_responsible_textfield.setFont(f2);

            String relationship[]={"choose relation","Parent","Guardian","Other"};
            relation = new JLabel("Relation:");
            relation.setFont(f2);
            relation.setBounds(490, 400, 250, 30);

            relation_choices = new JComboBox(relationship);
            relation_choices.setBounds(600, 400, 300, 30);
            relation_choices.setFont(f2);

            phone_no = new JLabel("Phone number:");
            phone_no.setFont(f2);
            phone_no.setBounds(410, 450, 200, 30);

            phone_textfeild = new JTextField();
            phone_textfeild.setBounds(600, 450, 300, 30);
            phone_textfeild.setFont(f2);

            gradelvl = new JLabel("Grade of registration:");
            gradelvl.setFont(f2);
            gradelvl.setBounds(340, 500, 250, 30);

           String grades[]={"choose grade level","1","2","3","4","5","6","7","8","9","10","11","12"};
            gradelvl_choice = new JComboBox(grades);
            gradelvl_choice.setBounds(600, 500, 300, 30);
            gradelvl_choice.setFont(f2);

            Adress = new JLabel("Address:");
            Adress.setFont(f2);
            Adress.setBounds(480, 550, 150, 30);

            adressT = new JTextField();
            adressT.setBounds(600, 550, 300, 30);
            adressT.setFont(f2);

            sub = new JButton("Submit");
            sub.setFont(f2);
            sub.setBounds(680, 680, 150, 40);
            sub.setFocusable(false);
            sub.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new DB_functions().execute("insert into students(Full_Name,Age,Gender,Grade,Address,Person_responsible,Relation,Phone_no) values ("+"'"+fname_textfeild.getText()+"'"+","+age_textfield.getText()+","+"'"+gender_choices.getSelectedItem()+"'"+","+"'"+gradelvl_choice.getSelectedItem()+"'"+","+"'"+adressT.getText()+"'"+","+"'"+P_responsible_textfield.getText()+"'"+","+"'"+relation_choices.getSelectedItem()+"'"+","+"'"+phone_textfeild.getText()+"'"+")");
                    JOptionPane.showMessageDialog(null,fname_textfeild.getText()+" Has been registered successfully!");

                }
            });

            Back = new JLabel("Back");
            Back.setFont(f1);
            Back.setForeground(Color.RED);
            Back.setBounds(1350, 20, 400, 65);
            Back.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    StudentModule obj = new StudentModule();
                    obj.setVisible(true);
                    dispose();
                }
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });

            all.add(full_name);
            all.add(fname_textfeild);
            all.add(Age);
            all.add(age_textfield);
            all.add(gender);
            all.add(gender_choices);
            all.add(person_responsible);
            all.add(P_responsible_textfield);
            all.add(relation);
            all.add(relation_choices);
            all.add(phone_no);
            all.add(phone_textfeild);
            all.add(gradelvl);
            all.add(gradelvl_choice);
            all.add(Adress);
            all.add(adressT);
            all.add(StudReg);
            all.add(sub);
            all.add(Back);
            all.setIcon(backg1);
            add(all);
            setVisible(true);
        }
        public static void main(String[] args) {
        new AddStudent();
    }

}
