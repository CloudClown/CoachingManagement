package coachingmanagement.pages;

import static StaticValues.FileAndFolderValues.ROUTINE_FILE;
import static StaticValues.FileAndFolderValues.ROUTINE_FOLDER;
import static StaticValues.FileAndFolderValues.STUDENT_FILE;
import static StaticValues.FileAndFolderValues.STUDENT_FOLDER;import static StaticValues.FileAndFolderValues.getFullPath;
import coachingmanagement.models.Routine;
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

public class RoutineListNew extends JFrame {

//    JFrame f = new JFrame("Login");

    JLabel jlTitle, jlDay, jlTime, jlStudent, jl;
    JButton btnAddRoutine;
    ArrayList<Routine> routines = new ArrayList<>();
    DefaultListModel<String> l1 = new DefaultListModel<>();
    
   

    public RoutineListNew() {
        super("Routine List");
        setLayout(null);

        jlTitle = new JLabel("Routines");
        jlTitle.setBounds(10, 20, 300, 30);
        this.add(jlTitle);
        
        btnAddRoutine = new JButton("+");
        btnAddRoutine.setBounds(320, 20, 50, 30);
        this.add(btnAddRoutine);
        
        jlDay = new JLabel("Day");
        jlDay.setBounds(10, 80, 150, 30);
        this.add(jlDay);
        
        jlTime = new JLabel("Time");
        jlTime.setBounds(160, 80, 150, 30);
        this.add(jlTime);
        
        
        getDataFromFile();

        for (int i = 0; i < routines.size(); i++) {
            String output = "";
            output += routines.get(i).getDay();
            output += "             ";
            output += routines.get(i).getTime()+ ", " 
                    + routines.get(i).getSubject()+ ", " 
                    + routines.get(i).getTeacher()+ ", " 
                    + routines.get(i).getClassName();
            l1.addElement(output);
        }
        
                
        JList<String> list = new JList<>(l1);  
        list.setBounds(0, 110, 380, 350); 
        this.add(list);
       

        this.setSize(400, 400);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnAddRoutine.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnAddRoutine)) {
                 new AddRoutine();
            }
        }
    }
    
     public void getDataFromFile() {
        Gson gson = new Gson();
        FileReadWrite fileReadWrite = new FileReadWrite();
        String prevData = fileReadWrite.readFile(getFullPath(ROUTINE_FOLDER, ROUTINE_FILE));

        if (!prevData.isEmpty()) {
            TypeToken<ArrayList<Routine>> token = new TypeToken<ArrayList<Routine>>() {
            };
            ArrayList<Routine> prevRoutines = gson.fromJson(prevData, token.getType());
            routines.addAll(prevRoutines);
        }
    }


}
