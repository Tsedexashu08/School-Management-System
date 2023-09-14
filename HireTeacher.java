import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HireTeacher extends JFrame {
    JLabel full_name;
    JLabel Age;
    JLabel gender;
    JLabel years_of_exp;
    JLabel profession;
    JLabel phone_no;
    JLabel gradelvl;
    JLabel Back;
    JLabel StudReg;
    JLabel all;
    JTextField fname_textfeild;
    JTextField age_textfield;
    JComboBox gender_choices;
    JTextField exp_textfield;
    JComboBox professions;
    JTextField phone_textfeild;
    JComboBox gradelvl_choice;
    ButtonGroup group=new ButtonGroup();
    JButton sub;

    Font f1 = new Font("MV Boli",Font.BOLD,44);
    Font f2 = new Font("Arial", Font.BOLD,25);

    HireTeacher() {

        setSize(1550, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon backg = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
        Image img = backg.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
        ImageIcon backg1 = new ImageIcon(img);

        all = new JLabel();
        all.setLayout(null);
        all.setSize(1550, 800);

        StudReg = new JLabel("Teacher Hire");
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

        years_of_exp = new JLabel("years of experience:");
        years_of_exp.setFont(f2);
        years_of_exp.setBounds(350, 350, 250, 30);

        exp_textfield = new JTextField();
        exp_textfield.setBounds(600, 350, 300, 30);
        exp_textfield.setFont(f2);

        String proffession[]={"choose profession","English","Maths","Biology","Chemistry","Physics","History","Geography","HPE"};
        profession = new JLabel("Profession:");
        profession.setFont(f2);
        profession.setBounds(460, 400, 250, 30);

        professions = new JComboBox(proffession);
        professions.setBounds(600, 400, 300, 30);
        professions.setFont(f2);

        phone_no = new JLabel("Phone number:");
        phone_no.setFont(f2);
        phone_no.setBounds(410, 450, 200, 30);

        phone_textfeild = new JTextField();
        phone_textfeild.setBounds(600, 450, 300, 30);
        phone_textfeild.setFont(f2);

        gradelvl = new JLabel("Course Grade Level");
        gradelvl.setFont(f2);
        gradelvl.setBounds(340, 500, 250, 30);

        String grades[]={"choose grade level","1","2","3","4","5","6","7","8","9","10","11","12"};
        gradelvl_choice = new JComboBox(grades);
        gradelvl_choice.setBounds(600, 500, 300, 30);
        gradelvl_choice.setFont(f2);

        int salary=15000;


        sub = new JButton("Submit");
        sub.setFont(f2);
        sub.setBounds(680, 680, 150, 40);
        sub.setFocusable(false);

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DB_functions().execute("insert into teachers(Full_Name,Age,Gender,Grade_level,`Experience(in years)`,Profesion,salary,Phone_no) values ("+"'"+fname_textfeild.getText()+"'"+","+age_textfield.getText()+","+"'"+gender_choices.getSelectedItem()+"'"+","+"'"+gradelvl_choice.getSelectedItem()+"'"+","+exp_textfield.getText()+","+"'"+professions.getSelectedItem()+"'"+","+salary+","+"'"+phone_textfeild.getText()+"'"+")");
                JOptionPane.showMessageDialog(sub,fname_textfeild.getText()+" Has been registered successfully!");
                if(e.getSource()==sub){
                    String text = fname_textfeild.getText().trim();
                    if(text.isBlank()){
                        JOptionPane.showMessageDialog(null,"empty!");
                    }
                }

            }
        });

        Back = new JLabel("Back");
        Back.setFont(f1);
        Back.setForeground(Color.RED);
        Back.setBounds(1350, 20, 400, 65);
        Back.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TeacherModule obj = new TeacherModule();
                obj.setVisible(true);
                dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        all.add(full_name);
        all.add(fname_textfeild);
        all.add(Age);
        all.add(age_textfield);
        all.add(gender);
        all.add(gender_choices);
        all.add(years_of_exp);
        all.add(exp_textfield);
        all.add(profession);
        all.add(professions);
        all.add(phone_no);
        all.add(phone_textfeild);
        all.add(gradelvl);
        all.add(gradelvl_choice);

        all.add(StudReg);
        all.add(sub);
        all.add(Back);
        all.setIcon(backg1);
        add(all);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HireTeacher();
    }
    class but implements ActionListener{
        public void actionPerformed(ActionEvent e) {

        }
    }
}
