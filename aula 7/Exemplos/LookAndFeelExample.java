import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.FlowLayout;

public class LookAndFeelExample {
    public LookAndFeelExample() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            System.out.println("Error setting Nimbus LAF: " + e);
        }
        JFrame jfrm = new JFrame("LookAndFeel Example");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300, 100);
        jfrm.setLayout(new FlowLayout());
        jfrm.add(new JButton("Button 1"));
        jfrm.add(new JButton("Button 2"));
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        new LookAndFeelExample();
    }
}
