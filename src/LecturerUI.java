import javax.swing.*;
import java.awt.*;

public class LecturerUI {
    private JPanel panel;
    private Lecturer lecturer;

    LecturerUI(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

	        JPanel navBarPanel = new JPanel();
	        navBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5)); 

		        JButton homeButton = new JButton("Home");
		        JButton manageStudents = new JButton("Mange Student");

	        navBarPanel.add(homeButton);
	        navBarPanel.add(manageStudents);

        panel.add(navBarPanel, BorderLayout.NORTH);

        JLabel officerLabel = new JLabel("Lecturer UI");
        
	        officerLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        
        panel.add(officerLabel, BorderLayout.CENTER);

        homeButton.addActionListener(e -> {
            System.out.println("Clicked Home button");
        });

        manageStudents.addActionListener(e -> {
            System.out.println("Clicked Manage Students");
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
