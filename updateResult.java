import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class updateResult extends JFrame {
    ImageIcon backg = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
    Image img = backg.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
    ImageIcon backg1 = new ImageIcon(img);
    private  JLabel all=new JLabel();
    JLabel label=new JLabel("Enter full Name of Student who's Result you want to update");
    JLabel full_name=new JLabel("Full Name:");
    JTextField fname_Textfeild=new JTextField();

    JButton update =new JButton("Update");
    JLabel back=new JLabel("Back");
    JLabel change=new JLabel("Update:");
    String attributes_to_change[]={"English","Maths","Geography","History","Physics","Chemistry","Biology","HPE"};
    JComboBox attributes=new JComboBox<>(attributes_to_change);
    JLabel to=new JLabel("to");
    JTextField changeTo_textFeild=new JTextField();
    Font f1 = new Font("MV Boli",Font.BOLD,44);
    Font f2 = new Font("MV Boli",Font.BOLD,30);
    updateResult(){
        all.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1550,800);
        all.setSize(1550,880);
        back.setBounds(1400,20,300,40);
        back.setBackground(Color.red);
        back.setFont(f1);
        back.setForeground(Color.RED);
        back.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {new ReportCard();setVisible(false);}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        label.setBounds(100,50,1350,80);
        full_name.setBounds(370,250,250,40);
        change.setBounds(200,350,250,40);
        attributes.setBounds(380,350,300,40);
        to.setBounds(700,350,50,40);
        changeTo_textFeild.setBounds(780,350,300,40);
        fname_Textfeild.setBounds(610,250,300,40);
        update.setBounds(600,480,200,60);
        update.setFont(f1);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DB_functions().execute("update results set "+attributes.getSelectedItem()+"="+Integer.parseInt(changeTo_textFeild.getText())+" where Name="+"'"+fname_Textfeild.getText()+"'");
                JOptionPane.showMessageDialog(update,fname_Textfeild.getText()+"'s record has been updated successfully!");
            }
        });
        fname_Textfeild.setFont(f2);
        full_name.setFont(f1);
        label.setFont(f1);
        change.setFont(f1);
        to.setFont(f1);
        attributes.setFont(f2);
        changeTo_textFeild.setFont(f2);
        all.add(label);
        all.add(full_name);
        all.add(fname_Textfeild);
        all.add(change);
        all.add(attributes);
        all.add(to);
        all.add(changeTo_textFeild);
        all.add(update);
        all.add(back);
        all.setIcon(backg1);
        add(all);
        setVisible(true);



    }

    public static void main(String[] args) {
        new updateResult();
    }
}
