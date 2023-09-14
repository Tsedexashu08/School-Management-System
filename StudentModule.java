import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StudentModule extends JFrame {

    JLabel sm;
    JLabel all;
    JLabel back;
    JButton addStud;
    JButton editStud;
    JButton delStud;
    Font f1 = new Font("MV Boli",Font.BOLD,44);
    Font f2 = new Font("Arial", Font.BOLD,25);

    StudentModule(){
        setSize(1550, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon backg =new ImageIcon(ClassLoader.getSystemResource("book background.png"));
        Image img=backg.getImage().getScaledInstance(1550,800,Image.SCALE_SMOOTH);
        ImageIcon backg1 =new ImageIcon(img);

        all = new JLabel();
        all.setLayout(null);
        all.setSize(1550,800);

        sm = new JLabel("Student's Module");
        sm.setFont(f1);
        sm.setBounds(600,40,2400,35);

        back = new JLabel("Back");
        back.setFont(f1);
        back.setBounds(1200,20,2400,35);
        back.setForeground(Color.RED);
        back.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e){
                Welcome obj = new Welcome();
                obj.setVisible(true);
                dispose();}
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e) {}
        });

        addStud = new JButton("Add Student");
        addStud.setFont(f2);
        addStud.setBounds(700,200,300,100);
        addStud.setFocusable(false);
        addStud.setBackground(new Color(245,	245	,220));
        addStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudent obj = new AddStudent();
                obj.setVisible(true);
                dispose();
            }
        });

        editStud = new JButton("Edit Student");
        editStud.setFont(f2);
        editStud.setBounds(700,400,300,100);
        editStud.setFocusable(false);
        editStud.setBackground(new Color(245,	245	,220));
        editStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditStudent();
                dispose();
            }
        });

        delStud = new JButton("Search & Delete Record");
        delStud.setFont(f2);
        delStud.setBounds(1000,300,350,100);
        delStud.setFocusable(false);
        delStud.setBackground(new Color(245,	245	,220));
        delStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchDeleteStudent obj = new SearchDeleteStudent();
                obj.setVisible(true);
                dispose();
            }
        });

        all.add(sm);
        all.add(back);
        all.setIcon(backg1);
        all.add(addStud);
        all.add(editStud);
        all.add(delStud);
        add(all);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentModule();
    }
}
