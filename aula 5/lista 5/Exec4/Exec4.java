package Exec4;
// Implemente uma classe SaldoInsuficienteException e use-a na classe ContaBancaria.
// A classe ContaBancaria deve conter:
// 1. Um metodo sacar(double valor), que lanca SaldoInsuficienteException caso o saldo seja menor que o valor do saque.
// 2. Um metodo depositar(double valor), que adiciona saldo a conta.
// 3. O metodo main() deve testar saques validos e invalidos.
// Dica: SaldoInsuficienteException deve ser uma Checked Exception


//main
public class Exec4 {

    public static void main (String [] args){
        ContaBancaria conta = new ContaBancaria(500);

        try {
            conta.sacar(600.70);
        }catch (SaldoInsuficienteException e ){
            System.out.println(e.getMessage());
        }

        try {
            conta.sacar(150.60);
        }catch (SaldoInsuficienteException e ){
            System.out.println(e.getMessage());
        }

        conta.depositar(600);
        
    
    }

}
