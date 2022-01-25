package coachingmanagement.pages;

import static StaticValues.FileAndFolderValues.TEACHER_FILE;
import static StaticValues.FileAndFolderValues.TEACHER_FOLDER;
import static StaticValues.FileAndFolderValues.getFullPath;
import coachingmanagement.models.Teacher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import util.FileReadWrite;


public class AddTeacher extends JFrame {

//    JFrame f = new JFrame("Login");
    JLabel jlName, jlGender, jlDOB, jlInstitue, jlDegree;
    JTextField tfName, tfDOB, tfInstitue, tfDegree;
    JRadioButton rbMale, rbFemale;
    ButtonGroup bg;

    JButton btnAddTeacher;

    public AddTeacher() {
        super("Add Teacher");
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
        bg = new ButtonGroup();
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

        jlDegree = new JLabel("Degree");
        jlDegree.setBounds(50, 310, 300, 30);
        tfDegree = new JTextField("");
        tfDegree.setBounds(50, 340, 300, 30);
        this.add(jlDegree);
        this.add(tfDegree);

        btnAddTeacher = new JButton("Add Teacher");
        btnAddTeacher.setBounds(50, 390, 300, 30);
        this.add(btnAddTeacher);

        this.setSize(400, 500);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnAddTeacher.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnAddTeacher)) {

                String id = UUID.randomUUID().toString();
                String name = tfName.getText().trim();
                String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : "Not Given";
                String dob = tfDOB.getText().trim();
                String institute = tfInstitue.getText().trim();
                String degree = tfDegree.getText().trim();

                Teacher teacher = new Teacher(id, name, gender, dob, institute, degree);

                FileReadWrite fileReadWrite = new FileReadWrite();

                if (!fileReadWrite.isFolderExist(getFullPath(TEACHER_FOLDER))) {
                    // Creating Teacher folder
                    boolean success = fileReadWrite.createFolder(getFullPath(TEACHER_FOLDER));
                    if (success) {
                        System.out.println("Folder Created: " + getFullPath(TEACHER_FOLDER));
                    } else {
                        System.err.println("Folder could not be created: " + getFullPath(TEACHER_FOLDER));
                    }
                } else {
                    System.out.println("Folder exist.");
                }

                if (!fileReadWrite.isFileExist(getFullPath(TEACHER_FOLDER, TEACHER_FILE))) {
                    // Creating Teacher file
                    System.out.println("Creating new file.");
                    boolean success = fileReadWrite.createFile(getFullPath(TEACHER_FOLDER, TEACHER_FILE));
                    if (success) {
                        System.out.println("File Created: " + getFullPath(TEACHER_FOLDER, TEACHER_FILE));
                    } else {
                        System.err.println("File could not be created: " + getFullPath(TEACHER_FOLDER, TEACHER_FILE));
                    }
                } else {
                    System.out.println("File exists...");
                }

                ArrayList<Teacher> teachers = new ArrayList<>();
                Gson gson = new Gson();
                String prevData = fileReadWrite.readFile(getFullPath(TEACHER_FOLDER, TEACHER_FILE));

                if (!prevData.isEmpty()) {
                    TypeToken<ArrayList<Teacher>> token = new TypeToken<ArrayList<Teacher>>() {
                    };
                    ArrayList<Teacher> prevTeachers = gson.fromJson(prevData, token.getType());
                    teachers.addAll(prevTeachers);
                    teachers.add(teacher);
                } else {
                    teachers.add(teacher);
                }

                String teacherInput = gson.toJson(teachers);

                System.out.println("teacher=>> " + teacherInput);
                boolean success = fileReadWrite.writeToFile(getFullPath(TEACHER_FOLDER, TEACHER_FILE), teacherInput);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Teacher Added.");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                }
            }
        }
    }

}
