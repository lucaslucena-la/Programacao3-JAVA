import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingModelDelegateDemo {
    private JFrame frame;
    private JCheckBox checkBox;
    private JButton toggleThemeButton;

    public SwingModelDelegateDemo() {
        // Cria a janela principal
        frame = new JFrame("Exemplo Model-Delegate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Cria uma checkbox (com modelo implícito: ButtonModel)
        checkBox = new JCheckBox("Ativar/Desativar");
        checkBox.setSelected(false); // Estado inicial do modelo

        // Cria um botão para mudar o tema
        toggleThemeButton = new JButton("Mudar Tema");
        toggleThemeButton.addActionListener(new ActionListener() {
            private boolean isNativeTheme = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isNativeTheme) {
                        // Volta para o tema Metal
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    } else {
                        // Usa o tema nativo do sistema
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    }
                    isNativeTheme = !isNativeTheme;

                    // Atualiza a interface para refletir o novo tema
                    SwingUtilities.updateComponentTreeUI(frame);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Adiciona os componentes à janela
        frame.add(checkBox);
        frame.add(toggleThemeButton);

        // Exibe a janela
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        

        // Cria a interface na thread de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingModelDelegateDemo();
            }
        });
    }
}