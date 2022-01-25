package coachingmanagement.pages;

import StaticValues.LoginCredentials;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Dashboard extends JFrame {

//    JFrame f = new JFrame("Login");

    
    JButton btnStudent, btnTeacher, btnRoutine, btnClassRoom;

    public Dashboard() {
        super("Dashboard");
        setLayout(null);


        btnStudent = new JButton("Student");
        btnStudent.setBounds(50, 100, 300, 30);
        this.add(btnStudent);
        
        btnTeacher = new JButton("Teacher");
        btnTeacher.setBounds(50, 150, 300, 30);
        this.add(btnTeacher);
        
        btnRoutine = new JButton("Routine");
        btnRoutine.setBounds(50, 200, 300, 30);
        this.add(btnRoutine);
        
        
        btnClassRoom = new JButton("Classroom");
        btnClassRoom.setBounds(50, 250, 300, 30);
        this.add(btnClassRoom);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        this.setSize(400, 400);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnStudent.addActionListener(AP);
        btnTeacher.addActionListener(AP);
        btnRoutine.addActionListener(AP);
        btnClassRoom.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnStudent)) {
                new StudentList();
                
            } else if (e.getSource().equals(btnTeacher)) {
                new TeacherList();
            } else if (e.getSource().equals(btnRoutine)) {
//                new RoutineList();
                new RoutineListNew();
            } else if (e.getSource().equals(btnClassRoom)) {
                new Classroom();
            } 
        }
    }

}
