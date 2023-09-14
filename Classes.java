import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Classes extends JFrame {
    ImageIcon backg = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
    Image img = backg.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
    ImageIcon backg1 = new ImageIcon(img);

    private  JLabel all=new JLabel();
   private JLabel label = new JLabel("Choose what Grade you want to view");
   private JLabel back = new JLabel("Back");
   private JButton view = new JButton("View");
    String gradeLvls[] = {"1st Grade", "2nd Grade", "3rd Grade", "4th Grade", "5th Grade", "6th Grade", "7th Grade", "8th Grade", "9th Grade", "10th Grade", "11th Grade", "12th Grade"};
  private JComboBox gradelvl = new JComboBox<>(gradeLvls);
    Font f1 = new Font("MV Boli", Font.BOLD, 44);
    Font f2 = new Font("MV Boli", Font.BOLD, 30);
    private JButton show_all=new JButton("Show all");
    Classes() {
        all.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1550, 800);
        all.setSize(1550,880);
        back.setBounds(1400, 20, 300, 40);
        back.setBackground(Color.red);
        back.setFont(f1);
        show_all.setFont(f1);
        back.setForeground(Color.RED);

        back.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {new Welcome();dispose();}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        label.setBounds(300, 50, 1350, 80);
        label.setForeground(Color.white);
        gradelvl.setBounds(600, 200, 300, 50);
        gradelvl.setBackground(Color.white);
        view.setBounds(650, 300, 200, 50);
        show_all.setBounds(580, 400, 350, 50);
        show_all.addActionListener(new buttons());
        view.addActionListener(new buttons());
        label.setFont(f1);
        gradelvl.setFont(f2);
        view.setFont(f1);


        all.add(label);
        all.add(gradelvl);
        all.add(view);
        all.add(back);
        all.setIcon(backg1);
        all.add(show_all);
        add(all);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Classes();
    }

    class buttons implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view) {
                new DB_functions().displayStudentsClass("select * from students where Grade="+gradelvl.getSelectedItem().toString().charAt(0),gradelvl);
                }else if(e.getSource()==show_all){
                new DB_functions().displayStudents("select * from students");
            }
            }
        }


    }


