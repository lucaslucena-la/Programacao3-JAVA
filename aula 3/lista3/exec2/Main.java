
public class Main {
    public static void main(String[] args) {


        // Criando instâncias dos personagens
        Guerreiro guerreiro = new Guerreiro("Thor", 10, 50);
        Mago mago = new Mago("Merlin", 8, 50, 40);  // Mago com 50 de mana e 40 de poder mágico
        Arqueiro arqueiro = new Arqueiro("Legolas", 7);

        // Imprimindo os detalhes iniciais de todos os personagens
        System.out.println("Detalhes dos Personagens:");
        guerreiro.exibirDetalhes();System.out.println();
        mago.exibirDetalhes();System.out.println();
        arqueiro.exibirDetalhes();System.out.println();

        // Simulando a batalha
        System.out.println("\nIniciando a Batalha:");

        // Guerreiro ataca o Mago
        System.out.println("\nAção 1: " + guerreiro.getNome() + " ataca " + mago.getNome());
        guerreiro.atacar(mago);
        mago.exibirDetalhes();System.out.println();

        // Mago lança uma magia no Arqueiro
        System.out.println("\nAção 2: " + mago.getNome() + " lança uma magia em " + arqueiro.getNome());
        mago.lancarMagia(arqueiro);
        arqueiro.exibirDetalhes();System.out.println();

        // Mago tenta lançar magia novamente (para testar a redução de mana)
        System.out.println("\nAção 3: " + mago.getNome() + " tenta lançar outra magia em " + arqueiro.getNome());
        mago.lancarMagia(arqueiro);
        arqueiro.exibirDetalhes();System.out.println();

        // Arqueiro dispara uma flecha no Guerreiro
        System.out.println("\nAção 4: " + arqueiro.getNome() + " dispara uma flecha em " + guerreiro.getNome() );
        arqueiro.dispararFlechas(guerreiro);
        guerreiro.exibirDetalhes();System.out.println();
    }
}
