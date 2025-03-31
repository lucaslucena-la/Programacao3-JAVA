package layouts;
import javax.swing.*;


public class BoxLayout {
    public BoxLayout(){
        JFrame jfrm = new JFrame("BoxLayout Example");
        jfrm.setLayout(new javax.swing.BoxLayout(jfrm.getContentPane(), javax.swing.BoxLayout.X_AXIS)); // Vertical
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
        new BoxLayout();
    }
}
