class MyFirstThread extends Thread {
    public void run() {
        System.out.println("Thread executando");
    }
}

class Shared {
    public boolean disponivel;
    synchronized void show(String msg) {
        System.out.print("[" + msg);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println("]");
    }

    synchronized void get() {
        while (!disponivel)
            try {
                wait();
                System.out.println("Consumindo");
                disponivel = false;
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

class Recurso {
    synchronized void metodo(Recurso r) {
        r.metodo(this);
    }
}

class Demo {
    public static void main(String args[]) {
        
        Thread t1 = new Thread(() -> {
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            System.out.println("Thread finalizada");
        });

        try {
            t1.start();
            t1.join(); // Aguarda t1 terminar antes de continuar    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}