
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Galeria{
    String imagens[] = { "image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg"};
    int currentIndex = 0;
    JLabel jLab;
    
    public Galeria() {

      //configuração da janela principal(Jframe)
      JFrame jfrm = new JFrame("Galeria de imagens");
      jfrm.setLayout(new BorderLayout());
      jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jfrm.setSize(800, 800);

      // Criar painel principal
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());

      // Criar rótulo para exibição de imagens
      jLab = new JLabel(new ImageIcon(imagens[currentIndex]));
      jLab.setHorizontalAlignment(JLabel.CENTER);//centraliza a imagen
      jfrm.add(jLab, BorderLayout.NORTH); //adcionao rótulo ao frame

      //criar painel para botões
      JPanel buttonPanel = new JPanel(); //cria um painel
      buttonPanel.setLayout(new FlowLayout());
      JButton prevButton = new JButton("Previous ");//cria botão de voltar
      JButton nextButton = new JButton("Next ");//cria botão de voltar

      //acão para o botão "previous"
      prevButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
          if(currentIndex > 0){
            currentIndex--;
            jLab.setIcon(new ImageIcon(imagens[currentIndex]));
          }
        }
      });

      nextButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
          if(currentIndex < imagens.length -1){
            currentIndex++;
            jLab.setIcon(new ImageIcon(imagens[currentIndex]));
          }
        }
      });


      //adicionar botçoes ao painel
      buttonPanel.add(prevButton);
      buttonPanel.add(nextButton);
      jfrm.add(buttonPanel, BorderLayout.CENTER);//adiciona o painel ao frame

    
      //exibir janela
      jfrm.setVisible(true);
    }

  public static void main(String[] args) { 
      // Cria a janela na thread de despacho de eventos
      SwingUtilities.invokeLater(new Runnable() { 
          public void run() { 
            new Galeria(); 
          } 
        } 
      ); 
    }


}