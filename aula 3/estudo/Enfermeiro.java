public class Enfermeiro extends Pessoa {
    String setor;
    int horasTrabaho;
    String numeroCadastro;

    Enfermeiro(String setor, int horasTrabaho, String numeroCadastro, String nome, int idade, String documento){
        super(nome, idade, documento);
        this.setor = setor;
        this.horasTrabaho = horasTrabaho;
        this.numeroCadastro = numeroCadastro;
    }

    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Setor: " + setor);
        System.out.println("horasTrabaho: " + horasTrabaho);
        System.out.println("numeroCadastro: " + numeroCadastro);
    }
}
