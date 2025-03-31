/*
* =============================================================
* Exercício 3: Lista de Tarefas Simples - ToDoListApp
* Disciplina: Programação III
* Tema: Interface Gráfica com Java Swing
*
* Enunciado:
* - Criar uma aplicação Swing chamada "ToDoListApp" que funcione como uma lista de tarefas.
* - A interface deve conter:
*   • Um campo de texto (JTextField) para digitar uma nova tarefa.
*   • Um botão "Adicionar" para incluir a tarefa na lista.
*   • Uma lista (JList) que exibe todas as tarefas adicionadas.
*   • Um botão "Concluir" que marca a tarefa selecionada como concluída,
*     adicionando "[Concluída]" ao texto.
*   • Um botão "Remover" que exclui a tarefa selecionada da lista.
*
* Requisitos técnicos:
* - Utilizar DefaultListModel para gerenciar os itens da lista.
* - Validar que o campo de texto não esteja vazio ao adicionar.
* - Exibir mensagens de erro com JOptionPane se o usuário tentar:
*   → Adicionar tarefa com campo vazio.
*   → Concluir ou remover sem nenhuma tarefa selecionada.
*
* Resultado Esperado:
* - Ao digitar "Estudar Java" e clicar em "Adicionar", a lista exibe: Estudar Java
* - Ao selecionar "Estudar Java" e clicar em "Concluir", aparece: Estudar Java [Concluída]
* - Ao clicar em "Remover", a tarefa selecionada é apagada da lista.
*
* Objetivo:
* - Praticar o uso de componentes como JTextField, JButton, JList e JOptionPane,
*   além de eventos e validações no contexto de uma aplicação de produtividade.
* =============================================================
*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame {
    private JTextField taskField;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public ToDoListApp() {
        super("Lista de Tarefas");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Campo de texto e botão Adicionar
        taskField = new JTextField(20);
        JButton addButton = new JButton("Adicionar");

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Lista de tarefas
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Botões Concluir e Remover
        JButton completeButton = new JButton("Concluir");
        JButton removeButton = new JButton("Remover");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(removeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Listeners (a implementar)
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Adicionar tarefa ao listModel
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                }else{
                    JOptionPane.showMessageDialog(ToDoListApp.this, "Digite uma tarefa antes de adicionar.", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Marcar tarefa como concluída
                listModel.setElementAt("[Concluída] " + listModel.getElementAt(taskList.getSelectedIndex()), taskList.getSelectedIndex());
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Remover tarefa selecionada
                listModel.remove(taskList.getSelectedIndex());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListApp();
            }
        });
    }
}