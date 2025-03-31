/*
* =============================================================
* Exercício 2: Seletor de Estados e Cidades
* Disciplina: Programação III
* Tema: Interface Gráfica com Java Swing
*
* Enunciado:
* - Criar uma aplicação Swing com duas JComboBox:
*   • A primeira lista os estados: "MT", "GO", "MS".
*   • A segunda exibe as cidades conforme o estado selecionado.
*
* Requisitos:
* - "MT": exibe "Barra do Garças", "Cuiabá", "Rondonópolis"
* - "GO": exibe "Goiânia", "Anápolis", "Aparecida"
* - "MS": exibe "Campo Grande", "Naviraí", "Coxim"
*
* Dica:
* - Usar um HashMap<String, String[]> para mapear os estados às suas respectivas cidades.
*
* Resultado Esperado:
* - Ao iniciar, "MT" já está selecionado, e a segunda JComboBox mostra suas cidades.
* - Ao trocar o estado na primeira JComboBox, a lista de cidades atualiza automaticamente.
*
* Objetivo:
* - Praticar o uso de JComboBox, eventos de seleção e manipulação de dados com HashMap.
* =============================================================
*/


import java.awt.*;                 // Importa classes para layout e componentes gráficos
import java.awt.event.*;           // Importa classes para tratamento de eventos
import javax.swing.*;              // Importa componentes Swing
import java.util.HashMap;          // Importa o HashMap para mapear estados às cidades
import java.util.Map;              // Interface de Map



public class Selector {

    //arrays com os nomes dos estados disponiveis
    String estados [] = {"MT", "GO"};

    //arrays com as cidades correspondentes a cada estado

    String cidadesMT[] = {"Barra do garças", "Cuiabá", "Rondonópolis"};
    String cidadesGO[] = {"Goiãnia", "Anápolis", "Aparecida"};
    
    //indice de controle 

    //Jlabel para exibir uma mensagem ou informações 
    JLabel jlab;

    //JCombobox para seleção de estados;
    JComboBox<String> jcbEstados;

    //Jcombobox para seleção de cidades
    JComboBox<String> jcbCidades;

    //hashmap que associa cada estado ao seu respectivo array de cidades
    Map<String, String[]> cidades = new HashMap<>();

    //construtor da classe> onde toda a interface gráfica é cirada
    public Selector(){

        //mapeia os estados às suas respectivas cidades no hashmap
        cidades.put("MT", cidadesMT);
        cidades.put("GO", cidadesGO);

        //cria a janela principal
        JFrame jfrm = new JFrame ("Seletor de cidades");

        //define o layout da jnela com BorderLayout(divide em note, sul, centro, etc...)
        jfrm.setLayout(new BorderLayout());

        //define o comportamento ao fechar janela: encerrar a aplicação
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //define o tamanho da janela (largura x altura)
        jfrm.setSize(500, 500);

        //criar o painel principal da interface 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //criar um rótulo para orientação inicial do usuário
        jlab = new JLabel("Selecionar um estado");

        //centraliza o texto dentro do JLabel
        jlab.setHorizontalAlignment(JLabel.CENTER);

        //adiciona o JLabel à parte superior (NORTH) da janela
        jfrm.add(jlab, BorderLayout.NORTH);

        //cria um painel para conter as JComboBox
        JPanel comboBoxPanel = new JPanel();

        //define o layout desse painel como FlowLayout(componentes um ao lado do outro)
        comboBoxPanel.setLayout(new FlowLayout());

        //cria a JCombobox com os estados disponiveis
        jcbEstados = new JComboBox<>(estados);

        //adiciona o ouvinte de eventos (listener) para captura a mudança de estados selecionado
        jcbEstados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //obtém o estado selecionado
                String estado = (String) jcbEstados.getSelectedItem();

                //limpa os itens atuais da lista de cidades
                jcbCidades.removeAllItems();

                //adiciona à lista de cidades as cidades do estado selecionado
                for(String cidade : cidades.get(estado)){
                    jcbCidades.addItem(cidade);
                }
            }
        });

        //cira a JComboBox das cidade com nase no estado incial (MT)
        jcbCidades = new JComboBox<>(cidadesMT);

        //adiciona as duas JComboBox ao painel
        comboBoxPanel.add(jcbEstados);
        comboBoxPanel.add(jcbCidades);
        
        //adiciona o painel com as JComboBoc ao centro da janela
        jfrm.add(comboBoxPanel, BorderLayout.CENTER);

        //torna a janela vicível ao usuário
        jfrm.setVisible(true);

        
    }
    //método main:ponto de entrada da aplicação
    public static void main (String[] args){
        //exectua a interface gráfica na thread de eventos (EDT)
        SwingUtilities.invokeLater(new Runnable(){
            public void run (){
                new Selector();//cria a interface gráfica
            }
        });
    }


}
