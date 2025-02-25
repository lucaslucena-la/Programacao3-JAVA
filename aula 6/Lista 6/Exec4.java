class Conta{
    private int saldo;
    private final String nome;

    ///construtor da conta
    public Conta(String nome, int saldoInicial){
        this.nome = nome;
        this.saldo = saldoInicial;
    }

    public int getSaldo(){
        return saldo;
    }

    public String getNome(){
        return nome;
    }

    //método para adicionar um valor ao saldo da conta
    public void depositar(int valor){
        saldo += valor;
    }  

    //método para retirar valor da conta
    public void sacar(int valor ){
        saldo -= valor;
    }
}

class Transferencia{
    public static void transferir(Conta origem, Conta destino, int valor){
        //para evitar deadlock, sempre bloqueamos as conas na mesma orde
        //ultilizar System.identityHashCode() para definir a ordem de bloqueio
        Conta primeiro = (System.identityHashCode(origem)< System.identityHashCode(destino)) ? origem:destino;
        Conta segundo = (primeiro == origem)? destino : origem;

        //bloqueio da primeira conta
        synchronized (primeiro){
            //bloqueio da segunda conta
            synchronized(segundo){
                if(origem.getSaldo() >= valor){
                    origem.sacar(valor);
                    destino.depositar(valor);
                    System.out.println(Thread.currentThread().getName() + " Transferiu "+ valor + " de "+ origem.getNome() + " para " + destino.getNome());

                }else{
                    System.out.println(Thread.currentThread().getName() + " tentou transfrir "+ valor + ", mas não há saldo suficiente em " + origem.getNome());
                }
            }//fim do bloqueio da segunda conta
        }//fim do bloqueio da primeira conta
    
    }
}



public class Exec4 {
    public static void main(String[] args) {
        Conta contaA = new Conta ("ContaA", 1000);
        Conta contaB = new Conta ("ContaB", 1000);
    
        Thread t1 = new Thread(() -> Transferencia.transferir(contaA, contaB, 200), "Thread-1");
        Thread t2 = new Thread(() -> Transferencia.transferir(contaB, contaA, 200), "Thread-2");
    
        t1.start();
        t2.start();
    
        try{
            t1.join();
            t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + contaA.getNome() + " = " + contaA.getSaldo() + ", " +contaB.getNome() + " = " + contaB.getSaldo());

    }
}
