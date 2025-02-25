class ProcessaTransacao extends Thread {
    private int id;

    public ProcessaTransacao(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Processando transação " + id);
        try {
            Thread.sleep(3000); // Simula tempo de processamento
        } catch (InterruptedException e) {}
        System.out.println("Transação " + id + " concluída.");
    }
}

public class Banco {
    public static void main(String[] args) {
        ProcessaTransacao t1 = new ProcessaTransacao(1);
        ProcessaTransacao t2 = new ProcessaTransacao(2);

        t1.start();
        t2.start();

        try {
            t1.join(); // Aguarda transação 1 terminar antes de continuar
            t2.join(); // Aguarda transação 2 terminar antes de continuar
        } catch (InterruptedException e) {}

        System.out.println("Todas as transações foram processadas. Exibindo saldo.");
    }
}
