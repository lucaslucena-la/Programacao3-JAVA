class MyThread extends Thread {
    public MyThread(String name) {
        super(name); // Define o nome da thread
    }

    public void run() {
        System.out.println("Thread iniciada: " + getName() + " com prioridade " + getPriority());

        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Contador: " + i);
            
            try {
                Thread.sleep(500); // Faz a thread dormir por 500ms
            } catch (InterruptedException e) {
                System.out.println(getName() + " foi interrompida.");
            }

            if (i == 3) {
                System.out.println(getName() + " chamando yield()");
                Thread.yield(); // Cede tempo para outra thread rodar
            }
        }

        System.out.println("Thread finalizada: " + getName());
    }
}

public class ThreadMethodsExample {
    public static void main(String[] args) {
        // Criando 3 threads
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");

        // Ajustando prioridades
        t1.setPriority(Thread.MIN_PRIORITY);  // Prioridade 1
        t2.setPriority(Thread.NORM_PRIORITY); // Prioridade 5 (padrão)
        t3.setPriority(Thread.MAX_PRIORITY);  // Prioridade 10

        // Iniciando as threads
        t1.start();
        t2.start();
        t3.start();

        // Verificando se as threads estão ativas
        System.out.println("\nVerificando se as threads estão vivas:");
        System.out.println(t1.getName() + " está viva? " + t1.isAlive());
        System.out.println(t2.getName() + " está viva? " + t2.isAlive());
        System.out.println(t3.getName() + " está viva? " + t3.isAlive());

        // Usando join() para esperar todas as threads finalizarem antes de continuar
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread principal interrompida.");
        }

        // Verificando se as threads ainda estão ativas após join()
        System.out.println("\nVerificando novamente se as threads estão vivas:");
        System.out.println(t1.getName() + " está viva? " + t1.isAlive());
        System.out.println(t2.getName() + " está viva? " + t2.isAlive());
        System.out.println(t3.getName() + " está viva? " + t3.isAlive());

        System.out.println("\nThread principal finalizada.");
    }
}
