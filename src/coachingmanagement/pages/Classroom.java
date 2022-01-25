package coachingmanagement.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Classroom extends JFrame {

//    JFrame f = new JFrame("Login");

    
    JButton btnClassOne, btnClassTwo, btnClassThree, btnClassFour, btnClassFive;

    public Classroom() {
        super("Classroom");
        setLayout(null);

        btnClassOne = new JButton("Class 1");
        btnClassOne.setBounds(50, 100, 300, 30);
        this.add(btnClassOne);
        
        btnClassTwo = new JButton("Class 2");
        btnClassTwo.setBounds(50, 150, 300, 30);
        this.add(btnClassTwo);
        
        btnClassThree = new JButton("Class 3");
        btnClassThree.setBounds(50, 200, 300, 30);
        this.add(btnClassThree);
        
        
        btnClassFour = new JButton("Class 4");
        btnClassFour.setBounds(50, 250, 300, 30);
        this.add(btnClassFour);

        btnClassFive = new JButton("Class 5");
        btnClassFive.setBounds(50, 300, 300, 30);
        this.add(btnClassFive);

        this.setSize(400, 400);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnClassOne.addActionListener(AP);
        btnClassTwo.addActionListener(AP);
        btnClassThree.addActionListener(AP);
        btnClassFour.addActionListener(AP);
        btnClassFive.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnClassOne)) {
                new StudentClass1();
                
            } else if (e.getSource().equals(btnClassTwo)) {
                   new StudentClass2();
                
            } else if (e.getSource().equals(btnClassThree)) {
                   new StudentClass3();
                
            } else if (e.getSource().equals(btnClassFour)) {
                   new StudentClass4();
                
            }
            else if (e.getSource().equals(btnClassFive)) {
                   new StudentClass5();
                
            } 
        }
    }

}
