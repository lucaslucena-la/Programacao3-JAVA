import java.util.Random;

public class temperatura {
    public static void main(String[] args) {
        // Nome dos meses
        String[] meses = {"Jan", "Fev", "March", "Abr", "May", "Jun", "Jul", "Agost", "Set", "Out", "Nov", "Dez"};

        // Array para armazenar temperaturas
        double[] temperaturas = new double[12];
        Random random = new Random();

        // Preencher temperaturas com valores aleatórios entre -50 e 50
        for (int i = 0; i < temperaturas.length; i++) {
            temperaturas[i] = random.nextInt(101) - 50; // Gera valores de -50 a 50
        }

        
        // Encontrar mês com a maior e menor temperatura
        double maiorTemp = temperaturas[0];
        double menorTemp = temperaturas[0];
        int mesMaiorTemp = 0;
        int mesMenorTemp = 0;

        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > maiorTemp) {
                maiorTemp = temperaturas[i];
                mesMaiorTemp = i;
            }
            if (temperaturas[i] < menorTemp) {
                menorTemp = temperaturas[i];
                mesMenorTemp = i;
            }
        }

        // Exibir informações formatadas
        System.out.println("\nTemperaturas médias ao longo do ano:");
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println(meses[i] + ": " + temperaturas[i] + "°C");
        }
        System.err.println();

        // Cálculo da temperatura média anual
        double soma = 0;
        for (double temp : temperaturas) {
            soma += temp;
        }
        double mediaAnual = soma / temperaturas.length;

        // Identificar meses com temperaturas acima da média anual
        System.out.println("Meses com temperaturas acima da média anual:");
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > mediaAnual) {
                System.out.println(meses[i] + ": " + temperaturas[i] + "°C");
            }
        }

        System.out.println("\nTemperatura média anual: " + mediaAnual + "°C");
        System.out.println("Mês com a maior temperatura: " + meses[mesMaiorTemp] + " (" + maiorTemp + "°C)");
        System.out.println("Mês com a menor temperatura: " + meses[mesMenorTemp] + " (" + menorTemp + "°C)");
    }
}
