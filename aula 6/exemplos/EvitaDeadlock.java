class Recurso {}

class TarefaEvitaDeadlock implements Runnable {
    private Recurso recursoA;
    private Recurso recursoB;
    private String nome;

    public TarefaEvitaDeadlock(Recurso r1, Recurso r2, String nome) {
        // Garante uma ordem fixa dos recursos
        if (System.identityHashCode(r1) < System.identityHashCode(r2)) {
            this.recursoA = r1;
            this.recursoB = r2;
        } else {
            this.recursoA = r2;
            this.recursoB = r1;
        }
        this.nome = nome;
    }

    public void run() {
        synchronized (recursoA) {  // Sempre bloqueia o menor ID primeiro
            System.out.println(nome + " bloqueou " + recursoA);

            try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (recursoB) { // Agora bloqueia o segundo
                System.out.println(nome + " bloqueou " + recursoB);
            }
        }
    }
}

public class EvitaDeadlock {
    public static void main(String[] args) {
        Recurso recursoA = new Recurso();
        Recurso recursoB = new Recurso();

        Thread t1 = new Thread(new TarefaEvitaDeadlock(recursoA, recursoB, "Thread-1"));
        Thread t2 = new Thread(new TarefaEvitaDeadlock(recursoB, recursoA, "Thread-2"));

        t1.start();
        t2.start();
    }
}
