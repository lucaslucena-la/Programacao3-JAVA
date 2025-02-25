class Contador {
    private int count = 0;

    synchronized void incrementar() {
        count++; // Pode ser acessado por várias threads ao mesmo tempo
    }

    int getValor() {
        return count;
    }
}

public class ComSincronizacao {
    public static void main(String[] args) {
        Contador contador = new Contador();

        Runnable tarefa = () -> {
            for (int i = 0; i < 100000; i++) {
                contador.incrementar();
            }
        };

        Thread t1 = new Thread(tarefa);
        Thread t2 = new Thread(tarefa);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        System.out.println("Valor final do contador: " + contador.getValor()); // Resultado pode variar!
    }
}
