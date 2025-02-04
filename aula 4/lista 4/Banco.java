import java.util.*; // Importa todas as classes do pacote java.util (HashMap, Scanner, Map.Entry)

public class Banco {
    private static Queue<String> fila = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao; // Variável que armazenará a opção do usuário no menu

        do {
            // Exibição do menu interativo
            System.out.println("\n=== FILA DE BANCO ===");
            System.out.println("1. Adicionar Cliente na fila");
            System.out.println("2. Chamar cliente");
            System.out.println("3. Exibir clientes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário
            scanner.nextLine(); // Consumir a quebra de linha para evitar erros na leitura de strings

            // Estrutura switch para chamar a função correspondente à escolha do usuário
            switch (opcao) {
                case 1:
                    adicionarCliente(); 
                    break;
                case 2:
                    chamarProximo();
                    break;
                case 3:
                    exibirClientes(); 
                    break;
                case 4:
                    System.out.println("Saindo do sistema. Até mais!"); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // Caso o usuário escolha uma opção inválida
            }
        } while (opcao != 6); 

        scanner.close(); 
    }
    

    //método para adicionar um cliente na fila

    private static void adicionarCliente(){
        System.out.println("Digite o nome do cliente: ");
        String cliente = scanner.nextLine();
        fila.add(cliente);
        System.out.println("Cliente " + cliente + " adicionado na lista de espera");
    }

    private static void chamarProximo(){
        System.out.println("Chamando próximo cliente da fila");
        System.out.println(fila.poll());
        

    }

    private static void exibirClientes(){
        if (fila.isEmpty()){
            System.out.println("Não há ninguém na fila");
            return;
        }else{
            System.out.println(fila);
        }
    }


}
