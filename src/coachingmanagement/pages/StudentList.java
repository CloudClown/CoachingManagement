package coachingmanagement.pages;

import static StaticValues.FileAndFolderValues.STUDENT_FILE;
import static StaticValues.FileAndFolderValues.STUDENT_FOLDER;import static StaticValues.FileAndFolderValues.getFullPath;
import coachingmanagement.models.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import util.FileReadWrite;

public class StudentList extends JFrame {

//    JFrame f = new JFrame("Login");

    JLabel jlTitle, jlName, jlRoll;
    JButton btnAddStudent;
    ArrayList<Student> students = new ArrayList<>();
    DefaultListModel<String> l1 = new DefaultListModel<>();
    
   

    public StudentList() {
        super("Student List");
        setLayout(null);

        jlTitle = new JLabel("Student List");
        jlTitle.setBounds(10, 20, 300, 30);
        this.add(jlTitle);
        
        btnAddStudent = new JButton("+");
        btnAddStudent.setBounds(320, 20, 50, 30);
        this.add(btnAddStudent);
        
        jlName = new JLabel("Name");
        jlName.setBounds(10, 80, 150, 30);
        this.add(jlName);
        
        jlRoll = new JLabel("Roll No.");
        jlRoll.setBounds(160, 80, 150, 30);
        this.add(jlRoll);
        
        
        getDataFromFile();

        for (int i = 0; i < students.size(); i++) {
            String output = "";
            output += students.get(i).getName();
            output += "             ";
            output += students.get(i).getRollNo()+ ", " 
                    + students.get(i).getInstitute() + ", " 
                    + students.get(i).getDob() + ", " 
                    +  students.get(i).getGender() +", " 
                    +  students.get(i).getClassName() +", " 
                    + students.get(i).getCreatedAt();
            l1.addElement(output);
        }
        
                
        JList<String> list = new JList<>(l1);  
        list.setBounds(0, 110, 380, 350); 
        this.add(list);
       

        this.setSize(400, 400);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnAddStudent.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnAddStudent)) {
                 new AddStudent();
            }
        }
    }
    
     public void getDataFromFile() {
        Gson gson = new Gson();
        FileReadWrite fileReadWrite = new FileReadWrite();
        String prevData = fileReadWrite.readFile(getFullPath(STUDENT_FOLDER, STUDENT_FILE));

        if (!prevData.isEmpty()) {
            TypeToken<ArrayList<Student>> token = new TypeToken<ArrayList<Student>>() {
            };
            ArrayList<Student> prevStudents = gson.fromJson(prevData, token.getType());
            students.addAll(prevStudents);
            
        }
    }


}
