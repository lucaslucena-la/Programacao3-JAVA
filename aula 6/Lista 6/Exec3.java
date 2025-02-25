/*Implemente um buffer compartilhado onde um Produtor insere números de 1 a 10, e um Consumidor
le e remove esses n ́umeros.

•Use wait() e notify() para evitar que o Consumidor leia um buffer vazio ou o Produtor tente
inserir quando o buffer estiver cheio.

•O Produtor deve esperar caso o buffer esteja cheio e so continuar quando houver espaco disponıve */

class Buffer{
    private int dado;
    private boolean cheio = false;

    public synchronized void inserir (int valor){
        while(cheio){
            try {wait();}catch(InterruptedException e){}
        }

        dado = valor;
        cheio = true;
        System.out.println("Produzido: "+ valor);
        notify();
    }

    public synchronized int consumir(){
        while (!cheio) {
            try {wait();}catch(InterruptedException e){}
        }
        cheio = false;
        System.out.println("Consumido: "+ dado);
        notify();
        return dado;
    }
}



public class Exec3 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();


        Thread produtor = new Thread(()->{
            for (int i =1; i<= 10; i++){
                buffer.inserir(i);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });
       
        Thread consumidor = new Thread(()->{
            for (int i =1; i<= 10; i++){
                buffer.consumir();
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });

        produtor.start();
        consumidor.start();

    }
}