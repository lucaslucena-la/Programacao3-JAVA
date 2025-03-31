import javax . swing .*;
import java . awt .*;
import java . awt . event .*;

public class ContadorSwing extends JFrame {
    private int contador = 0;
    private JLabel contadorLabel ;
    private JButton incrementarButton ;
    private JButton decrementarButton ;

    public ContadorSwing () {
        setTitle ( " Contador Simples " );
        setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
        setSize (300 , 200);
        setLayout ( new FlowLayout ());

        contadorLabel = new JLabel ( " Contador : " + contador );
        incrementarButton = new JButton ( " Incrementar " );

        // Evento para o botao Incrementar
        incrementarButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                // # TODO 1: Incrementar o contador e atualizar o
                // texto do contadorLabel
                contador++;
                contadorLabel.setText("Contador: " + contador);
            }
        });

        // # TODO 2: Criar o botao Decrementar e adicionar
        // um ActionListener para decrementar o contador
        
        decrementarButton = new JButton("Decrementar ");
        decrementarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador--;
                contadorLabel.setText("Contador: " + contador);
            }
        });

        add (contadorLabel);
        add (incrementarButton);
        add (decrementarButton);
        setVisible ( true );
    }
    public static void main ( String [] args ) {
        SwingUtilities . invokeLater ( new Runnable () {
            @Override
            public void run () {
                new ContadorSwing ();
            }
        });
    }
}