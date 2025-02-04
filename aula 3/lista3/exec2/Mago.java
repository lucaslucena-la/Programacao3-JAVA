
public class Mago extends Personagem{
    protected int mana = 50;//representa energia para lan ̧car magias
    protected int poderMagico; //representa o dano causado por magias
    
    Mago (String nome, int nivel, int mana, int poderMagico){
        super(nome, nivel, 100);
        this.mana = mana;
        this.poderMagico = poderMagico; 
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Mana: " + mana);
        System.out.println("Poder mágico: " + poderMagico);
    }

    public void lancarMagia(Personagem inimigo){
        if (mana < 10){
            System.out.println("Impossivel lançar magia, MANA menor que 10");
        }else{
            System.out.println(this.getNome() + " lança uma magia em " + inimigo.getNome() + " causando " + poderMagico + " de dano!");
            inimigo.receberDano(poderMagico);
            mana =-10;
            if(mana < 10 ){
                mana = 0;
            }
            System.out.println(this.getNome() + " perdeu 10 de mana. Mana restante: " + mana);
        }

    }

    


}
