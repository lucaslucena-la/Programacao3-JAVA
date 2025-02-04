public class Pessoa{
    String nome; 
    int idade;
    String documento;

    //construtor
    Pessoa(String nome, int idade, String documento){
        this.nome = nome;
        this.idade = idade;
        this.documento =documento;
    }

    //método
    public void imprimirInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Documento: " + documento);
    }
}