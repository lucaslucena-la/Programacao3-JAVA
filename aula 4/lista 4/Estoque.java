import java.util.*; // Importa todas as classes do pacote java.util (HashMap, Scanner, Map.Entry)


// Classe Produto que representa cada item no estoque
class Produto {
    private String nome; // Nome do produto
    private int quantidade; // Quantidade disponível no estoque

    // Construtor da classe Produto, recebe nome e quantidade
    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    // Método getter para obter o nome do produto
    public String getNome() {
        return nome;
    }

    // Método getter para obter a quantidade do produto
    public int getQuantidade() {
        return quantidade;
    }

    // Método setter para atualizar a quantidade do produto
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método toString sobrescrito para exibir os detalhes do produto
    @Override
    public String toString() {
        return "Nome: " + nome + ", Quantidade em estoque: " + quantidade;
    }
}


// Classe principal do programa de controle de estoque
public class Estoque {
    private static Map<Integer, Produto> estoque = new HashMap<>(); // Usamos um HashMap para armazenar os produtos (chave: código, valor: Produto)
    private static Scanner scanner = new Scanner(System.in); // Scanner para entrada de dados do usuário

    public static void main(String[] args) {
        int opcao; // Variável que armazenará a opção do usuário no menu

        do {
            // Exibição do menu interativo
            System.out.println("\n=== CONTROLE DE ESTOQUE ===");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Atualizar quantidade de um produto");
            System.out.println("3. Remover um produto");
            System.out.println("4. Buscar um produto pelo código");
            System.out.println("5. Exibir todos os produtos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário
            scanner.nextLine(); // Consumir a quebra de linha para evitar erros na leitura de strings

            // Estrutura switch para chamar a função correspondente à escolha do usuário
            switch (opcao) {
                case 1:
                    cadastrarProduto(); // Chama o método para cadastrar um novo produto
                    break;
                case 2:
                    atualizarQuantidade(); // Chama o método para atualizar a quantidade de um produto
                    break;
                case 3:
                    removerProduto(); // Chama o método para remover um produto do estoque
                    break;
                case 4:
                    buscarProduto(); // Chama o método para buscar um produto pelo código
                    break;
                case 5:
                    exibirProdutos(); // Chama o método para exibir todos os produtos cadastrados
                    break;
                case 6:
                    System.out.println("Saindo do sistema. Até mais!"); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // Caso o usuário escolha uma opção inválida
            }
        } while (opcao != 6); // O loop continua até que o usuário escolha a opção de sair (6)

        scanner.close(); // Fecha o Scanner para evitar vazamento de recursos
    }

    // Método para cadastrar um novo produto
    private static void cadastrarProduto() {
        System.out.println("Digite o código do produto: ");
        int codigo = scanner.nextInt(); // Lê o código do produto
        scanner.nextLine(); // Consumir a quebra de linha

        // Verifica se o código já existe no HashMap
        if (estoque.containsKey(codigo)) {
            System.out.println("Erro: Código já registrado!");
            return; // Sai do método sem cadastrar
        }

        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine(); // Lê o nome do produto

        System.out.println("Digite a quantidade inicial do produto: ");
        int quantidade = scanner.nextInt(); // Lê a quantidade inicial

        // Adiciona o produto no HashMap (chave: código, valor: novo Produto)
        estoque.put(codigo, new Produto(nome, quantidade));
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Método para atualizar a quantidade de um produto existente no estoque
    private static void atualizarQuantidade() {
        System.out.println("Digite o código do produto: ");
        int codigo = scanner.nextInt(); // Lê o código do produto

        // Verifica se o produto existe no estoque
        if (!estoque.containsKey(codigo)) {
            System.out.println("Erro: Produto não encontrado!");
            return;
        }

        System.out.println("Digite a nova quantidade: ");
        int novaQuantidade = scanner.nextInt(); // Lê a nova quantidade informada pelo usuário

        // Atualiza a quantidade do produto no HashMap
        estoque.get(codigo).setQuantidade(novaQuantidade);
        System.out.println("Quantidade atualizada com sucesso!");
    }

    // Método para remover um produto do estoque
    private static void removerProduto() {
        System.out.println("Digite o código do produto: ");
        int codigo = scanner.nextInt(); // Lê o código do produto

        // Tenta remover o produto do estoque e verifica se foi encontrado
        if (estoque.remove(codigo) != null) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado!");
        }
    }

    // Método para buscar um produto pelo código e exibir suas informações
    private static void buscarProduto() {
        System.out.println("Digite o código do produto: ");
        int codigo = scanner.nextInt(); // Lê o código do produto

        // Verifica se o código do produto existe no estoque
        if (!estoque.containsKey(codigo)) {
            System.out.println("Erro: Produto não encontrado!");
            return;
        }

        // Exibe as informações do produto encontrado
        System.out.println("Produto encontrado: " + estoque.get(codigo));
    }

    // Método para exibir todos os produtos cadastrados no estoque
    private static void exibirProdutos() {
        // Verifica se o estoque está vazio
        if (estoque.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            System.out.println("Produtos em estoque:");
            // Percorre o HashMap e exibe cada produto
            for (Map.Entry<Integer, Produto> entry : estoque.entrySet()) {
                System.out.println("Código: " + entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}
