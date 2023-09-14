import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class DB_functions {
    public void execute(String query){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/school managment system","root","tsedexashu08");
            Statement stmt=con.createStatement();
            stmt.execute(query);

            con.close();
        }catch(Exception q){ JOptionPane.showMessageDialog(null,q);}
    }

    //function for displaying data from database in the form of tables.
    public void displayResults(String query){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school managment system", "root", "tsedexashu08");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // this is how to get the column count and column names from the result set apparently?!
            int columnCount = resultSet.getMetaData().getColumnCount();//this gets no. of columns.
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = resultSet.getMetaData().getColumnName(i);
            }
            //this is a DefaultTableModel with the retrieved data and column names
            DefaultTableModel model = new DefaultTableModel(columnNames,0);
            Object[] rowData = new Object[columnCount];
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }
            JPanel panel=new JPanel();
            String choices[]={"name","Average"};
            String results[]={"english","maths","history","geography","physics","chemistry","biology","HPE"};
            JLabel sortby=new JLabel("Sort by:");
            JLabel searchResults=new JLabel("Search results:");
            JComboBox sort=new JComboBox<>(choices);

            JButton srt=new JButton("Sort");
            JButton srch=new JButton("Search");
            JComboBox result=new JComboBox<>(results);
            JTable table = new JTable(model);
            JFrame frame=new JFrame();
            JScrollPane scrollPane = new JScrollPane(table);


            frame.add(scrollPane);
            panel.add(sortby);
    srt.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
         frame.dispose();
        new DB_functions().displayResults("select * from results order by "+sort.getSelectedItem());
            }
});
    srch.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new DB_functions().displayResults("select name,"+result.getSelectedItem()+" from results");

        }
    });
            panel.add(sort);
            panel.add(srt);
            panel.add(searchResults);
            panel.add(result);

            panel.add(srch);
            frame.add(panel, BorderLayout.NORTH);
            frame.setLocation(250,100);
            frame.setSize(1100, 500);
            frame.setVisible(true);




        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }


    }

     public void displayStudents(String query){
         try {
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school managment system", "root", "tsedexashu08");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             // this is how to get the column count and column names from the result set apparently?!
             int columnCount = resultSet.getMetaData().getColumnCount();//this gets no. of columns.
             String[] columnNames = new String[columnCount];
             for (int i = 1; i <= columnCount; i++) {
                 columnNames[i - 1] = resultSet.getMetaData().getColumnName(i);
             }
             //this is a DefaultTableModel with the retrieved data and column names
             DefaultTableModel model = new DefaultTableModel(columnNames,0);
             Object[] rowData = new Object[columnCount];
             while (resultSet.next()) {
                 for (int i = 1; i <= columnCount; i++) {
                     rowData[i - 1] = resultSet.getObject(i);
                 }
                 model.addRow(rowData);
             }
             JPanel panel=new JPanel();
             String choices[]={"SID","Full_Name","Age","Gender","Address","person_responsible"};
             JLabel sortby=new JLabel("Sort by:");
             JLabel searchResults=new JLabel("Search:");
             JComboBox sort=new JComboBox<>(choices);

             JButton srt=new JButton("Sort");
             JButton srch=new JButton("Search");
             JComboBox result=new JComboBox<>(choices);
             JTable table = new JTable(model);

             JFrame frame=new JFrame();
             JScrollPane scrollPane = new JScrollPane(table);

             frame.add(scrollPane);
             panel.add(sortby);
             srt.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     frame.dispose();
                     new DB_functions().displayStudents("select * from students order by "+sort.getSelectedItem());
                 }
             });
             srch.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     frame.dispose();
                     new DB_functions().displayStudents("select full_name,"+result.getSelectedItem()+" from students");
                 }
             });
             panel.add(sort);
             panel.add(srt);
             panel.add(searchResults);
             panel.add(result);

             panel.add(srch);
             frame.add(panel, BorderLayout.NORTH);
             frame.setLocation(250,100);
             frame.setSize(1100, 500);
             frame.setVisible(true);

         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
         }
    }

    public void displayStudentsClass(String query,JComboBox x){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school managment system", "root", "tsedexashu08");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // this is how to get the column count and column names from the result set apparently?!
            int columnCount = resultSet.getMetaData().getColumnCount();//this gets no. of columns.
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = resultSet.getMetaData().getColumnName(i);
            }
            //this is a DefaultTableModel with the retrieved data and column names
            DefaultTableModel model = new DefaultTableModel(columnNames,0);
            Object[] rowData = new Object[columnCount];
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }
            JPanel panel=new JPanel();
            String choices[]={"SID","Full_Name","Age","Gender","Address","person_responsible"};
            JLabel sortby=new JLabel("Sort by:");
            JLabel searchResults=new JLabel("Search:");
            JComboBox sort=new JComboBox<>(choices);

            JButton srt=new JButton("Sort");
            JButton srch=new JButton("Search");
            JComboBox result=new JComboBox<>(choices);
            JTable table = new JTable(model);

            JFrame frame=new JFrame();
            JScrollPane scrollPane = new JScrollPane(table);


            frame.add(scrollPane);
            panel.add(sortby);
            srt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    displayStudentsClass("select * from students where grade="+x.getSelectedItem().toString().charAt(0) +" order by "+ sort.getSelectedItem(),x);
                }
            });
            srch.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    displayStudentsClass("select full_name,"+result.getSelectedItem()+" from students where grade="+x.getSelectedItem().toString().charAt(0),x);

                }
            });
            panel.add(sort);
            panel.add(srt);
            panel.add(searchResults);
            panel.add(result);

            panel.add(srch);
            frame.add(panel, BorderLayout.NORTH);
            frame.setLocation(250,100);
            frame.setSize(1100, 500);
            frame.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }


    }
     public void displayTeachers(String query){

         try {
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school managment system", "root", "tsedexashu08");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             // this is how to get the column count and column names from the result set apparently?!
             int columnCount = resultSet.getMetaData().getColumnCount();//this gets no. of columns.
             String[] columnNames = new String[columnCount];
             for (int i = 1; i <= columnCount; i++) {
                 columnNames[i - 1] = resultSet.getMetaData().getColumnName(i);
             }
             //this is a DefaultTableModel with the retrieved data and column names
             DefaultTableModel model = new DefaultTableModel(columnNames,0);
             Object[] rowData = new Object[columnCount];
             while (resultSet.next()) {
                 for (int i = 1; i <= columnCount; i++) {
                     rowData[i - 1] = resultSet.getObject(i);
                 }
                 model.addRow(rowData);
             }
             JPanel panel=new JPanel();
             String choices[]={"Full_Name","Age","Gender","Grade_level","profesion","Experience(in years)"};
             JLabel sortby=new JLabel("Sort by:");
             JLabel searchResults=new JLabel("Search:");
             JComboBox sort=new JComboBox<>(choices);

             JButton srt=new JButton("Sort");
             JButton srch=new JButton("Search");
             JComboBox result=new JComboBox<>(choices);
             JTable table = new JTable(model);
             JFrame frame=new JFrame();
             JScrollPane scrollPane = new JScrollPane(table);


             frame.add(scrollPane);
             panel.add(sortby);
             srt.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     frame.dispose();
                     new DB_functions().displayTeachers("select * from teachers order by "+sort.getSelectedItem());
                 }
             });
             srch.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     frame.dispose();
                     new DB_functions().displayTeachers("select full_name,"+result.getSelectedItem()+" from teachers");

                 }
             });
             panel.add(sort);
             panel.add(srt);
             panel.add(searchResults);
             panel.add(result);

             panel.add(srch);
             frame.add(panel, BorderLayout.NORTH);
             frame.setLocation(250,100);
             frame.setSize(1100, 500);
             frame.setVisible(true);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
         }

     }



}
