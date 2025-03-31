
/*
* =============================================================
* Exercício: Evitando Deadlocks em Transferências Bancárias
* Disciplina: Programação III
* Tema: Concorrência e sincronização de threads (deadlock)
*
* Enunciado:
* - Crie duas contas bancárias (ContaA e ContaB), com saldo inicial de 1000 cada.
* - Duas threads tentarão transferir R$200 uma para a outra simultaneamente.
* - Problema: se as threads bloquearem as contas em ordens diferentes, ocorre deadlock.
* - Solução: ordenar os bloqueios usando IDs únicos das contas ou outra lógica para evitar deadlock.
*
* Objetivo:
* Demonstrar como deadlocks surgem em situações reais e como evitá-los com técnicas de ordenação de bloqueios.
* =============================================================
*/


//classe que representa uma conta bancária
class Conta{
    private int id;//Id único para cada conta (usado na ordenação dos bloqueios) 
    private double saldo;//saldo da conta
    private String nome;//nome da conta (ex: ContaA ContaB)

    //construtor da conta
    public Conta (int id, String nome, double saldo){
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
    }

    //método para retirar um valor do saldo
    public void sacar(double valor){
        saldo = saldo - valor;
    }

    //método para adicionar um valor ao saldo 
    public void depositar(double valor){
        saldo = saldo + valor;
    }

    //retorna o saldo atual
    public double getSaldo(){
        return saldo;
    }

    public String getNome(){
        return nome;
    }

    public int getId(){
        return id;
    }
}

//classe que representa a operação de transfêrencia segura entre duas contas
class Transferencia{
    //método para transferir valor de uma conta para outra evitando deadlock
    public static void transferirSemDeadlock(Conta origem, Conta destino, double valor){
        //define uma ordem de bloqueio com base no ID da conta
        Conta primeira, segunda;

        if(origem.getId() < destino.getId()){
            primeira = origem;
            segunda = destino;
        }else{
            primeira = destino;
            segunda = origem;
        }

        //bloqueio a primeira conta
        synchronized(primeira){

            //pausa proposital para simular concorrência e aumentar chance de deadlock
            try {Thread.sleep(100);}catch(InterruptedException e){}

            //bloqueia a segunda conta

            synchronized (segunda){
                //verifica se a conta de origem tem saldo suficiente
                if(origem.getSaldo() >= valor){
                    origem.sacar(valor); //retira da orgigem
                    destino.depositar(valor);//deposita no destino
                
                    //imprime o sucesso da transfêrencia
                    System.out.println("Transfêrencia de R$ " + valor + " de " + origem.getNome() + " para " + destino.getNome());
                    
                
                }else{
                    //caso não tenha saldo suficiente:
                    System.out.println("Saldo insuficiente em " + origem.getNome());
                }
            }

        }

    }
}

//classe que define uma thread que realiza uma transfêrencia
class ThreadTransferencia extends Thread{
    private Conta origem;
    private Conta destino;
    private double valor;



    public ThreadTransferencia(Conta origem, Conta destino, double valor){
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }


    //método que será executado quando a thread iniciar
    @Override
    public void run(){
        //chama o método de transfêrencia segura
        Transferencia.transferirSemDeadlock(origem, destino, valor);
    }
}

public class EvitaDeadlockDemo {
    public static void main (String[] args){
        //cria duas contas com saldo inicial de R$1000 e id diferentes
        Conta contaA = new Conta (1, "ContaA", 1000);
        Conta contaB = new Conta (2, "ContaB", 1000);
    
        //cria duas threas de transfêrencia (uma de A para B e outra de B para A)
        Thread t1 = new ThreadTransferencia(contaA, contaB, 200);
        Thread t2 = new ThreadTransferencia(contaB, contaA, 200);
    
        t1.start();
        t2.start();
    }
}
