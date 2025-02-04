import java.util. *;

public class ListaAluno{
    public static void main (String [] args){
        Map<Integer, String> mapa = new TreeMap<>();
        mapa.put(123, "João");
        mapa.put(213, "Lucas");
        mapa.put(323, "Maria");
        mapa.put(132, "Sandino");
        mapa.put(456, "Ana");

        mapa.entrySet().stream().sorted(Map.Entry.<Integer,String>comparingByValue()).forEach(System.out::println);

        int id = 132;
        mapa.remove(id);

        System.out.println("Aluno da chave " + id + " Removido");

        



    }
}