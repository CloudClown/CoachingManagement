package coachingmanagement.pages;

import StaticValues.LoginCredentials;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

//    JFrame f = new JFrame("Login");

    JLabel labelEmail, labelPassword, labelError;
    JTextField tfEmail;
    JPasswordField tfPassword;
    JButton btnLogin;

    public Login() {
        super("Coaching Management: Login");
        setLayout(null);

        labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 50, 300, 30);
        tfEmail = new JTextField("admin@gmail.com");
        tfEmail.setBounds(50, 80, 300, 30);
        this.add(labelEmail);
        this.add(tfEmail);

        labelPassword = new JLabel("Password");
        labelPassword.setBounds(50, 120, 300, 30);
        tfPassword = new JPasswordField("123456");
        tfPassword.setBounds(50, 150, 300, 30);
        this.add(labelPassword);
        this.add(tfPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 200, 300, 30);
        this.add(btnLogin);

        labelError = new JLabel("Welcome back!");
        labelError.setBounds(50, 260, 300, 30);
        this.add(labelError);

        this.setSize(400, 400);
        this.setVisible(true);

        ActionPerformed AP = new ActionPerformed();

        btnLogin.addActionListener(AP);

    }

    class ActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btnLogin)) {
                String email = tfEmail.getText().trim().toString();
                String password = tfPassword.getText();

                if (email.isEmpty() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please, enter email & password");
                } else if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please, enter your email");
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please, enter your password");
                } else if (!email.equals(LoginCredentials.ADMIN_EMAIL)) {
                    JOptionPane.showMessageDialog(null, "Email doesn't exist");
                } else if (!password.equals(LoginCredentials.ADMIN_PASSWORD)) {
                    JOptionPane.showMessageDialog(null, "Password mismatch");
                } else {
                    // login success! Opne next page...
                    new Dashboard();
                    
                }
            }
        }
    }

}
