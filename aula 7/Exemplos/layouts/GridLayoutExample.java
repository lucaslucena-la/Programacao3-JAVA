package layouts;
import javax.swing.*;
import java.awt.GridLayout;

public class GridLayoutExample {
    public GridLayoutExample(){
        JFrame jfrm = new JFrame("GridLayout Example");
        jfrm.setLayout(new GridLayout(2, 3));
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300, 200);
        jfrm.add(new JButton("Button 1"));
        jfrm.add(new JButton("Button 2"));
        jfrm.add(new JButton("Button 3"));
        jfrm.add(new JButton("Button 4"));
        jfrm.add(new JButton("Button 5"));
        jfrm.add(new JButton("Button 6"));
        jfrm.setVisible(true);

    }
    public static void main(String[] args) {
        new GridLayoutExample();
    }
}
