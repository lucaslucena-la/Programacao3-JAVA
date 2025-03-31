/*
* Crie uma aplica ̧c ̃ao em Java Swing que permita ao usu ́ario selecionar um estado e visualizar suas cidades correspondentes. A interface deve conter:
* - Uma JComboBox com os estados ”MT”, ”GO”e ”MS”
* 
* Uma segunda JComboBox que exibe cidades conforme o estado selecionado:
– ”MT”: Barra do Gar ̧cas, Cuiab ́a, Rondon ́opolis.
– ”GO”: Goiˆania, An ́apolis, Aparecida.
– ”MS”: Campo Grande, Navira ́ı, Coxim

Sugestao: Use um HashMap para mapear os estados `as suas cidades
*/

//package Lista.exec2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Seletor{
    String estados[] = {"MT", "GO", "MS"};
    String cidadesMT[] = {"Barra do Garças", "Cuiabá", "Rondonóplis"};
    String cidadesGO[] = {"Goiânia", "Anápolis", "Aparecida"};
    String cidadesMS [] = {"Campo Grande", "Naviraí", "Coxim"};
    int currentIndex = 0;
    
    JLabel jLab; 
    JComboBox<String> jcbEstados;//combobox para estados
    JComboBox<String> jcbCidades;//combobox para cidades
    Map<String, String[] > cidades = new HashMap<>();

    public Seletor() {
        cidades.put("MT", cidadesMT);
        cidades.put("GO", cidadesGO);
        cidades.put("MS", cidadesMS);
        
        //configuração da janela principal(Jframe)
        JFrame jfrm = new JFrame ("Seletor de cidades");
        jfrm.setLayout(new BorderLayout()); // define o layout do frame como boderlayout: norte, sul, leste, oeste e centro
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // dfeine a ação padão ao fechar a janela
        jfrm.setSize(500, 500);
        
        //criar paneil principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); //define o layout do painel como borderLayout também 
        
        //criar rótulo para exibição de cidades
        jLab = new JLabel("Selecione um estado");
        jLab.setHorizontalAlignment(JLabel.CENTER);
        jfrm.add(jLab, BorderLayout.NORTH); 

        //criar painel para combobox
        JPanel comboBoxPanel = new JPanel(); //criar um painel para as combobox 
        comboBoxPanel.setLayout(new FlowLayout()); //define o layout do painel como flowLayout

        //criar combobox para estados
        jcbEstados = new JComboBox<>(estados); 
        jcbEstados.setSelectedItem(comboBoxPanel); // seleciona o primeiro item da combobox
        jcbEstados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String estado = (String) jcbEstados.getSelectedItem();
                jcbCidades.removeAllItems();
                for(String cidade: cidades.get(estado)){
                    jcbCidades.addItem(cidade);
                }
            }
        });

        //criar combobox para cidades
        jcbCidades = new JComboBox<>(cidadesMT);
        jcbEstados.setSelectedItem(comboBoxPanel); // seleciona o primeiro item da combobox
        comboBoxPanel.add(jcbEstados);
        comboBoxPanel.add(jcbCidades);
        jfrm.add(comboBoxPanel, BorderLayout.CENTER);

        //exibit janela
        jfrm.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Seletor();
            }
        });
    }
}
 