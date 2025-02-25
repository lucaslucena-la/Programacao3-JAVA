class Buffer {
    private int dado;
    private boolean disponivel = false;

    public synchronized void produzir(int valor) {
        while (disponivel) { // Espera enquanto o dado já está disponível
            try { wait(); } catch (InterruptedException e) {}
        }
        dado = valor;
        disponivel = true;
        System.out.println("Produzido: " + valor);
        notify(); // Avisa que um novo dado está disponível
    }

    public synchronized int consumir() {
        while (!disponivel) { // Espera até que um dado esteja disponível
            try { wait(); } catch (InterruptedException e) {}
        }
        disponivel = false;
        System.out.println("Consumido: " + dado);
        notify(); // Avisa que pode produzir outro item
        return dado;
    }
}

public class ProdutorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread produtor = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.produzir(i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        Thread consumidor = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.consumir();
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });

        produtor.start();
        consumidor.start();
    }
}
