import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Welcome extends JFrame {
    ImageIcon backg =new ImageIcon(ClassLoader.getSystemResource("sms.png"));
    Image img=backg.getImage().getScaledInstance(1550,800,Image.SCALE_SMOOTH);
    ImageIcon backg1 =new ImageIcon(img);
    buttons button=new buttons();
    JLabel menuPage = new JLabel("Menu Page");
    JLabel all;
    JLabel logout = new JLabel("Logout");
    JButton studBut = new JButton("Student Module");
    JButton Classes = new JButton("Classes");
    JButton teachBut = new JButton("Teacher Module");;
    JButton studRepCardBut = new JButton("Student Report Card");
    Font f1 = new Font("MV Boli",Font.BOLD,44);
    Font f2 = new Font("Arial", Font.PLAIN,20);
    Font f3 = new Font("Arial", Font.BOLD,25);

    Welcome() {
        setSize(1550, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        all = new JLabel();
        all.setLayout(null);
        all.setSize(1550,800);




        menuPage.setFont(f1);
        menuPage.setBounds(660,60,2400,50);
        menuPage.setForeground(Color.CYAN);


        logout.setFont(f1);
        logout.setBounds(1330,10,2400,50);
        logout.setForeground(Color.RED);
        logout.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                LoginPage obj = new LoginPage();
                obj.setVisible(true);
                dispose();}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
        });


        studBut.setFont(f2);
        studBut.setBounds(700,200,300,50);
        studBut.addActionListener(button);

        Classes.setFont(f2);
        Classes.setBounds(700,400,300,50);
        Classes.addActionListener(button);


        teachBut.setBounds(700,300,300,50);
        teachBut.setFont(f2);
        teachBut.addActionListener(button);


        studRepCardBut.setFont(f2);
        studRepCardBut.setBounds(700,480,300,50);
        studRepCardBut.addActionListener(button);


        all.add(menuPage);
        all.add(logout);
        all.setIcon(backg1);
        all.add(studBut);
        all.add(Classes);
        all.add(teachBut);
        all.add(studRepCardBut);

        add(all);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Welcome();
    }

    class buttons implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==studBut){
                StudentModule obj = new StudentModule();
                obj.setVisible(true);
                dispose();
            } else if (e.getSource()==teachBut) {
                TeacherModule obj = new TeacherModule();
                obj.setVisible(true);
                dispose();
            }else if(e.getSource()==Classes){
                Classes obj = new Classes();
                dispose();
            } else if (e.getSource()==studRepCardBut) {
                ReportCard obj = new ReportCard();
                obj.setVisible(true);
                dispose();
            }
        }
    }
}