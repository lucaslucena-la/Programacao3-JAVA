//2- estendendo a classe thread 

class Mytrhead extends Thread{
    public void run(){
        System.out.println("Thread executando");
    }
}

class Demo{
    public static void main(String args[]){
        Mytrhead t = new Mytrhead();
        t.start();
    }
}

// vantagens: mais intuitivo, mas restringe herança