import java.util. *;

public class contagem {

    public static void main (String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Escreva uma Frase: ");
        String frase = scanner.nextLine();

        System.out.println(frase);

        // Remove vírgulas, pontos e outros sinais de pontuação
        String fraseNova = frase.replaceAll("[.,!?]", "");

        // Converte para minúsculas
        String Resultado = fraseNova.toLowerCase();
        
        // Quebra a frase em palavras
        String [] palavras = Resultado.split("\\s+");

        Map<String, Integer> contagemPalavras = new HashMap<>();
        
        //Percorre cada palavra do array e utiliza a contagem no HashMap
        for (String palavra : palavras){
            //se a palavra já existir, incrementa +1, se não existir começa com 1
            contagemPalavras.put(palavra, contagemPalavras.getOrDefault(palavra, 0)+ 1);
        }

        //exibe a contagem de cada palavra distinta no texto
        System.out.println("Contagem de Palavras distintas: ");
        
        // Percorre o HashMap usando um for-each para exibir chave (palavra) e valor (quantidade)
        for(Map.Entry<String, Integer> entry: contagemPalavras.entrySet()){
            // entry.getKey() -> retorna a palavra  
            // entry.getValue() -> retorna a contagem da palavra
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        
        scanner.close();
    }
}