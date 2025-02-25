class Recurso {}

class Tarefa implements Runnable {
    private Recurso recursoA;
    private Recurso recursoB;
    private String nome;

    public Tarefa(Recurso recursoA, Recurso recursoB, String nome) {
        this.recursoA = recursoA;
        this.recursoB = recursoB;
        this.nome = nome;
    }

    public void run() {
        synchronized (recursoA) {
            System.out.println(nome + " bloqueou recursoA");

            try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (recursoB) {
                System.out.println(nome + " bloqueou recursoB");
            }
        }
    }
}

public class DeadlockExemplo {
    public static void main(String[] args) {
        Recurso recursoA = new Recurso();
        Recurso recursoB = new Recurso();

        Thread t1 = new Thread(new Tarefa(recursoA, recursoB, "Thread-1"));
        Thread t2 = new Thread(new Tarefa(recursoB, recursoA, "Thread-2")); // Inverte a ordem!

        t1.start();
        t2.start();
    }
}
