public class Paciente extends Pessoa{
    String matricula;
    String planoDeSaude;

    Paciente (String matricula, String planoDeSaude, String nome, int idade, String documento){
        super(nome,idade,documento);
        
        this.matricula = matricula;
        this.planoDeSaude = planoDeSaude;

    }

    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Matrícula: " + matricula);
        System.out.println("Plano de saúde: " + planoDeSaude);
        
    }
}
