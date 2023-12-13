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
        panel.setPreferredSize(new Dimension(1200, 675));

	        JPanel navBarPanel = new JPanel();
	        navBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5)); 

		        JButton homeButton = new JButton("Home");
		        JButton manageStudents = new JButton("Mange Student");
		        JButton logoutButton = new JButton("Logout");

	        navBarPanel.add(homeButton);
	        navBarPanel.add(manageStudents);
	        navBarPanel.add(logoutButton);

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
