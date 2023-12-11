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

	        JPanel navBarPanel = new JPanel();
	        navBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5)); 

		        JButton homeButton = new JButton("Home");
		        JButton manageCourses = new JButton("Mange Worker Profile");

	        navBarPanel.add(homeButton);
	        navBarPanel.add(manageCourses);

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
    }

    public JPanel getPanel() {
        return panel;
    }
}
