/*
 * Crie uma classe Contador com um atributo int valor, inicializado em 0. Duas threads (Incrementador
    e Decrementador) devem, respectivamente, incrementar e decrementar o valor 10000 vezes.
    Sem synchronized, o resultado final pode ser inconsistente. Com synchronized, garanta que a
    saıda sempre seja 0
 * 
 * 
 */


class Contador{
    private int count = 0;

    synchronized void incrementar(){
        count ++;
    }

    synchronized void decrementar(){
        count --;
    }

    int getValor(){
        return count ;
    }
}


public class Exec2 {
    public static void main(String[] args) {
        Contador contador = new Contador();

        Runnable tarefa = () ->{
            for (int i = 0; i < 10000; i++){
                contador.incrementar();
            } 

            for (int i = 0; i < 10000; i++){
                contador.decrementar();
            }

        };


        Thread t1 = new Thread(tarefa);
        Thread t2 = new Thread(tarefa);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch(InterruptedException e){}

        System.out.println("Valor final do contador: "+ contador.getValor());
    }
}
