
//criando threads em java
//implementando runnabeble

public class estudo1{
    
    
    

    public static void main(String args[]){

        class MyThread implements Runnable{
            public void run(){
                System.out.println("Thread executando");
            }
        }
        
        class MyThread2 implements Runnable{
            public void run(){
                System.out.println("Thread 2 executando");
            }
        }

        Thread t = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread2());

        t.start();
        t2.start();
    }
    
}

//vantagens: permite herança de outra classe