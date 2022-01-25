package coachingmanagement.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class RoutineList {

//    String data[][] = {
//        {"Eng", "Ban", "Math", "Eng", "Ban", "Math", "Science"},
//        {"Eng", "Ban", "Math", "Eng", "Ban", "Math", "Science"},
//        {"Eng", "Ban", "Math", "Eng", "Ban", "Math", "Science"},
//        {"Eng", "Ban", "Math", "Eng", "Ban", "Math", "Science"},
//        {"Eng", "Ban", "Math", "Eng", "Ban", "Math", "Science"},
//        {"Eng", "Ban", "Math", "Eng", "Ban", "Math", "Science"},
//        {"Eng", "Ban", "Math", "Eng", "Ban", "Math", "Science"}
//    };
    String column[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Saturday"};

    // frame
    JFrame f;
    // Table
//    JTable j;
    
    JButton btnAddRoutine;

    public RoutineList() {
        f = new JFrame();

        // Frame Title
        f.setTitle("Routine");

        // Initializing the JTable
//        j = new JTable(data, column);
//        j.setBounds(30, 100, 200, 300);
        
        btnAddRoutine = new JButton();
        f.add(btnAddRoutine);
        btnAddRoutine.setBounds(160, 20, 80, 20);
        btnAddRoutine.setText("+");
        
        
        JScrollPane sp = new JScrollPane();
        f.add(sp);
        
        f.setSize(400, 400);
        f.setVisible(true);
        
        
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
}
