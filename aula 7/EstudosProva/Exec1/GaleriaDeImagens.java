/*
* =============================================================
* Exercício: Galeria de Imagens com Java Swing
* Disciplina: Programação III
* Tema: Interface Gráfica com Swing
*
* Enunciado:
* - Criar uma aplicação Swing que simule uma galeria de imagens.
* - A interface deve conter:
*   • Um JLabel que exibe uma imagem (.png)
*   • Dois botões: “Next” e “Previous” para navegar pelas imagens
* - As imagens devem estar no mesmo diretório do programa e
*   seguir um padrão de nome (ex: imagem1.png, imagem2.png...)
*
* Objetivo:
* Aprender a carregar imagens, navegar entre elas e construir
* uma interface gráfica interativa com Swing.
* =============================================================
*/


// Importa os pacotes necessários para interface gráfica (Swing) e layout (AWT)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Classe principal da aplicação
public class GaleriaDeImagens {

    // Array com os nomes dos arquivos de imagem
    String imagens[] = { "image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg" };

    // Índice que controla qual imagem está sendo exibida atualmente
    int currentIndex = 0;

    // JLabel que irá exibir as imagens na interface
    JLabel jLab;

    // Construtor da classe, onde toda a interface é montada
    public GaleriaDeImagens() {

        // Cria a janela principal (JFrame)
        JFrame jfrm = new JFrame("Galeria de imagens");

        // Define o layout da janela como BorderLayout (divide a janela em regiões)
        jfrm.setLayout(new BorderLayout());

        // Define a operação padrão ao fechar a janela (encerra o programa)
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define o tamanho da janela (largura x altura)
        jfrm.setSize(800, 800);

        // Cria o painel principal da interface
        JPanel mainPanel = new JPanel();

        // Define o layout do painel principal como BorderLayout
        mainPanel.setLayout(new BorderLayout());

        // Cria o rótulo (JLabel) que vai exibir a imagem atual
        // Começa com a imagem na posição 0 do array
        jLab = new JLabel(new ImageIcon(imagens[currentIndex]));

        // Centraliza a imagem no JLabel (horizontalmente)
        jLab.setHorizontalAlignment(JLabel.CENTER);

        // Adiciona o JLabel com a imagem à parte superior da janela
        jfrm.add(jLab, BorderLayout.NORTH);

        // Cria um painel para conter os botões (Previous / Next)
        JPanel buttonPanel = new JPanel();

        // Define o layout desse painel como FlowLayout (botões lado a lado)
        buttonPanel.setLayout(new FlowLayout());

        // Cria o botão "Previous" (voltar imagem)
        JButton prevButton = new JButton("Previous ");

        // Cria o botão "Next" (avançar imagem)
        JButton nextButton = new JButton("Next ");

        // Adiciona ação ao botão "Previous"
        prevButton.addActionListener(new ActionListener() {
            // Método executado quando o botão é clicado
            public void actionPerformed(ActionEvent e) {
                // Se não for a primeira imagem
                if (currentIndex > 0) {
                    currentIndex--; // Decrementa o índice
                    jLab.setIcon(new ImageIcon(imagens[currentIndex])); // Atualiza imagem no JLabel
                }
            }
        });

        // Adiciona ação ao botão "Next"
        nextButton.addActionListener(new ActionListener() {
            // Método executado quando o botão é clicado
            public void actionPerformed(ActionEvent e) {
                // Se ainda houver próxima imagem
                if (currentIndex < imagens.length - 1) {
                    currentIndex++; // Incrementa o índice
                    jLab.setIcon(new ImageIcon(imagens[currentIndex])); // Atualiza imagem no JLabel
                }
            }
        });

        // Adiciona os dois botões ao painel
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        // Adiciona o painel de botões à região central da janela
        jfrm.add(buttonPanel, BorderLayout.CENTER);

        // Torna a janela visível ao usuário
        jfrm.setVisible(true);
    }

    // Método main: ponto de entrada da aplicação
    public static void main(String[] args) {
        // Cria a janela na thread de despacho de eventos (boa prática no Swing)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GaleriaDeImagens(); // Cria a interface
            }
        });
    }
}
