import java.util.Random;


public class Arqueiro extends Personagem {
    protected int precisao;//representa a chance de acerto de 0 a 10

    Arqueiro(String nome, int nivel){
        super(nome, nivel,100);
        this.precisao = new Random().nextInt(101);  // Sorteia um número entre 0 e 100
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Precisão: " + precisao);
    }

    public void dispararFlechas(Personagem inimigo){
        
        
        if (this.precisao > 50){
            int dano = 20;
            System.out.println("Disparo foi bem sucedido e " + getNome() + " causa " + dano + " de dano" );
            inimigo.receberDano(dano);
        }else{
            System.out.println("O disparo não foi bem sucedido");
        }

    }

}
