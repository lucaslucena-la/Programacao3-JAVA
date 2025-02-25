public class ThreadManagement {
    public static void main(String[] args) {
        Thread gameLoop = new Thread(() -> {
            while (true) {
                System.out.println("Atualizando gráficos...");
            }
        });
        gameLoop.setPriority(Thread.MAX_PRIORITY);

        Thread autoSave = new Thread(() -> {
            while (true) {
                System.out.println("Salvando progresso...");
                try { Thread.sleep(5000); } catch (InterruptedException e) {}
            }
        });
        autoSave.setPriority(Thread.MIN_PRIORITY);

        gameLoop.start();
        autoSave.start();
    }
}
