import java.util. *;
/*
 * Implemente um sistema para armazenar tarefas pendentes. O programa deve permitir:
    •Adicionar uma nova tarefa.
    •Marcar uma tarefa como concluída e removê-la da lista.
    •Exibir todas as tarefas pendentes.
    •Exibir a quantidade de tarefas ainda n ̃ao conclu ́ıdas
*/


public class tarefas {

    private static LinkedList<String> tarefasPendentes = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
            System.out.println("1. Adicionar nova tarefa");
            System.out.println("2. Marcar tarefa como concluída");
            System.out.println("3. Exibir todas as tarefas pendentes");
            System.out.println("4. Exibir quantidade de tarefas pendentes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    marcarTarefaConcluida();
                    break;
                case 3:
                    exibirTarefasPendentes();
                    break;
                case 4:
                    exibirQuantidadeTarefas();
                    break;
                case 5:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
        
        scanner.close();
    }


    //métodos para adicionar uma nov tarefa
    private static void adicionarTarefa() {
        System.out.println("Digite uma nova tarefa: ");
        String tarefa = scanner.nextLine();
        tarefasPendentes.add(tarefa);
        System.out.println("Tarefa adiciona com sucesso");
    }

    //método para marcar uma tarefa como concluída e removê-la da lista
    private static void marcarTarefaConcluida() {
        //caso não haja tarefas pendentes
        if (tarefasPendentes.isEmpty()){
            System.out.println("Não há tarefas pendentes.");
            return;
        }else{
            //caso haja tarefas pendentes 
            System.out.println("Tarefas pendentes: ");
            
            //for para mostrar as tarefas pendentesda linkedlist
            int i = 1;
            for (String tarefa: tarefasPendentes){
                System.out.println( i + ". "+ tarefa);
                i++;
            }
        }

        System.out.println("Digite o npumero da tarefa que deseja concluir: ");
        int indice = scanner.nextInt();//indice para remoção da tarefa
        scanner.nextLine(); //para consumir quebra de linha

        //usando iterator para remover de forma segura durante a iteração
        Iterator<String> iterator = tarefasPendentes.iterator();
        int contador = 1;

        while (iterator.hasNext()) {//enquanto houver elementos na lista
            String tarefa = iterator.next();//obtém a próxima tarefa 
            if (contador == indice){ //verfique se o índice corresponde à tarefa escolhida 
                System.out.println("Tarefa: " + tarefa + "Concluída e removida.");
                iterator.remove();
                return;
            }
            contador++;
        }
        System.out.println("Número inválido");
        
    }

    private static void exibirTarefasPendentes() {
        if (tarefasPendentes.isEmpty()){ //se a lista estiver vazia 
            System.out.println("Nnehuma tarefa pendente.");
        }else{
            System.out.println("Tarefas pendentes: ");
            for(String tarefa : tarefasPendentes){
                System.out.println("- " + tarefa);
            }
        }
    }

    private static void exibirQuantidadeTarefas() {
        System.out.println("Total e tarefas pendentes: "+ tarefasPendentes.size());
    }

}
