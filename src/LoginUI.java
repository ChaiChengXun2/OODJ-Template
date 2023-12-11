import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI {
    JFrame frame;
    JTextField emailField;
    JPasswordField passwordField;

    public LoginUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 675);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        	
        	GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
    	
		        JLabel emailLabel = new JLabel("Email:");
		        emailField = new JTextField();
		        JLabel passwordLabel = new JLabel("Password:");
		        passwordField = new JPasswordField();
		        JButton loginButton = new JButton("Login");
		        
		        passwordField.setPreferredSize(new Dimension(500, 25));
		        emailField.setPreferredSize(new Dimension(500, 25));
	        
	        gbc.gridy = 1;
	        loginPanel.add(emailLabel, gbc);
	        
	        gbc.gridy = 2;
	        loginPanel.add(emailField, gbc);
	        
	        gbc.gridy = 3;
	        loginPanel.add(passwordLabel, gbc);
	        
	        gbc.gridy = 4;
	        loginPanel.add(passwordField, gbc);
	        
	        gbc.gridy = 5; 
	        loginPanel.add(loginButton, gbc);
    
        loginPanel.setPreferredSize(new Dimension(600, 500));

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
                    JOptionPane.showMessageDialog(frame, "Invalid email or password!");
                }
            }
        });

        frame.add(loginPanel, BorderLayout.CENTER);
        frame.setVisible(true);
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
        frame.setSize(1200, 675);
    }
    
    public void openLecturerUI() {
        Lecturer lecturer = new Lecturer();
        LecturerUI lecturerUI = new LecturerUI(lecturer);
        lecturerUI.createPanel();
        openUIPanel(lecturerUI.getPanel());
        frame.setSize(1200, 675);
    }

}