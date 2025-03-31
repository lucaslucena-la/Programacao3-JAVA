package layouts;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class FlowLayoutExample {
    public FlowLayoutExample(){
        JFrame jfrm = new JFrame("FlowLayout Example");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(300, 100);
        jfrm.add(new JButton("Button 1"));
        jfrm.add(new JButton("Button 2"));
        jfrm.setVisible(true);

    }
    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}
