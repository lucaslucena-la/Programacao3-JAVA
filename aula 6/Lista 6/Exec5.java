import java.util.*;

class Pedido{
    private static int contador = 0;
    private final int id;

    public Pedido(){
        this.id = ++contador;
    }

    public int getId(){
        return id;
    }
}

class SistemaPedidos{
    private final Queue<Pedido> pedidos = new LinkedList<>();

    //método pra adicionar um pedido a lista compartilhada
    public synchronized void adicionarPedido(){
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        System.out.println("Cliente adicinou pedido #" + pedido.getId());
        notify();//notifica o atendendo que há um novo pedidio

    }

    //método para sicronizar um pedido
    public synchronized void processarPedido(){
        while (pedidos.isEmpty()) {
            try{
                System.out.println("Atendente aguardando pedidos...");
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    
        Pedido pedido = pedidos.poll();
        System.out.println("Atendente processou pedido #" + pedido.getId());
    
    }
    
}

class Cliente extends Thread{
    private final SistemaPedidos sistema;

    public Cliente (SistemaPedidos sistema){
        this.sistema =  sistema;
    }

    @Override
    public void run(){
        for (int i =0; i < 5; i++){
            sistema.adicionarPedido();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Atendente extends Thread{
    private final SistemaPedidos sistema;

    public Atendente(SistemaPedidos sistema){
        this.sistema = sistema;
    }


    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            sistema.processarPedido();
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



public class Exec5 {
    public static void main(String[] args) {
        
        SistemaPedidos sistema = new SistemaPedidos();

        Cliente cliente = new Cliente(sistema);
        Atendente atendene = new Atendente(sistema);

        cliente.start();
        atendene.start();


        try {
            cliente.join();
            atendene.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Todos os pedidos foram processados!");

    }
}
