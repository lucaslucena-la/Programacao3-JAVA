/*
* - Crie uma aplica ̧c ̃ao em Java Swing chamada ”ToDoListApp”que funcione como uma lista de tarefas. A interface deve conter:
* - Um campo de texto (JTextField) para digitar uma nova tarefa
* - Um bot ̃ao ”Adicionar”para incluir a tarefa na lista.
* - Uma lista (JList) que exibe todas as tarefas adicionadas
* - Um bot ̃ao ”Concluir”que marca a tarefa selecionada como conclu ́ıda, adicionando ”[Conclu ́ıda]”ao texto.
* - Um bot ̃ao ”Remover”que exclui a tarefa selecionada da lista.
* - Use DefaultListModel para gerenciar os itens da lista
* -Valide que o campo de texto n ̃ao esteja vazio ao adicionar e exiba mensagens de erro com JOptionPane se o usu ́ario tentar concluir ou remover sem selecionar uma tarefa
* -
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.*;

public class Tarefas extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField textField;
    private JButton addBtn;
    private JButton concluirBtn;
    private JButton removerBtn;

    public Tarefas() {
        super("ToDoListApp");
        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        textField = new JTextField(20);
        addBtn = new JButton("Adicionar");
        concluirBtn = new JButton("Concluir");
        removerBtn = new JButton("Remover");

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo de texto vazio!");
                } else {
                    listModel.addElement(textField.getText());
                    textField.setText("");
                }
            }
        });

        concluirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (list.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione uma tarefa!");
                } else {
                    listModel.setElementAt("[Concluída] " + listModel.getElementAt(list.getSelectedIndex()), list.getSelectedIndex());
                }
            }
        });

        removerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (list.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione uma tarefa!");
                } else {
                    listModel.remove(list.getSelectedIndex());
                }
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (list.getSelectedIndex() == -1) {
                    concluirBtn.setEnabled(false);
                    removerBtn.setEnabled(false);
                } else {
                    concluirBtn.setEnabled(true);
                    removerBtn.setEnabled(true);
                }
            }
        });

        setLayout(new FlowLayout());
        add(textField);
        add(addBtn);
        add(concluirBtn);
        add(removerBtn);
        add(new JScrollPane(list));

        concluirBtn.setEnabled(false);
        removerBtn.setEnabled(false);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tarefas();
    }
}
