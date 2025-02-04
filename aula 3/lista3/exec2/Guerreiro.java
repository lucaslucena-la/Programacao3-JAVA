
public class Guerreiro extends Personagem {
    protected int forca ;

    Guerreiro(String nome, int nivel, int forca){
        super(nome, nivel, 100);
        this.forca = forca;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Força: " + forca);
    }

    void atacar(Personagem inimigo){
        System.out.println("Guerreiro " + getNome() + " ataca " + inimigo.getNome() + " e causa " + forca +" de dano");
        inimigo.receberDano(forca);
    }
}
