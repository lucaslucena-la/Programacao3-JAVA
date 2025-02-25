class Sensor extends Thread {
    public void run() {
        while (true) {
            System.out.println("Coletando dados do sensor...");
            try {
                Thread.sleep(10000); // Aguarda 10 segundos antes de coletar novamente
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida.");
            }
        }
    }
}

public class IoTExample {
    public static void main(String[] args) {
        new Sensor().start();
    }
}
