/*
 * EXERCICIO 2
 * Crie uma classe Contador com um atribuito int valo, inicializado em 0. Duas Threads (Incrementados e Decrementador) devem, respectivamente, incrementar e decrementar o valor em 1000 vezes.
 * Sem synchronized, o resultador finl pode ser inconsistente, com synchronized, garante que a saíja sempre seja 0.
 * 
 */



//classe contador 

//synchronized é um modificador de acesso que permite que apenas uma thread acesse o método ou bloco de código ao mesmo tempo, evitando condições de corrida e garantindo a integridade dos dados compartilhados entrew as threads

class Contador {
    private int valor = 0; //atributo inicializado em 0

    //método para incrementar o valor
    //synchronized garante que apenas uma thread possa acessa o método por vez
    public synchronized void incrementar (){
        valor ++;
    }

    //método para decrementar o valor
    public synchronized void decrementar (){
        valor --;
    }

    
    int getValor(){
        return valor;
    }
    
}

public class EstudoSynchronized {
    public static void main(String[] args){
        Contador contador = new Contador();

        //cria uma tarefa que incrementa e decrementa o valor em 10000 vezes
        //Runnable é uma interfacr funcional que representa uma tarefa que pode er executada por uma thread 

        Runnable tarefa = () ->{
            for (int i = 0 ; i< 10000; i++){
                contador.incrementar();
            }

            for(int i = 0; i< 10000; i++){
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
        }catch(InterruptedException e){};

        System.out.println("Valor final do contador :" + contador.getValor());

    }
}
