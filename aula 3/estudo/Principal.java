public class Principal {
    public static void main(String[] args) {
        System.out.println("Classe Pessoa");
        Pessoa pessoa = new Pessoa("Gelsiany", 27, "199.343.938-34");
        pessoa.imprimirInfo();
        System.out.println();
        
        System.out.println("Classe Paciente");
        Pessoa paciente = new Paciente("1234", "Convênio notredame", "Maria", 50, "903.344.345-98");
        paciente.imprimirInfo();
        System.out.println();

        System.out.println("Classe enfermeiro");
        Pessoa enf = new Enfermeiro("Triagem", 10, "23452", "Maria", 28, "198.434.235-92");
        enf.imprimirInfo();
        System.out.println();


    }
}
