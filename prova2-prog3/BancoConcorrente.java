class ContaBancaria {
        private int saldo = 0;
        // # TODO 1: Tornar o metodo depositar sincronizado

        public synchronized void depositar ( int valor ) {
            saldo += valor ;
        }

        int getSaldo () {
            return saldo ;
        }
    }

public class BancoConcorrente {
    public static void main ( String [] args ) {
        ContaBancaria conta = new ContaBancaria ();
        
        Runnable tarefaDeposito = () -> {
        
            for ( int i = 0; i < 100000; i++) {
            // # TODO 2: Depositar 1 unidade na conta
                conta.depositar (1);
            
            }
        
        };

        // # TODO 3: Criar duas threads com a mesma tarefa e iniciar ambas
        Thread t1 = new Thread ( tarefaDeposito );
        Thread t2 = new Thread ( tarefaDeposito );

        t1 . start ();
        t2 . start ();

        // # TODO 4: Esperar ambas as threads terminarem
        try {
            t1 . join ();
            t2 . join ();
        } catch ( InterruptedException e ) {}
            System.out.println ( " Saldo final : " + conta.getSaldo ());
        
    }

    
}