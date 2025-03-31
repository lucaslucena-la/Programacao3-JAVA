/*
 * EXERCICIO 1
 * 
 * Crie tês threads, nomeando-as como "Alta Prioridade", "Média Pioridade" e "Baixa Prioridade" e defina suas prioridades como MAX_PRIORITY, NORM_PRIORITY E MIN_PRIORITY, respectivamente
 * 
 * Cada thread deve imprimir seu nome 10 vezes, Observe a ordem de execução e analise se a prioridade influencia o comportamento do sistema
 */


public class estudoPrioridade{
    

    public static void main (String[] args ){
        
        //criando a Thread de nome "Alta prioridade"
        Thread AltaPrioridade = new Thread(() -> {
            for(int i = 0; i <= 10; i++){
                System.out.println("Thread: Alta prioridade " + ": " + i );
            }
        });

        AltaPrioridade.setPriority(Thread.MAX_PRIORITY);//definindo a thread de nome AltaPrioridade com prioridade MAX_PRIORITY 

        Thread MediaPrioridade =  new Thread(()-> {
            for(int i = 0; i< 10; i ++){
                System.out.println("Thread: Média Prioridade " + ": " + i);
            }
        });

        MediaPrioridade.setPriority(Thread.NORM_PRIORITY);

        Thread BaixaPrioridade = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                System.out.println("Thread: Baixa Prioridade " + ": " + i);
            }
        });

        BaixaPrioridade.setPriority(Thread.MIN_PRIORITY);

        Thread t1 = BaixaPrioridade;
        Thread t2 = MediaPrioridade;
        Thread t3 = AltaPrioridade;
        
        t3.start();
        t2.start();
        t1.start();

    }
}
