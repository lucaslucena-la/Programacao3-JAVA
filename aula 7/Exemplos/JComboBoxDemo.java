// Demonstração do uso de JComboBox.
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
   
public class JComboBoxDemo { 
  
  // Array de opções para o JComboBox
  String timepieces[] = { "Locate", "Analog", "Digital", "Stopwatch" }; 
 
  public JComboBoxDemo() { 
 
    // Configuração da janela principal (JFrame)
    JFrame jfrm = new JFrame("JCombBoxDemo");
    jfrm.setLayout(new FlowLayout()); // Define o layout
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
    jfrm.setSize(400, 250);  // Define o tamanho da janela
 
    // Criação do JComboBox e adição à janela
    JComboBox<String> jcb = new JComboBox<String>(timepieces); 
    // Também é possível adicionar itens individuais ao JComboBox
    // jcb.addItem("Pendulum");
    // Define o item selecionado por padrão (o índice deveria ser um valor válido, mas está comentado)
    // jcb.setSelectedItem(2);
    jfrm.add(jcb); 
    // Remove todos os itens do JComboBox (se necessário)
    // jcb.removeAllItems();
 
    // Criação de um JLabel com um ícone inicial (imagem "locate.png")
    JLabel jlab = new JLabel(new ImageIcon("locate.png")); 
    jfrm.add(jlab); 

    // Manipulação das seleções no JComboBox
    jcb.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        // Obtém o item selecionado
        String s = (String) jcb.getSelectedItem(); 
        // Atualiza o ícone do JLabel para a imagem correspondente
        jlab.setIcon(new ImageIcon(s + ".png")); 
      } 
    }); 

    // Torna a janela visível
    jfrm.setVisible(true);
  } 

  public static void main(String[] args) { 
    // Cria a janela na thread de despacho de eventos
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JComboBoxDemo(); 
        } 
      } 
    ); 
  }
}
