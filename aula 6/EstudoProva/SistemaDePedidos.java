/*
* =============================================================
* Exercício: Simulando um Sistema de Pedidos Online
* Disciplina: Programação III
* Tema: Comunicação entre threads com wait() e notify()
*
* Enunciado:
* - Um Cliente adiciona 5 pedidos a uma lista compartilhada.
* - Um Atendente processa os pedidos, um por vez, removendo da lista.
* - O Atendente deve usar wait() para aguardar caso a lista esteja vazia.
* - O Cliente deve usar notify() sempre que adicionar um novo pedido.
*
* Objetivo:
* Demonstrar a comunicação e sincronização entre threads
* usando um buffer (lista) compartilhado, evitando polling.
* =============================================================
*/


import java.util.*;


//class que representa a lista compartilhada de pedidos
class ListaDePedidos{
    private List<String> pedidos = new LinkedList<>();//Lista qque armazena os pedidos

    //método sincronizado para adicionar um pedido à lista
    public synchronized void adicionarPedido(String pedido){
        pedidos.add(pedido);//adiciona o pedido à lista
        System.out.println("Cliente adicionou pedido: "+ pedido);
        notify();//acorda o atendente, caso ele esteja esperando
    }


    //método sincronizado para remover um pedido da lista
    public synchronized String processarPedido(){
        //enquanto a lista estiver vazia, o atendente espera
        while (pedidos.isEmpty()) {
            try{System.out.println("Atendente aguardandno novos pedidos");
                wait();//libera o monitor e espera ser notificado
            }catch(InterruptedException e){
                e.printStackTrace();//trata interrupções durante o wait
            }
        }

        //remove o primeiro pedido da lista
        String pedido = pedidos.remove(0);
        System.out.println("Antendente processou pedido: " + pedido);
        return pedido;
    }

}


//classe cliente (thread que gera pedidos)
class Cliente extends Thread {
    private ListaDePedidos lista;

    public Cliente(ListaDePedidos lista){
        this.lista = lista;
    }

    @Override
    public void run(){
        //simula 5 pedidod sendo feitos pelo cliente
        for(int i = 1; i <= 5; i++){
            String pedido = "Pedido #" + i;
            lista.adicionarPedido(pedido);//adiciona na lista;
        
            try{
                Thread.sleep(500);//simula o tempo entre pedidos
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        
        }
    }
}

//classe atendente(thread que processa pedidos)
class Atendente extends Thread{
    private ListaDePedidos lista;

    public Atendente(ListaDePedidos lista){
        this.lista = lista;
    }

    @Override
    public void run(){
        //simula 5 pedidos(samebos que o cliente vai gerar 5)
        for( int i = 0; i < 5; i++){
            lista.processarPedido();//prcessa e remove um pedido

            try{
                Thread.sleep(800); //simula tempo de processamento
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class SistemaDePedidos {
    public static void main(String[] args) {
        ListaDePedidos listaCompartilhada = new ListaDePedidos();//cria o buffer compartilhado

        //cria as threads cliente e atendende
        Cliente cliente = new Cliente (listaCompartilhada);
        Atendente atendente = new Atendente(listaCompartilhada);

        cliente.start();
        atendente.start();


    }
}
