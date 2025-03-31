import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class SimpleCalculator extends JFrame {
    private JTextField display; // Visor da calculadora
    private StringBuilder expression; // Armazena a expressão digitada

    public SimpleCalculator() {
        // Configura a janela
        super("Calculadora Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Inicializa o visor
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        add(display, BorderLayout.NORTH);

        // Inicializa a expressão
        expression = new StringBuilder();

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        // Botões da calculadora
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"  // Botão para limpar
        };

        // Adiciona os botões ao painel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Exibe a janela
        setVisible(true);
    }

    // Listener para os botões
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("C")) {
                // Limpa a expressão e o visor
                expression.setLength(0);
                display.setText("0");
            } else if (command.equals("=")) {
                // Valida e calcula a expressão
                String result = evaluateExpression(expression.toString());
                display.setText(result);
                expression.setLength(0); // Reseta para nova entrada
                expression.append(result);
            } else {
                // Adiciona o caractere à expressão e atualiza o visor
                expression.append(command);
                display.setText(expression.toString());
            }
        }
    }

    // Valida e calcula a expressão usando pilha
    private String evaluateExpression(String expr) {
        // Remove espaços (se houver)
        expr = expr.replaceAll("\\s+", "");

        // Verifica se a expressão é bem formada usando pilha
        if (!isWellFormed(expr)) {
            return "Expressão mal formada";
        }

        try {
            // Calcula o resultado
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();
            StringBuilder number = new StringBuilder();

            for (int i = 0; i < expr.length(); i++) {
                char c = expr.charAt(i);

                if (Character.isDigit(c) || c == '.') {
                    number.append(c); // Constrói o número
                } else if (isOperator(c)) {
                    if (number.length() > 0) {
                        numbers.push(Double.parseDouble(number.toString()));
                        number.setLength(0);
                    }
                    operators.push(c);
                }
            }
            // Adiciona o último número, se houver
            if (number.length() > 0) {
                numbers.push(Double.parseDouble(number.toString()));
            }

            // Verifica se o número de operandos e operadores é compatível
            if (numbers.size() != operators.size() + 1) {
                return "Expressão mal formada";
            }

            // Calcula o resultado
            double result = numbers.pop();
            while (!operators.isEmpty()) {
                char op = operators.pop();
                double num = numbers.pop();
                switch (op) {
                    case '+': result = num + result; break;
                    case '-': result = num - result; break;
                    case '*': result = num * result; break;
                    case '/': 
                        if (result == 0) return "Divisão por zero";
                        result = num / result; 
                        break;
                }
            }
            return String.valueOf(result);
        } catch (Exception e) {
            return "Expressão mal formada";
        }
    }

    // Verifica se o caractere é um operador
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Valida se a expressão é bem formada usando pilha
    private boolean isWellFormed(String expr) {
        Stack<Character> stack = new Stack<>();
        boolean expectNumber = true; // True: espera número, False: espera operador

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                if (!expectNumber) return false; // Número onde deveria haver operador
                // Pula todos os dígitos e o ponto decimal do número
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    i++;
                }
                i--; // Volta um passo para não pular o próximo caractere
                expectNumber = false; // Após número, espera operador
            } else if (isOperator(c)) {
                if (expectNumber) return false; // Operador onde deveria haver número
                stack.push(c);
                expectNumber = true; // Após operador, espera número
            } else {
                return false; // Caractere inválido
            }
        }

        // Verifica se terminou esperando um operador (incompleto)
        return !expectNumber && stack.size() == expr.chars().filter(ch -> isOperator((char)ch)).count();
    }

    public static void main(String[] args) {
        // Define o tema nativo (opcional)
        // try {
        //     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // Executa a aplicação
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}