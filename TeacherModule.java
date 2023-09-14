import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TeacherModule extends JFrame {
    JLabel sm;
    JLabel all;
    JLabel back;
    JButton addTeacher;
    JButton editTeacher;
    JButton delTeacher;
    JButton view_teachers=new JButton("View teachers");

    Font f1 = new Font("MV Boli",Font.BOLD,44);
    Font f2 = new Font("Arial", Font.BOLD,25);

    TeacherModule(){
        button obj=new button();
        setSize(1550, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon backg =new ImageIcon(ClassLoader.getSystemResource("teacher.jpg"));
        Image img=backg.getImage().getScaledInstance(1550,800,Image.SCALE_SMOOTH);
        ImageIcon backg1 =new ImageIcon(img);

        all = new JLabel();
        all.setLayout(null);
        all.setSize(1550,800);

        sm = new JLabel("Teacher's Module");
        sm.setFont(f1);
        sm.setBounds(600,40,2400,35);

        back = new JLabel("Back");
        back.setFont(f1);
        back.setBounds(1200,20,2400,35);
        back.setForeground(Color.RED);
        back.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e){
                Welcome obj = new Welcome();
                obj.setVisible(true);
                dispose();}
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e) {}

        });


        addTeacher = new JButton("Hire Teacher");
        addTeacher.setFont(f2);
        addTeacher.setBounds(600,150,350,50);
        addTeacher.setBackground(new Color(245,	245	,220));
        addTeacher.addActionListener(obj);


        editTeacher = new JButton("Edit Teacher");
        editTeacher.setFont(f2);
        editTeacher.setBounds(600,250,350,50);
        editTeacher.setBackground(new Color(245,	245	,220));
        editTeacher.addActionListener(obj);


        delTeacher = new JButton("Search & Delete Record");
        delTeacher.setFont(f2);
        delTeacher.setBounds(600,350,350,50);
        delTeacher.setBackground(new Color(245,	245	,220));
       delTeacher.addActionListener(obj);

        view_teachers.setFont(f2);
        view_teachers.setBounds(600,450,350,50);
        view_teachers.setFocusable(false);
        view_teachers.setBackground(new Color(245,	245	,220));
        view_teachers.addActionListener(obj);

        all.add(sm);
        all.add(back);
        all.setIcon(backg1);
        all.add(addTeacher);
        all.add(editTeacher);
        all.add(delTeacher);
        add(view_teachers);
        add(all);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherModule();
    }

    class button implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==addTeacher){
                HireTeacher obj = new HireTeacher();
                obj.setVisible(true);
                dispose();
            } else if (e.getSource()==editTeacher) {
                EditTeacher obj = new EditTeacher();
                obj.setVisible(true);
                dispose();
            } else if (e.getSource()==delTeacher) {
                SearchDeleteTeacher obj = new SearchDeleteTeacher();
                obj.setVisible(true);
                dispose();
            } else if (e.getSource()==view_teachers) {
                new DB_functions().displayTeachers("select * from teachers");
            }

        }

        }
    }


