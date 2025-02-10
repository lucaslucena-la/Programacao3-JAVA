package Exec4;

class ContaBancaria {

    private double saldo;
    
    //construtor da classe ContaBancaria que recebe o saldo inicial da conta como parametro 
    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }

    //metodo que realiza o saque na conta
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo){
            System.out.println("Saldo: " + saldo);
            System.out.println("Realizando saque de " + valor);
            throw new SaldoInsuficienteException("ERRO: Saldo insuficiente para realizar o saque");
        } else {
            System.out.println("Saldo: " + saldo);
            System.out.println("Realizando saque de " + valor);
            saldo -= valor;
            System.out.println("Saque realizado com sucesso");
            System.out.println("Saldo atual: " + saldo);
        }
    }

    //metodo que realiza o deposito na conta
    public void depositar(double valor) {
        saldo += valor;
    }
}