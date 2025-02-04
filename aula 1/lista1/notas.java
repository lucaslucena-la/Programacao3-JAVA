import java.util.Random;
import java.util.Scanner;

// Classe principal onde o programa é executado
class notas {
    public static void main(String[] args) {
        // Objeto Scanner para entrada de dados pelo usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita a quantidade de alunos ao usuário
        System.out.print("Quantidade de alunos: ");
        int qtdAlunos = scanner.nextInt();

        // Solicita a quantidade de provas por aluno
        System.out.print("Quantidade de provas por aluno: ");
        int qtdProvas = scanner.nextInt();

        // Criação de uma matriz 2D para armazenar as notas dos alunos
        float[][] matriz = new float[qtdAlunos][qtdProvas];

        // Informar que os elementos serão gerados
        System.out.println("Elementos do Array: ");

        // Criação de um objeto Random para gerar números aleatórios
        Random aleatorio = new Random();

        // Preenche a matriz com notas aleatórias entre 0 e 10
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = aleatorio.nextFloat() * 10; // Multiplica por 10 para gerar números entre 0 e 10
            }
        }

        // Variável para rastrear o número do aluno ao exibir as notas
        int aluno = 1;
        // Exibe a matriz (notas de cada aluno) formatada
        for (var linha : matriz) { // Para cada linha (aluno) da matriz
            System.out.printf("Aluno : %d ", aluno ++);
            for (var coluna : linha) { // Para cada coluna (nota) na linha
                System.out.printf("%.1f ", coluna); // Exibe a nota com uma casa decimal
            }
            System.out.println(); // Quebra de linha após exibir todas as notas de um aluno
        }

        // Calcula a soma, média e exibe o status (aprovado, recuperação ou reprovado)
        for (int i = 0; i < qtdAlunos; i++) { // Itera por cada aluno
            float soma = 0; // Variável para armazenar a soma das notas do aluno
            for (int j = 0; j < qtdProvas; j++) { // Itera pelas provas do aluno
                soma += matriz[i][j]; // Acumula as notas
            }

            // Calcula a média do aluno
            float mediaaluno = soma / qtdProvas;

            // Condicional para determinar o status do aluno
            if (mediaaluno >= 7.0) {
                // Exibe o resultado se o aluno for aprovado
                System.out.printf("\nAluno %d: Soma = %.2f; Média = %.2f: Aprovado", (i + 1), soma, mediaaluno);
            } else if (mediaaluno >= 5.0 && mediaaluno < 7.0) {
                // Exibe o resultado se o aluno estiver de recuperação
                System.out.printf("\nAluno %d: Soma = %.2f; Média = %.2f: Recuperação", (i + 1), soma, mediaaluno);
            } else {
                // Exibe o resultado se o aluno for reprovado
                System.out.printf("\nAluno %d: Soma = %.2f; Média = %.2f: Reprovado", (i + 1), soma, mediaaluno);
            }
        }
        
        // Mensagem de encerramento
        System.err.println("\n");
    }
}
