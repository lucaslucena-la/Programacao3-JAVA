class Personagem {

    private String nome;
    protected int nivel;
    protected int pontosDeVida = 100;

    Personagem(String nome, int nivel, int pontosDeVida){
        this.nome = nome;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void exibirDetalhes(){
        System.out.println("Nome: " + nome);
        System.out.println("Nivel: " + nivel);
        System.out.println("Pontos de vida: " + pontosDeVida);
    }

    public void receberDano(int dano){
        if(pontosDeVida > 0){
            this. pontosDeVida -= dano;
            if(this.pontosDeVida < 0){
                this.pontosDeVida = 0;
            }
        }
    }
}