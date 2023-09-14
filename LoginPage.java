import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginPage extends JFrame{


    JLabel sms;
    JLabel user;
    JLabel pass;
    JLabel fpass;
    JLabel escode;
    JLabel lpage;
    JLabel all;
    JTextField userT;
    JTextField escodeT;
    JPasswordField passF;
    JButton login;
    JButton okay;
    Font f1 = new Font("MV Boli",Font.BOLD,30);

    Font f2 = new Font("Arial", Font.BOLD,20);
    Font f3 = new Font("Arial", Font.BOLD,25);
    LoginPage(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1550,800);
        setLayout(null);
        setResizable(true);

        all = new JLabel();
        all.setLayout(null);
        all.setSize(1550,800);

        ImageIcon backg =new ImageIcon(ClassLoader.getSystemResource("sms.png"));
        Image img=backg.getImage().getScaledInstance(1550,800,Image.SCALE_SMOOTH);
        ImageIcon backg1 =new ImageIcon(img);

        sms = new JLabel("SCHOOL MANAGEMENT SYSTEM");
        sms.setBounds(500,40,2000,30);
        sms.setForeground(Color.CYAN);
        sms.setFont(f1);

        user = new JLabel("User Name:");
        user.setBounds(550,250,2000,30);
        user.setForeground(Color.cyan);
        user.setFont(f2);

        pass = new JLabel("PassWord:");
        pass.setBounds(550,310,2000,30);
        pass.setForeground(Color.cyan);
        pass.setFont(f2);

        fpass = new JLabel("Forgot PassWord?");
        fpass.setBounds(550,500,2000,30);
        fpass.setForeground(Color.cyan);
        fpass.setFont(f2);

        escode = new JLabel("Enter Secrete Code:");
        escode.setBounds(550,560,2000,30);
        escode.setForeground(Color.cyan);
        escode.setFont(f2);

        lpage = new JLabel("LOGIN PAGE");
        lpage.setBounds(700,90,300,30);
        lpage.setFont(f3);
        lpage.setForeground(Color.white);
        lpage.setBackground(Color.red);


        userT = new JTextField();
        userT.setBounds(680,250,400,30);
        userT.setFont(f2);
        userT.setBackground(Color.white);
        userT.setForeground(Color.black);

        passF = new JPasswordField();
        passF.setBounds(680,310,400,30);
        passF.setFont(f2);
        passF.setBackground(Color.white);
        passF.setForeground(Color.black);

        escodeT = new JTextField();
        escodeT.setBounds(750,560,400,30);
        escodeT.setFont(f2);
        escodeT.setBackground(Color.white);
        escodeT.setForeground(Color.black);

        login = new JButton("Login");
        login.setBounds(850,360,100,40);
        login.setFont(f2);
        login.setBackground(Color.darkGray);
        login.setForeground(Color.white);
        login.setFocusable(false);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subActionPerformed(e);
            }
        });

        okay = new JButton("Okay");
        okay.setBounds(850,610,100,40);
        okay.setFont(f2);
        okay.setBackground(Color.darkGray);
        okay.setForeground(Color.white);
        okay.setFocusable(false);
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okayActionPerformed( e);
            }
        });


        all.add(sms);
        all.add(user);
        all.add(pass);
        all.add(fpass);
        all.add(escode);
        all.add(lpage);
        all.add(userT);
        all.add(passF);
        all.add(escodeT);
        all.add(login);
        all.add(okay);
        all.setIcon(backg1);
        add(all);
        setVisible(true);
    }
    public static void main(String[] args) {new LoginPage().setVisible(true);}
    private void subActionPerformed(ActionEvent e) {
        String usrname = userT.getText();
        String passwd = String.valueOf(passF.getText());
        if(e.getSource() == login){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/School Managment System","root","tsedexashu08");//establishes connection
                Statement st = con.createStatement();
                String sql = "select * from user_login";

                ResultSet rs = st.executeQuery(sql);
                while(rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    if (usrname.equals(username) && passwd.equals(password)) {
                        new Welcome().setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Username or Password is incorrect!");

                    }
                }
            }
            catch(Exception ev){
                JOptionPane.showMessageDialog(null,"Error while establishing connection");
            }
        }

    }

    private void okayActionPerformed(ActionEvent e) {
        String secret=escodeT.getText();
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/School Managment System","root","tsedexashu08");//establishes connection
                Statement st = con.createStatement();
                String sql = "select * from user_login";

                ResultSet rs = st.executeQuery(sql);
                while(rs.next()) {
                    String s = escodeT.getText();

                    if(s.equals("tsedex@123")){
                        JOptionPane.showMessageDialog(this,"The username and password is "+ rs.getString("username")+ " and " + rs.getString("password"));
                    }else{
                        JOptionPane.showMessageDialog(null,"Wrong code,try again!");
                    }
                }
            }
            catch(Exception ev){
                JOptionPane.showMessageDialog(null,ev);
            }
        }
    }

