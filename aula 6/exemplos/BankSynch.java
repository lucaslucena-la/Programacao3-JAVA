public class BankSynch {
    private int saldo = 1000;

    void sacar(int valor) {
        synchronized (this) { // Apenas essa parte é sincronizada
            if (saldo >= valor) {
                saldo -= valor;
                System.out.println(Thread.currentThread().getName() + " sacou " + valor);
            } else {
                System.out.println(Thread.currentThread().getName() + " tentou sacar " + valor + " (Saldo insuficiente)");
            }
        }
    }

    int getSaldo() {
        return saldo;
    }
}