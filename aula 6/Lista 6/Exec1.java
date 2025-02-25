public class Exec1 {

    public static void main(String[] args) {
        Thread AltaPrioridade = new Thread(() -> {
            for (int i =0; i <= 10; i++){
                System.out.println("Thread: Alta prioridade"+ ": " + i);
            }
        });

        AltaPrioridade.setPriority(Thread.MAX_PRIORITY);

        Thread MediaPrioridade = new Thread(() -> {
            for (int i =0; i <= 10; i++){
                System.out.println("Thread: Média prioridade" + ": " + i);
            }
        });

        MediaPrioridade.setPriority(Thread.NORM_PRIORITY);

        Thread BaixaPrioridade = new Thread(() -> {
            for (int i =0; i <= 10; i++){
                System.out.println("Thread: Baixa prioridade"+ ": " + i);
            }
        });

        BaixaPrioridade.setPriority(Thread.MIN_PRIORITY);

        AltaPrioridade.start();
        MediaPrioridade.start();
        BaixaPrioridade.start();

    }

}
