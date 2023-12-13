import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI {
    private JPanel panel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JFrame frame; 
    
    public LoginUI(JFrame frame) {
        this.frame = frame;
        createPanel();
    }

    public void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridBagLayout());
        	GridBagConstraints gbc = new GridBagConstraints();
        	gbc.gridx = 0;
        	gbc.gridy = 0;
        	gbc.anchor = GridBagConstraints.CENTER;

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        	passwordField.setPreferredSize(new Dimension(200, 25));
        	emailField.setPreferredSize(new Dimension(200, 25));

        	emailLabel.setForeground(Color.WHITE);
        	passwordLabel.setForeground(Color.WHITE);

        	gbc.gridy = 1;
        	centerPanel.add(emailLabel, gbc);

        	gbc.gridy = 2;
        	centerPanel.add(emailField, gbc);

        	gbc.gridy = 3;
        	centerPanel.add(passwordLabel, gbc);

        	gbc.gridy = 4;
        	centerPanel.add(passwordField, gbc);

        	gbc.gridy = 5;
        	centerPanel.add(loginButton, gbc);
        
        	panel.add(centerPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (email.equals("student@oodj.com") && password.equals("abc123")) {
                	openStudentUI();
                } else if (email.equals("lecturer@oodj.com") && password.equals("abc123")) {
                	openLecturerUI();
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid email or password!");
                }
            }
        });
    }

    public void openUIPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }
    
    public void openStudentUI() {
        Student student = new Student();
        StudentUI studentUI = new StudentUI(student);
        studentUI.createPanel();
        openUIPanel(studentUI.getPanel());
    }
    
    public void openLecturerUI() {
        Lecturer lecturer = new Lecturer();
        LecturerUI lecturerUI = new LecturerUI(lecturer);
        lecturerUI.createPanel();
        openUIPanel(lecturerUI.getPanel());
    }
    
    public JPanel getPanel() {
        return panel;
    }

}