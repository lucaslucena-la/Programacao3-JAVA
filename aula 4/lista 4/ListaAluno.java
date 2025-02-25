import java.util.*;

public class ListaAluno {
    private static Map<Integer, String> mapa = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Gerenciamento de Alunos");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Remover aluno");
            System.out.println("3 - Exibir lista de alunos ordenada alfabeticamente");
            System.out.println("4 - Verificar se um aluno está cadastrado");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarAluno(scanner);
                    break;
                case 2:
                    removerAluno(scanner);
                    break;
                case 3:
                    exibirAlunosOrdenados();
                    break;
                case 4:
                    verificarAluno(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static void adicionarAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o número de matrícula: ");
        int matricula = scanner.nextInt();

        if (mapa.containsKey(matricula)) {
            System.out.println("Erro: Número de matrícula já cadastrado!");
        } else {
            mapa.put(matricula, nome);
            System.out.println("Aluno adicionado com sucesso!");
        }
    }

    public static void removerAluno(Scanner scanner) {
        System.out.print("Digite o número de matrícula do aluno a ser removido: ");
        int matricula = scanner.nextInt();

        if (mapa.containsKey(matricula)) {
            mapa.remove(matricula);
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Erro: Aluno não encontrado!");
        }
    }

    public static void exibirAlunosOrdenados() {
        if (mapa.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\nLista de alunos ordenada alfabeticamente:");
        mapa.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(entry -> System.out.println("Matrícula: " + entry.getKey() + " - Nome: " + entry.getValue()));
    }

    public static void verificarAluno(Scanner scanner) {
        System.out.print("Digite o número de matrícula a ser verificado: ");
        int matricula = scanner.nextInt();

        if (mapa.containsKey(matricula)) {
            System.out.println("Aluno encontrado: " + mapa.get(matricula));
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}
