import java.util.Arrays;

class Experimento{
    private String nome;
    double resultados[];

    Experimento ( String nome, double ... result){
        this.nome =  nome;
        this.resultados = result;
    }

    String getNome (){
        return nome;
    }

    double [] getResultados(){
        return resultados;
    }

    public double calcularMedia() {
        if (resultados.length == 0) {
            return 0;
        }
        double soma = 0;
        for (double resultado : resultados) {
            soma += resultado;
        }
        return soma / resultados.length;
    }

    public double calcularDesvioPadrao(){
        if (resultados.length == 0){
            return 0;
        }

        double media = calcularMedia();
        int i = 0;
        double somaQuadrados = 0;
        for (double resultado : resultados) {
            somaQuadrados += Math.pow(resultado - media, 2);
            i++;
        }
        return Math.sqrt(somaQuadrados / (i - 1) );


    }

    public void  imprime(){
        System.out.println("Média: " + calcularMedia()+ " Desvio padrão: " + calcularDesvioPadrao());
    }
}


public class Main2 {
    public static void main(String[] args) {
        double amostra [] = {10, 15, 20 , 50, 90, 80};
        Experimento e = new Experimento("qualquer", amostra);

        e.imprime();
        
    }
}
