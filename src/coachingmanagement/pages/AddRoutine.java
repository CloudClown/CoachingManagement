package coachingmanagement.pages;

import static StaticValues.FileAndFolderValues.ROUTINE_FILE;
import static StaticValues.FileAndFolderValues.ROUTINE_FOLDER;
import static StaticValues.FileAndFolderValues.STUDENT_FILE;
import static StaticValues.FileAndFolderValues.STUDENT_FOLDER;
import static StaticValues.FileAndFolderValues.getFullPath;
import coachingmanagement.models.Routine;
import coachingmanagement.models.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class AddRoutine extends JFrame {

    //day, teacher, time, subject, className;

    String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Saturday"};
    String classNames[] = {"Class 1", "Class 2", "Class 3", "Class 4", "Class 5"};
    String times[] = {"8:00am-10:00am", "4:00pm-6:00pm"};
    String subjects[] = {"English", "Bangla", "Mathematics"};

    JLabel jlDay, jlClassName, jlTime, jlSubject;

    JButton btnAddRoutine;
    
    static JComboBox cbClassName, cbSubject, cbTeacherName, cbDays, cbTime;

    public AddRoutine() {
        super("Add Routine");
        setLayout(null);

        jlDay = new JLabel("Day");
        jlDay.setBounds(50, 20, 300, 30);
        this.add(jlDay);
        
        cbDays = new JComboBox(days);
        cbDays.setBounds(50, 50, 300, 30);
        this.add(cbDays);
        
       
        jlClassName = new JLabel("Class");
        jlClassName.setBounds(50, 80, 300, 30);
        this.add(jlClassName);
        
        cbClassName = new JComboBox(classNames);
        cbClassName.setBounds(50, 110, 300, 30);
        this.add(cbClassName);
        
        
        jlSubject = new JLabel("Subject");
        jlSubject.setBounds(50, 140, 300, 30);
        this.add(jlSubject);
        
        
        cbSubject = new JComboBox(subjects);
        cbSubject.setBounds(50, 160, 300, 30);
        this.add(cbSubject);
        
         jlTime = new JLabel("Time");
        jlTime.setBounds(50, 230, 300, 30);
        this.add(jlTime);

      

        cbTime = new JComboBox(times);
        cbTime.setBounds(50, 250, 200, 30);
        this.add(cbTime);


        btnAddRoutine = new JButton("Add Routine");
        btnAddRoutine.setBounds(50, 410, 300, 30);
        this.add(btnAddRoutine);

        this.setSize(400, 500);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnAddRoutine.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnAddRoutine)) {
                String id = UUID.randomUUID().toString();
                String teacherName = "";
                String className = (String) cbClassName.getSelectedItem();
                String day = (String) cbDays.getSelectedItem();
                String time = (String) cbTime.getSelectedItem();
                String subject = (String) cbSubject.getSelectedItem();

                Routine routine = new Routine(id, day, teacherName, time,  subject, className);

                FileReadWrite fileReadWrite = new FileReadWrite();

                if (!fileReadWrite.isFolderExist(getFullPath(ROUTINE_FOLDER))) {
                    // Creating Student folder
                    boolean success = fileReadWrite.createFolder(getFullPath(ROUTINE_FOLDER));
                    if (success) {
                        System.out.println("Folder Created: " + getFullPath(ROUTINE_FOLDER));
                    } else {
                        System.err.println("Folder could not be created: " + getFullPath(ROUTINE_FOLDER));
                    }
                } else {
                    System.out.println("Folder exist.");
                }

                if (!fileReadWrite.isFileExist(getFullPath(ROUTINE_FOLDER, ROUTINE_FILE))) {
                    // Creating Routine file
                    System.out.println("Creating new file.");
                    boolean success = fileReadWrite.createFile(getFullPath(ROUTINE_FOLDER, ROUTINE_FILE));
                    if (success) {
                        System.out.println("File Created: " + getFullPath(ROUTINE_FOLDER, ROUTINE_FILE));
                    } else {
                        System.err.println("File could not be created: " + getFullPath(ROUTINE_FOLDER, ROUTINE_FILE));
                    }
                } else {
                    System.out.println("File exists...");
                }

                ArrayList<Routine> routines = new ArrayList<>();
                Gson gson = new Gson();
                String prevData = fileReadWrite.readFile(getFullPath(ROUTINE_FOLDER, ROUTINE_FILE));

                if (!prevData.isEmpty()) {
                    TypeToken<ArrayList<Routine>> token = new TypeToken<ArrayList<Routine>>() {
                    };
                    ArrayList<Routine> prevRoutine = gson.fromJson(prevData, token.getType());
                    routines.addAll(prevRoutine);
                    routines.add(routine);
                } else {
                    routines.add(routine);
                }

                String studentInput = gson.toJson(routines  );

                System.out.println("routine=>> " + studentInput);
                boolean success = fileReadWrite.writeToFile(getFullPath(ROUTINE_FOLDER, ROUTINE_FILE), studentInput);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Routine Added.");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                }

            }
        }
    }
}
