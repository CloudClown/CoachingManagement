package coachingmanagement.pages;

import static StaticValues.FileAndFolderValues.TEACHER_FILE;
import static StaticValues.FileAndFolderValues.TEACHER_FOLDER;
import static StaticValues.FileAndFolderValues.getFullPath;
import StaticValues.LoginCredentials;
import coachingmanagement.models.Teacher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import util.FileReadWrite;

public class TeacherList extends JFrame {

//    JFrame f = new JFrame("Login");
    JLabel jlTitle, jlName, jlInfo;
    JButton btnAddTeacher;

    ArrayList<Teacher> teachers = new ArrayList<>();
    DefaultListModel<String> l1 = new DefaultListModel<>();

    public TeacherList() {
        super("Teacher List");
        setLayout(null);

        jlTitle = new JLabel("Teacher List");
        jlTitle.setBounds(10, 20, 300, 30);
        this.add(jlTitle);

        btnAddTeacher = new JButton("+");
        btnAddTeacher.setBounds(320, 20, 50, 30);
        this.add(btnAddTeacher);

        jlName = new JLabel("Name");
        jlName.setBounds(10, 80, 150, 30);
        this.add(jlName);

        jlInfo = new JLabel("Info.");
        jlInfo.setBounds(160, 80, 150, 30);
        this.add(jlInfo);

        getDataFromFile();

        for (int i = 0; i < teachers.size(); i++) {
            String output = "";
            output += teachers.get(i).getName();
            output += "             ";
            output += teachers.get(i).getDegree() + ", " + teachers.get(i).getInstitute() + ", " + teachers.get(i).getDob() + ", " +  teachers.get(i).getGender();
            l1.addElement(output);
        }
        
                
        JList<String> list = new JList<>(l1);  
        list.setBounds(0, 110, 380, 350); 
        this.add(list);
       
        
        this.setSize(400, 400);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnAddTeacher.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnAddTeacher)) {
                new AddTeacher();
            }
        }
    }

    public void getDataFromFile() {
        Gson gson = new Gson();
        FileReadWrite fileReadWrite = new FileReadWrite();
        String prevData = fileReadWrite.readFile(getFullPath(TEACHER_FOLDER, TEACHER_FILE));

        if (!prevData.isEmpty()) {
            TypeToken<ArrayList<Teacher>> token = new TypeToken<ArrayList<Teacher>>() {
            };
            ArrayList<Teacher> prevTeachers = gson.fromJson(prevData, token.getType());
            teachers.addAll(prevTeachers);
        }
    }

}
