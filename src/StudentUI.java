import javax.swing.*;
import java.awt.*;

public class StudentUI {
    private JPanel panel;
    private Student student;

    StudentUI(Student student) {
        this.student = student;
    }

    public void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(1200, 675));

	        JPanel navBarPanel = new JPanel();
	        navBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5)); 

		        JButton homeButton = new JButton("Home");
		        JButton manageCourses = new JButton("Mange Courses");
		        JButton logoutButton = new JButton("Logout");

	        navBarPanel.add(homeButton);
	        navBarPanel.add(manageCourses);
	        navBarPanel.add(logoutButton);

        panel.add(navBarPanel, BorderLayout.NORTH);

        JLabel officerLabel = new JLabel("Student UI");
        
	        officerLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        
        panel.add(officerLabel, BorderLayout.CENTER);

        homeButton.addActionListener(e -> {
            System.out.println("Clicked Home button");
        });

        manageCourses.addActionListener(e -> {
            System.out.println("Clicked Courses");
        });
        
        logoutButton.addActionListener(e -> {
        	openLoginUI();
        });
    }
    
    private void openLoginUI() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
        frame.getContentPane().removeAll();
        LoginUI loginUI = new LoginUI(frame);
        frame.setPreferredSize(new Dimension(1200, 675));
        frame.add(loginUI.getPanel());
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }


    public JPanel getPanel() {
        return panel;
    }
}
