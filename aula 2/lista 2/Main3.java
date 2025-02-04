import java.util.ArrayList;
import java.util.List;


class Departamento{
    private String nomeDp;
    private List<Funcionario> funcionarios;

    Departamento(String nomeDp){
        this.nomeDp = nomeDp;
        this.funcionarios = new ArrayList<>();

    }

    public String getNome() {
        return nomeDp;
    }
    
    class Funcionario{
        private String nomeFuncionario;
        private String cargo;
        private double salario;

        Funcionario(String nomeFuncionario,String cargo,double salario ){
            this.nomeFuncionario = nomeFuncionario;
            this.cargo = cargo;
            this.salario = salario;
        }

        public void exibirDetalhes(){
            System.out.println("Nome: " + nomeFuncionario);
            System.out.println("Cargo: " + cargo);
            System.out.println("Salario: " + salario);
        }
    }

    
    public void adicionarFuncionario(String nome, String cargo, double salario){
        Funcionario funcionario = new Funcionario(nome, cargo, salario) ;
        funcionarios.add(funcionario); // Adiciona o funcionário à lista
  
    }

    public void listarFuncionarios(){
        System.out.println("Departamento: " + nomeDp);

        if(funcionarios.isEmpty()){
            System.out.println("Não há funionários neste departamento");
        }else{
            for(Funcionario funcionario : funcionarios){
                funcionario.exibirDetalhes();
            }
        }
        System.out.println();
    }
}

class Organizacao{
    private List<Departamento> departamentos;

    public Organizacao(){
        this.departamentos = new ArrayList<>();
    }

    public Departamento adicionarDepartamento(String nomeDp){
        Departamento novDepartamento = ( new Departamento(nomeDp));
        departamentos.add(novDepartamento); // Adiciona à lista de departamentos

        return novDepartamento;

    }

    public void listarDepartamentos(){
        for(Departamento departamento: departamentos){
            departamento.listarFuncionarios();
        }
    }
}

public class Main3 {
    public static void main(String [] args) {
        Organizacao org = new Organizacao ();

        Departamento ti = org.adicionarDepartamento("TI");
        ti.adicionarFuncionario("Joao", "Desenvolvedor", 5000.0);
        ti.adicionarFuncionario("Ana", "Analista", 6000.0);
        Departamento rh = org.adicionarDepartamento("Recursos Humanos");
        
        rh.adicionarFuncionario("Carlos", "Gestor", 4500.0);
        
        org.listarDepartamentos ();
    }
}