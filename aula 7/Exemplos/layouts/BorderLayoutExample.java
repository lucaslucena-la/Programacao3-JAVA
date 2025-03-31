package layouts;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExample {
    public BorderLayoutExample(){
        JFrame jfrm = new JFrame("BorderLayout Example");
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300, 100);
        jfrm.add(new JButton("North"), BorderLayout.NORTH);
        jfrm.add(new JButton("South"), BorderLayout.SOUTH);
        jfrm.add(new JButton("East"), BorderLayout.EAST);
        jfrm.add(new JButton("West"), BorderLayout.WEST);
        jfrm.add(new JButton("Center"), BorderLayout.CENTER);
        jfrm.setVisible(true);

    }
    public static void main(String[] args) {
        new BorderLayoutExample();
    }
    
}
