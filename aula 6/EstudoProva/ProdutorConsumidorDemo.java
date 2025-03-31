/*
* ============================================================
* Exercício: Comunicação entre Threads (Produtor-Consumidor)
* Disciplina: Programação III
* Tema: Multithreading com sincronização (wait/notify)
*
* Enunciado:
* Implemente um buffer compartilhado onde um Produtor insere 
* números de 1 a 10, e um Consumidor lê e remove esses números.
*
* Requisitos:
* - Use wait() e notify() para evitar que:
*   - o Consumidor leia um buffer vazio
*   - o Produtor insira quando o buffer estiver cheio
* - O Produtor deve esperar caso o buffer esteja cheio
* - O Consumidor deve esperar caso o buffer esteja vazio
*
* Objetivo:
* Demonstrar o uso correto da comunicação entre threads usando 
* métodos de sincronização do Java.
* ============================================================
*/



class Buffer{
    private int valor;
    private boolean disponivel = false;// controla se o buffer está ocupado ou não

    //método chamado pelo produtor para inserir um número no buffer
    public synchronized void produzir (int valor){
        //se o buffer estiver cheio, o produtor espera
        while (disponivel) {
            try{
                wait();//espera até o consumidor consumir
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    
        //produzindo o valor
        this.valor = valor;
        System.out.println("Produtor produziu " + valor);
        disponivel = true;

        //notifica o consumidor que agora há um valor disponivel
    
    }

    //método chamado pelo consumidor para ler e remover o número do buffer
    public synchronized int consumir(){

        //se o buffer estiver vazio, o consumidor espera
        while (!disponivel) {
            try{
                wait();//espera até o produtor produzir algo
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        //consumindo o valor
        System.out.println("Consumidor consumiu: " + valor);

        //marca o buffer como vazio novamente
        disponivel = false;

        //notifica o produtor que agora há espaço no buffer
        notify();

        return valor;
    }

}

//casse produtor que insere valor de 1 a 10 no buffer
class Produtor extends Thread{
    private Buffer buffer;//refêrencia ao bufffer compartilhado

    //construtor que recebe o buffer
    public Produtor(Buffer buffer){
        this.buffer = buffer;
    }

    //método que será exexturado quando a thread for iniciada
    @Override
    public void run(){
        //produz valores de 1 a 10
        for (int i = 0; i <= 10; i++){
            buffer.produzir(i);//chamaa o método de produção no buffer

            try{
                Thread.sleep(500);//simula o tempo necessário para produzir
            } catch(InterruptedException e){
                e.printStackTrace();//trata interrupções enquanto dorme 
            }
        }
    }
}

//classe consumidor, responsável por sonsumir os valores do buffer
class Consumidor extends Thread {
    private Buffer buffer;//referência ao buffer compartilhado

    //construtor qu recebe buffer
    public Consumidor (Buffer buffer){
        this.buffer = buffer;
    }

    //método que será executada quando a thread for iniciada
    @Override
    public void run(){
        //consome 10 valores (deve ser a mesma quantidade produzida)
        for(int i = 0; i <= 10; i++){
            buffer.consumir();//chama o método de consumo no buffer

            try{
                Thread.sleep(800);//simula o tempo necessário para consumir
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class ProdutorConsumidorDemo{
    public static void main(String[] args) {
        //cria uma instãncia do buffer compartilhado
        Buffer bufferCompartilhado =  new Buffer();

        //cria as threas produtor e consumidro, passando o buffer compartilhado
        Produtor produtor = new Produtor (bufferCompartilhado);
        Consumidor consumidor = new Consumidor (bufferCompartilhado);

        produtor.start();
        consumidor.start();
        
    }
}
