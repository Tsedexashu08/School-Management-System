import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchDeleteTeacher extends JFrame {
    JLabel label=new JLabel("Enter full Name of Teacher who's Record u want to Delete or Search");
    JLabel full_name=new JLabel("Full Name:");
    JTextField fname_Textfeild=new JTextField();

    JButton delete =new JButton("Delete");
    JButton search =new JButton("Search");
    JLabel back=new JLabel("Back");
    Font f1 = new Font("MV Boli",Font.BOLD,44);
    Font f2 = new Font("MV Boli",Font.BOLD,30);
    SearchDeleteTeacher(){
        setTitle("student");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1550,800);
        back.setBounds(1400,20,300,40);
        back.setBackground(Color.red);
        back.setFont(f1);
        back.setForeground(Color.RED);
        back.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {new TeacherModule();dispose();}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        label.setBounds(60,50,1400,80);
        full_name.setBounds(450,250,250,40);

        fname_Textfeild.setBounds(690,250,300,40);
        delete.setBounds(750,350,200,60);
        delete.addActionListener(new buttons());
        search.setBounds(500,350,200,60);
        delete.setFont(f1);
        search.setFont(f1);
        search.addActionListener(new buttons());
        fname_Textfeild.setFont(f2);
        full_name.setFont(f1);
        label.setFont(f1);

        add(label);
        add(full_name);
        add(fname_Textfeild);
        add(search);
        add(delete);
        add(back);
        setVisible(true);



    }

    public static void main(String[] args) {
        new SearchDeleteTeacher();
    }
    class buttons implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==delete){
                new DB_functions().execute("delete from teachers where Full_Name='"+fname_Textfeild.getText()+"'");
                JOptionPane.showMessageDialog(delete,fname_Textfeild.getText()+"'s record has been deleted successfully!");
            } else if (e.getSource()==search) {
                new DB_functions().displayResults("select * from teachers where Full_Name='"+fname_Textfeild.getText()+"'");
            }
        }
    }
}

