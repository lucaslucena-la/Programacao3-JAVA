//controle de threads 

//principais métodos da classe Thread
/*
* getname() -> retorna o nome da thread
* setname() -> define o nome da thread
* getpriority() -> retorna a prioridade da thread
* sleep(ms) -> faz a thread dormir por um tempo em milisssegundos
* isAlive() -_ retorna true se a thread estiver viva
* yeld() -> faz a thread ceder o processador para outra thread 
* join() -> faz a thread esperar outra thread terminar 
*/


class Demo{
    public static void main(String args[]){ //exemplo de uso de join
        Thread t1 = new Thread(() -> { 
            try {Thread.sleep(5000);} catch (InterruptedException e){} // faz a thread dormir por 5 segundos
            System.out.println("Thread Finalizada");
        });

        try{
            t1.start();
            t1.join();// Aguarda t1 terminar antes de continuar
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

