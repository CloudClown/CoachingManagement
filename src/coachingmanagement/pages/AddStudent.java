package coachingmanagement.pages;

import static StaticValues.FileAndFolderValues.STUDENT_FILE;
import static StaticValues.FileAndFolderValues.STUDENT_FOLDER;
import static StaticValues.FileAndFolderValues.getFullPath;
import coachingmanagement.models.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import util.FileReadWrite;


public class AddStudent extends JFrame {

//    JFrame f = new JFrame("Login");
    JLabel jlName, jlGender, jlDOB, jlInstitue, jlRoll;
    JTextField tfName, tfDOB, tfInstitue, tfRoll;
    JRadioButton rbMale, rbFemale;

    JButton btnAddStudent;
    static JComboBox c1;
    public AddStudent() {
        super("Add Student");
        setLayout(null);

        jlName = new JLabel("Name");
        jlName.setBounds(50, 20, 300, 30);
        tfName = new JTextField("");
        tfName.setBounds(50, 50, 300, 30);
        this.add(jlName);
        this.add(tfName);

        jlGender = new JLabel("Gender");
        jlGender.setBounds(50, 90, 300, 30);
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(50, 115, 60, 30);
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(120, 115, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        this.add(jlGender);
        this.add(rbMale);
        this.add(rbFemale);

        jlDOB = new JLabel("Date of Birth");
        jlDOB.setBounds(50, 150, 300, 30);
        tfDOB = new JTextField("");
        tfDOB.setBounds(50, 180, 300, 30);
        this.add(jlDOB);
        this.add(tfDOB);

        jlInstitue = new JLabel("Institue");
        jlInstitue.setBounds(50, 230, 300, 30);
        tfInstitue = new JTextField("");
        tfInstitue.setBounds(50, 260, 300, 30);
        this.add(jlInstitue);
        this.add(tfInstitue);
        
        // array of string containing cities
        String s1[] = { "Class 1", "Class 2", "Class 3", "Class 4", "Class 5" };
        // create checkbox
        c1 = new JComboBox(s1);
        c1.setBounds(50, 300, 300, 30);
        this.add(c1);

        jlRoll = new JLabel("Roll No.");
        jlRoll.setBounds(50, 330, 300, 30);
        tfRoll = new JTextField("");
        tfRoll.setBounds(50, 360, 300, 30);
        this.add(jlRoll);
        this.add(tfRoll);

        btnAddStudent = new JButton("Add Student");
        btnAddStudent.setBounds(50, 410, 300, 30);
        this.add(btnAddStudent);

        this.setSize(400, 500);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnAddStudent.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnAddStudent)) {
                String id = UUID.randomUUID().toString();
                String name = tfName.getText().trim();
                String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : "Not Given";
                String dob = tfDOB.getText().trim();
                String institute = tfInstitue.getText().trim();
                String rollNo = tfRoll.getText().trim();
                String className = (String) c1.getSelectedItem();
                 LocalDateTime currentTime = LocalDateTime.now();
                System.out.println(currentTime);
                String createdAt = currentTime.toString();
                Student student = new Student(id, name, gender, dob, institute, rollNo, className, createdAt);

                FileReadWrite fileReadWrite = new FileReadWrite();

                if (!fileReadWrite.isFolderExist(getFullPath(STUDENT_FOLDER))) {
                    // Creating Student folder
                    boolean success = fileReadWrite.createFolder(getFullPath(STUDENT_FOLDER));
                    if (success) {
                        System.out.println("Folder Created: " + getFullPath(STUDENT_FOLDER));
                    } else {
                        System.err.println("Folder could not be created: " + getFullPath(STUDENT_FOLDER));
                    }
                } else {
                    System.out.println("Folder exist.");
                }

                if (!fileReadWrite.isFileExist(getFullPath(STUDENT_FOLDER, STUDENT_FILE))) {
                    // Creating Student file
                    System.out.println("Creating new file.");
                    boolean success = fileReadWrite.createFile(getFullPath(STUDENT_FOLDER, STUDENT_FILE));
                    if (success) {
                        System.out.println("File Created: " + getFullPath(STUDENT_FOLDER, STUDENT_FILE));
                    } else {
                        System.err.println("File could not be created: " + getFullPath(STUDENT_FOLDER, STUDENT_FILE));
                    }
                } else {
                    System.out.println("File exists...");
                }

                ArrayList<Student> students = new ArrayList<>();
                Gson gson = new Gson();
                String prevData = fileReadWrite.readFile(getFullPath(STUDENT_FOLDER, STUDENT_FILE));

                if (!prevData.isEmpty()) {
                    TypeToken<ArrayList<Student>> token = new TypeToken<ArrayList<Student>>() {
                    };
                    ArrayList<Student> prevStudents = gson.fromJson(prevData, token.getType());
                    students.addAll(prevStudents);
                    students.add(student);
                } else {
                    students.add(student);
                }

                String studentInput = gson.toJson(students);

                System.out.println("student=>> " + studentInput);
                boolean success = fileReadWrite.writeToFile(getFullPath(STUDENT_FOLDER, STUDENT_FILE), studentInput);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Student Added.");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                }

            }
        }
    }

}
