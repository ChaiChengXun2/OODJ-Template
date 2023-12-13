import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
    	JFrame mainFrame = new JFrame("Main Frame");
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainFrame.setSize(1200, 675);
    	mainFrame.setLayout(new BorderLayout());
    	mainFrame.setLocationRelativeTo(null);
    	
    	LoginUI loginPanel = new LoginUI(mainFrame); 
    	mainFrame.add(loginPanel.getPanel());
    	
    	mainFrame.setVisible(true);
	}
}
